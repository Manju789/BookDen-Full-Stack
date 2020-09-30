package com.assignment.springboot.mongo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.springboot.mongo.dao.BookDAO;
import com.assignment.springboot.mongo.exceptions.BookException;
import com.assignment.springboot.mongo.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDao;

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		if (bookDao.findById(book.getId()).isPresent()) {
			throw new BookException("Id already exists.");
		} else
			bookDao.save(book);
	}

	@Override
	public Collection<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	@Override
	public Optional<Book> getBookById(int id) {
		// TODO Auto-generated method stub

		if (bookDao.findById(id).isPresent()) {
			return bookDao.findById(id);
		} else
			throw new BookException("Id does not exist.");
	}

	@Override
	public void deleteBookById(int id) {
		// TODO Auto-generated method stub
		// check whether id exists
		if (bookDao.findById(id).isPresent()) {
			
			bookDao.deleteById(id);
		} else
			throw new BookException("Id does not exist.");
		
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.save(book);
	}

	@Override
	public void deleteAllBooks() {
		// TODO Auto-generated method stub
		bookDao.deleteAll();
	}

}