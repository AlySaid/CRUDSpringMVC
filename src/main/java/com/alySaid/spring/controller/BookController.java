package com.alySaid.spring.controller;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alySaid.spring.model.Book;
import com.alySaid.spring.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//get all the books
	@GetMapping("/api/book")
	public ResponseEntity<List<Book>> list(){
		List<Book> list = bookService.list();
		return ResponseEntity.ok().body(list);
	}
	
	//get a single book
	@GetMapping("/api/book/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") long id){
		Book book = bookService.get(id);
		return ResponseEntity.ok().body(book);
	}
	
	//save a single book
	@PostMapping("/api/book")
	public ResponseEntity<?> save(@RequestBody Book book){
		long id = bookService.save(book);
		return ResponseEntity.ok().body("book created with id: "+id);
	}
	
	//save a single book
	@PutMapping("/api/book/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book){
		bookService.update(id, book);
		return ResponseEntity.ok().body("book has been updated");
	}
	
	//delete a book  from all books
	@DeleteMapping("/api/book/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		bookService.delete(id);
		return ResponseEntity.ok().body("book number: "+id+" has been deleted");
	}

	
	
}
