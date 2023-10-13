package com.melek.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.melek.bookclub.models.Book;
import com.melek.bookclub.models.User;
import com.melek.bookclub.services.BookService;
import com.melek.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

	// CALL Both Book & User Service
	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;
	
	// View Route - Show all Books
	@GetMapping("/books")
	public String allBooks(Model model, @ModelAttribute("book") Book book) {
		// Grab all the books from db
		List<Book> allBooks = bookServ.findAll();
		model.addAttribute("listOfBooks", allBooks);
		return "book/books.jsp";
	}
	
	// View route Create a book
	@GetMapping("/books/new")
	public String createBook(@ModelAttribute("book") Book book) {
		return "book/createBook.jsp";
	}
	
	
	// Action route Create a book
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("book") Book book,
							BindingResult result,
							Model model,
							HttpSession session
			) {
		if(result.hasErrors()) {
			return "book/createBook.jsp";
		} else {
			Long useId = (Long) session.getAttribute("user_id");
			User LoggedUser = userServ.findById(useId);
			book.setPostedBy(LoggedUser);
			bookServ.createBook(book);
			return "redirect:/books";
		}
	}
	
	// View route One BOOK 
	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, 
			Model model, 
			HttpSession session ) {
		// Grab the Book by its ID
		Book selectedBook = bookServ.findOneBook(id);
		model.addAttribute("book", selectedBook);
		
		// Sending Logged user
		Long userId = (Long) session.getAttribute("user_id");
	    User loggedUser = userServ.findById(userId);
	    model.addAttribute("LoggedUser", loggedUser);
		return "book/showBook.jsp";
	}
	
	// view Route - edit a book
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id,
			Model model) {
		Book thisBook = bookServ.findOneBook(id);
		model.addAttribute("book", thisBook);
		return "book/editBook.jsp";
	}
	
	// Action route - edit a book
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			HttpSession session) {
		if (result.hasErrors()) {
			return "book/edit.jps";
		} else {
			// resetting Posted by to pass the user who posted it
			Book oldBook = bookServ.findOneBook(book.getId());
			book.setPostedBy(oldBook.getPostedBy());
			bookServ.updateBook(book);
			return "redirect:/books";
		}
	}
	
	
	
	
	// Action route DELETE
	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/books";
	}
	
	
	
	
}
