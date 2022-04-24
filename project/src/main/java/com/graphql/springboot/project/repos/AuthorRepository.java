package com.graphql.springboot.project.repos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graphql.springboot.project.models.Author;
import com.graphql.springboot.project.models.Book;

@Repository
public class AuthorRepository {

	private static final Logger log = LoggerFactory.getLogger(AuthorRepository.class);

	private int authorId = 1;

	@Autowired
	private BookRepository bookRepo;

	private List<Author> authors = new ArrayList<>(Arrays.asList(new Author(1, "Robert", "Brown")));

	public Author addAuthor(String firstName, String lastName) {
		authorId++;
		Author author = new Author(authorId, firstName, lastName);
		log.debug("author = {}", author.toString());
		authors.add(author);
		return author;
	}

	public Author getAuthor(int bookId) {
		Book book = bookRepo.getBooks().stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
		log.debug("book = {}",book.toString());
		Author author = authors.stream().filter(a -> a.getAuthorId() == book.getAuthorId()).findFirst().orElse(null);
		log.debug("author = {}",author.toString());
		return author;
	}

	public List<Author> getAuthors(){
		return authors;
	}
}
