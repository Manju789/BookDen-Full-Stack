package com.assignment.springboot.mongo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.springboot.mongo.model.Book;
import com.assignment.springboot.mongo.service.BookService;

/************************************************************************************
 *          @author          Manjusha Dondeti
 *          Description      It is a controller class that provides the mapping
  *         Version             1.0
  *         Created Date    22-SEPT-2020
 ************************************************************************************/
@CrossOrigin
@RestController
public class BookController {

	@Autowired
	BookService service;//bookService
	
	@PostMapping(value = "/add")
	public ResponseEntity<String> addNewBook(@RequestBody Book book) {

		service.addBook(book);
		return new ResponseEntity<String>("New book record created.",HttpStatus.OK);
	}


	@GetMapping(value = "/getall")
	public Collection<Book> getAll() {

		return service.getAllBooks();
	}

	
	@GetMapping(value = "/getbyid/{book-id}")
	public Optional<Book> getById(@PathVariable(value = "book-id") int id) {
		
		return service.getBookById(id);
	}
	
	@PutMapping(value = "/update/{book-id}")
	public String update(@PathVariable(value = "book-id") int id, @RequestBody Book book) {
		book.setId(id);
		service.updateBook(book);
		return "Book record for id= " + id + " updated.";
	}

	@DeleteMapping(value = "/delete/{book-id}")
	public String delete(@PathVariable(value = "book-id") int id) {
		service.deleteBookById(id);
		return "Book record for id= " + id + " deleted.";
	}

	@DeleteMapping(value = "/deleteall")
	public String deleteAll() {
		service.deleteAllBooks();
		return "All employee records deleted.";
	}
}