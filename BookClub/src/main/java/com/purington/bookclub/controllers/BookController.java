package com.purington.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.purington.bookclub.models.Book;
import com.purington.bookclub.models.User;
import com.purington.bookclub.services.BookService;
import com.purington.bookclub.services.UserService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	//Display Create book page
	@GetMapping("/create")
	public String bookCreate(@ModelAttribute("book") Book book) {
		
		return "bookCreate.jsp";
	}
	
	//Action...creating a book
	@PostMapping("/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {

		//check if user is logged in
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}

		//check for errors
		if(result.hasErrors()) {
			return "bookCreate.jsp";
		}
		
		//if no errors bind to the user and create the book
		User user = userService.getOne((Long)session.getAttribute("uuid"));
		book.setUser(user);
		bookService.createBook(book);
		return "redirect:/user/shelves";
	}
	
	//Display View a single book page
	@GetMapping("/view/{id}")
	public String viewBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		//check if user is logged in
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("book", bookService.getBook(id));
		Long userId = (Long) session.getAttribute("uuid");
		model.addAttribute("user", userService.getOne(userId));
		
		return "book.jsp";
	}
	
	//Delete book
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id")Long id, HttpSession session) {
		
		//check if user is logged in
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		
		bookService.deleteBook(id);
		
		return "redirect:/user/shelves";
	}
	
	//Display edit book
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		//check if user is logged in
		if(session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("book", bookService.getBook(id));
		
		return "editBook.jsp";
	}
	
	//Action edit the book
	@PutMapping("/edit/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id, HttpSession session) { 
		
		//check for errors
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		
		//if no errors update
		User user = userService.getOne((Long)session.getAttribute("uuid"));
		book.setUser(user);
		bookService.updateBook(book);
		return "redirect:/user/shelves";
	}
	
}	