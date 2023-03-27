package com.sringbootcrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sringbootcrud.exception.BookNotFoundException;
import com.sringbootcrud.model.Book;
import com.sringbootcrud.repo.BookRepo;

@Service
public class BookService 
{
	
	@Autowired
	private BookRepo repo;
	
	//get all
	public List<Book> getAllBooks()
	{
		List<Book>list=new ArrayList<>();
		list=repo.findAll();
		return list;
	}

	//get by id
	public Book getById(int bid)
	{
		Book book=repo.findById(bid).orElse(null);
		return book;
	}
	
	//create or add book
	public void addBook(Book book)
	{
		repo.save(book);
	}
	
	//delete by id
	public void deleteById(Integer bid)
	{
		repo.deleteById(bid);;
		//return book;
		
	}
	
	//update 
	public void updateBook(Book book,int bid)
	{
		repo.save(book);
	}
	
	
}
