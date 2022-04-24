package com.graphql.kickstart.project.resolvers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.kickstart.project.models.Book;
import com.graphql.kickstart.project.repos.AuthorRepository;
import com.graphql.kickstart.project.repos.BookRepository;
import com.graphql.kickstart.project.models.Author;

@Component
public class Query implements GraphQLQueryResolver {

	private static final Logger log = LoggerFactory.getLogger(Query.class);

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private AuthorRepository authRepo;

	public List<Book> getBooks() {
		log.debug("fetching books");
		List<Book> books = bookRepo.getBooks();
		log.debug("existing books count {}", books.size());
		return books;
	}

	public Book getBookById(int id) {
		log.debug("fetching book with id {}", id);
		Book book = bookRepo.getBookById(id);
		return book;
	}
	
	public List<Author> getAuthors(){
		log.debug("fetching authors");
		List<Author> authors = authRepo.getAuthors();
		log.debug("authors {}",authors.toString());
		return authors;
	}
}
