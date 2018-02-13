package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;

public interface BookService {
	
	public void saveBook(Book book);
	public List<Book> listBooks();
	public Book getBook(Long id);
	public void deleteBook(Long id);

}
