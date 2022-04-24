package com.graphql.springboot.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.springboot.project.models.Book;
import com.graphql.springboot.project.repos.BookRepository;

@Controller
public class BookController {

	private static final Logger log = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookRepository bookRepo;

	@MutationMapping
	public Book addBook(@Argument String bookName, @Argument int pageCount, @Argument int authorId) {
		log.debug("adding book with name {}", bookName);
		Book book = bookRepo.addBook(bookName, pageCount, authorId);
		log.debug("book added with id {}", book.getBookId());
		return book;
	}

	@QueryMapping
	public List<Book> getBooks() {
		log.debug("fetching books");
		List<Book> books = bookRepo.getBooks();
		log.debug("existing books count {}", books.size());
		return books;
	}

	@QueryMapping
	public Book getBookById(@Argument int id) {
		log.debug("fetching book with id {}", id);
		Book book = bookRepo.getBookById(id);
		return book;
	}

}
