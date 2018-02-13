package com.bookstore.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import com.bookstore.utility.ApplicationConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestController
@RequestMapping(ApplicationConstants.DEFAULT_URI)
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = { ApplicationConstants.DEFAULT, ApplicationConstants.GET_BOOK_LIST })
	public ResponseEntity<List<Book>> listBooks(Map<String, Object> map) {
		return new ResponseEntity<List<Book>>(bookService.listBooks(), HttpStatus.OK);
	}

	@RequestMapping(value = ApplicationConstants.GET_BOOK)
	public ResponseEntity<Book> getBook(@PathVariable Long bookId) {
		Book book = bookService.getBook(bookId);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@RequestMapping(value = ApplicationConstants.SAVE_BOOK, method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveBook(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = ApplicationConstants.NAME, required = true) String name,
			@RequestParam(value = ApplicationConstants.AUTHOR, required = true) String author,
			@RequestParam(value = ApplicationConstants.PUBLISHEDON, required = true) String publishOn,
			@RequestParam(value = ApplicationConstants.PRICE, required = true) String price,
			@RequestParam(value = ApplicationConstants.CODE, required = true) String code) throws Exception {

		String sDate = publishOn;
		Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate);

		Book book = new Book();
		book.setName(name);
		book.setAuthors(author);
		book.setCode(code);
		book.setBimage(file.getBytes());
		book.setPrice(price);
		book.setPublishedOn(date);
		bookService.saveBook(book);
		return new ResponseEntity<String>("Book saved successfully!", HttpStatus.OK);
	}

	@RequestMapping(value = ApplicationConstants.DELETE_BOOK, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteBook(@PathVariable("bookId") Long id) {
		bookService.deleteBook(id);
		return new ResponseEntity<String>("Book deleted successfully!", HttpStatus.OK);
	}
}
