package com.graphql.springboot.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphql.springboot.project.models.Author;
import com.graphql.springboot.project.models.Book;
import com.graphql.springboot.project.repos.AuthorRepository;

@Controller
public class AuthorController {

	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);

	@Autowired
	private AuthorRepository authRepo;

	@MutationMapping
	public Author addAuthor(@Argument String firstName, @Argument String lastName) {
		log.debug("adding author with firstName {}", firstName);
		Author author = authRepo.addAuthor(firstName, lastName);
		log.debug("author added with id {}", author.getAuthorId());
		return author;
	}
	
	@QueryMapping
	public List<Author> getAuthors(){
		log.debug("fetching authors");
		List<Author> authors = authRepo.getAuthors();
		log.debug("authors {}",authors.toString());
		return authors;
	}

	@SchemaMapping
	public Author author(Book book) {
		log.debug("fetching author with book id {}", book.getBookId());
		Author author = authRepo.getAuthor(book.getBookId());
		log.debug("author name is {}", author.getFirstName());
		return author;
	}
}
