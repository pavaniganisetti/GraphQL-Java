package com.graphql.kickstart.project.resolvers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.kickstart.project.models.Author;
import com.graphql.kickstart.project.models.Book;
import com.graphql.kickstart.project.repos.BookRepository;
import com.graphql.kickstart.project.repos.AuthorRepository;

@Component
public class Mutation implements GraphQLMutationResolver {
	private static final Logger log = LoggerFactory.getLogger(Mutation.class);

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private AuthorRepository authRepo;

	public Book addBook(String bookName, int pageCount, int authorId) {
		Book book = bookRepo.addBook(bookName, pageCount, authorId);
		log.debug("book added with id {}", book.getBookId());
		return book;
	}
	
	public Author addAuthor(String firstName, String lastName) {
		Author author = authRepo.addAuthor(firstName, lastName);
		log.debug("author added with id {}", author.getAuthorId());
		return author;
	}
}
