package com.bookstore.dao.impl;

import java.util.List;

import com.bookstore.dao.BookDao;
import com.bookstore.model.Book;


import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl extends HibernateDaoSupport implements BookDao {

	public void saveBook(Book book) {
		this.getSessionFactory().getCurrentSession().save(book);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Book> listBooks() {
		return this.getSessionFactory().getCurrentSession().createCriteria(Book.class).list();
	}

	public Book getBook(Long id) {
		return (Book) this.getSessionFactory().getCurrentSession().get(Book.class, id);
	}

	public void deleteBook(Long id) {
		Book book = getBook(id);
		if (null != book) {
			this.getSessionFactory().getCurrentSession().delete(book);
		}

	}

}
