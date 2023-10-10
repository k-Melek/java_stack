package com.melek.booksapi.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.melek.booksapi.models.Book;
import com.melek.booksapi.services.BookService;

@Controller
public class ViewsController {

	private final BookService bookService;

	public ViewsController(BookService bookService) {
		this.bookService = bookService;
	}
	
	// Read ALL 
	@RequestMapping("/books")
    public String allBooks(Model model){
		// Grab ALL The books from the service
		List<Book> allBooks = bookService.allBooks();
		
		model.addAttribute("booksList", allBooks);
    	return "books.jsp";
    }
	
	// View Route = display form
	@RequestMapping("/books/new")
    public String displayForm(){
		
    	return "Create.jsp";
    }
	// Action one create
	@RequestMapping(value = "/processBook", method=RequestMethod.POST)
    public String create(@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="numberOfPages") Integer numOfPages) {
		
		Book book = new Book(title, desc, lang, numOfPages);
		Book newlyCreatedBook = bookService.createBook(book);
		return "redirect:/books";
	}
	
	// show One 
	@RequestMapping("/books/{id}")
	public String oneBook(@PathVariable("id") Long id,
					Model model) {
		Book theBook = bookService.findBook(id);
		model.addAttribute("thisBook", theBook);
		return "OneBook.jsp";
	}
	
}
