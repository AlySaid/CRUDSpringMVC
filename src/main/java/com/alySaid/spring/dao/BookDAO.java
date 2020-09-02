package com.alySaid.spring.dao;

import java.util.List;

import com.alySaid.spring.model.Book;


public interface BookDAO {
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
