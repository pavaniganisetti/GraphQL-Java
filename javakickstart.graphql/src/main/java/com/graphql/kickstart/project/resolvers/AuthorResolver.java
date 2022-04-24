package com.graphql.kickstart.project.resolvers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.kickstart.project.models.Author;
import com.graphql.kickstart.project.models.Book;
import com.graphql.kickstart.project.repos.AuthorRepository;

@Component
public class AuthorResolver implements GraphQLResolver<Book> {

	private static final Logger log = LoggerFactory.getLogger(AuthorResolver.class);
	
	@Autowired
	private AuthorRepository authRepo;
	
	public Author getAuthor(Book book) {
		log.debug("fetching author for bookid: {}",book.getBookId());
		Author author = authRepo.getAuthor(book.getBookId());
		log.debug("author: {}",author.toString());
		return author;
	}
}
