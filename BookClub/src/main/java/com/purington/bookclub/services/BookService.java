package com.purington.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.purington.bookclub.models.Book;
import com.purington.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	//CRUD
	//Create
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	//Read
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	public Book getBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else return null;
	}
	
	//Update
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	//Delete
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
