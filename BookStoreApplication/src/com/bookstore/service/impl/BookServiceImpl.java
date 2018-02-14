package com.bookstore.service.impl;

import java.util.List;

import com.bookstore.dao.BookDao;
import com.bookstore.model.Book;
import com.bookstore.service.BookService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Transactional 
	public void saveBook(Book book) {
		bookDao.saveBook(book);
		
	}

	@Transactional 
	public List<Book> listBooks() {
		return bookDao.listBooks();
	}

	@Transactional 
	public Book getBook(Long id) {
		return bookDao.getBook(id);
	}

	@Transactional 
	public void deleteBook(Long id) {
		bookDao.deleteBook(id);

	}

	@Transactional 
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

}
