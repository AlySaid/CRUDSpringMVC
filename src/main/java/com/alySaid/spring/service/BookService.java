package com.alySaid.spring.service;

import java.util.List;

import com.alySaid.spring.model.Book;

public interface BookService {
	//Save the record
	long save(Book book);
	
	//Get single method
	Book get(long id);
	
	//get all records
	List<Book>list();

	//Update record
	void update(long id, Book book);
	
	//delete
	void delete(long id);
}
