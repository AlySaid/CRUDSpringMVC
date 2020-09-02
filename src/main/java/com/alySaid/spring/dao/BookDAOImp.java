package com.alySaid.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.alySaid.spring.model.Book;


@Repository 
public class BookDAOImp implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

	@Override
	public Book get(long id) {
		Book book = (Book) sessionFactory.getCurrentSession().createQuery("from Book where id="+id).list().get(0);
		return book;
	}

	@Override
	public List<Book> list() {
		List<Book> list = sessionFactory.getCurrentSession().createQuery("from Book").list();
		return list;
	}

	@Override
	public void update(long id, Book book) {
		Session session = sessionFactory.getCurrentSession();
		Book oldBook = session.byId(Book.class).load(id);
		oldBook.setAuthor(book.getAuthor());
		oldBook.setTitle(book.getTitle());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Book book = (Book)sessionFactory.getCurrentSession().byId(Book.class).load(id);
		sessionFactory.getCurrentSession().delete(book);
		
	}

}
