package com.sringbootcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sringbootcrud.exception.BookNotFoundException;
import com.sringbootcrud.model.Book;
import com.sringbootcrud.service.BookService;

@RestController
public class BookController 
{

	@Autowired
	private BookService service;
	
	//just testing
	@GetMapping("/")
	public String home()
	{
		return "This is homepage...!";
	}
	
	//get all books
	@GetMapping("/books")
	private List<Book> getAllBooks()
	{
		return service.getAllBooks();
	}
	
	//get by id
	@GetMapping("/getbyid/{bid}")
	private Book getbyId(@PathVariable("bid") int bid) 
	{
		
		Book book=service.getById(bid);
		if(book==null)
		
		throw new BookNotFoundException("Book not found with ID:"+bid);
		return book;
		
	}
	
	//create or add
	@PostMapping("/add/")
	private String addBook(@RequestBody Book book)
	{
		service.addBook(book);
		return "Book added successfully...";
	}
	
	//delete
	@DeleteMapping("/delete/{bid}")
	private String delete(@PathVariable("bid")int bid)
	{
		service.deleteById(bid);
		
		return "book deleted successfully...";
	}
	
	//update
	@PutMapping("/update")
	private String update(@RequestBody Book book)
	{
		service.addBook(book);		
		
		return "updated successfully...!";
	}
	
}
