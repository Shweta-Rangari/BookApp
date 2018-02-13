package com.bookstore.dao;

import java.util.List;
import com.bookstore.model.Book;

public interface BookDao {
	public void saveBook(Book book); 
	public List<Book> listBooks();
	public Book getBook(Long id);
	public void deleteBook(Long id);
}
