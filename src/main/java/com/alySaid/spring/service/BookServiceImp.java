package com.alySaid.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alySaid.spring.dao.BookDAO;
import com.alySaid.spring.model.Book;

@Service
public class BookServiceImp implements BookService {

	@Autowired
	private BookDAO bookdao;
	
	@Override
	@Transactional
	public long save(Book book) {
		return bookdao.save(book);
	}

	@Override
	@Transactional
	public Book get(long id) {
		return bookdao.get(id);
	}

	@Override
	@Transactional
	public List<Book> list() {
		return bookdao.list();
	}

	@Override
	@Transactional
	public void update(long id, Book book) {
		bookdao.update(id, book);

	}

	@Override
	@Transactional
	public void delete(long id) {
		bookdao.delete(id);
	}

}
