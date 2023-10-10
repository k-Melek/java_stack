package com.melek.booksapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.melek.booksapi.models.Book;
import com.melek.booksapi.services.BookService;

@RestController
public class BooksApi {

	private final BookService bookService;

	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	// VIEW ROUTE - FIND ALL
	@RequestMapping("/api/books")
    public List<Book> allBooks(){
		System.out.println("----------"+ bookService.allBooks());
    	return bookService.allBooks();
    }
	
	
	// ACTION ROUTE - CREATE
	@RequestMapping(value = "/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
		
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}
	
	// VIEW ROUTE - ONE ONE BY ID
	@RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
}
