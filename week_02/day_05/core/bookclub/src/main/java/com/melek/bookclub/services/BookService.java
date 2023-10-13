package com.melek.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melek.bookclub.models.Book;
import com.melek.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	// Book C R U D
	// Find All books
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	// CREATE 
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	// FIND one BOOK
	public Book findOneBook(Long id) {
		Optional<Book> maybeBook = bookRepo.findById(id);
		if(maybeBook.isPresent()) {
			return maybeBook.get();
		} else {
			return null;
		}
	}
	
	// Update 
	public Book updateBook(Book updatedBook) {
		return bookRepo.save(updatedBook);
	}
	
	// Delete 
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
