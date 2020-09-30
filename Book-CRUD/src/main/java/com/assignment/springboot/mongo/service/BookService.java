package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.Optional;

import com.assignment.springboot.mongo.model.Book;

public interface BookService {

	public Collection<Book> getAllBooks();

	public Optional<Book> getBookById(int id);

	public void deleteBookById(int id);

	public Book updateBook(Book book);

	public void deleteAllBooks();

	public void addBook(Book book);

}