package com.bookstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	private Long id;
	private String name;
	private String code;
	private String price;
	private String authors;
	private Date publishedOn;
	private byte[] bimage;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	@Column(length = 15, nullable = false)
	public String getCode() {
		return code;
	}

	@Column(length = 10)
	public String getPrice() {
		return price;
	}

	@Column(nullable = false)
	public String getAuthors() {
		return authors;
	}

	

	@Column(name = "published_date")
	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	

	public void setPublishedOn(Date date) {
		this.publishedOn = date;
	}
	@Lob
	@Column(name = "bimage")
	public byte[] getBimage() {
		return bimage;
	}

	public void setBimage(byte[] bimage) {
		this.bimage = bimage;
	}
	

}
