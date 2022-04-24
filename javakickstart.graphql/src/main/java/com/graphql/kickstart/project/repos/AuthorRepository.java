package com.graphql.kickstart.project.repos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graphql.kickstart.project.models.Author;
import com.graphql.kickstart.project.models.Book;


@Repository
public class AuthorRepository {
	private int authorId = 1;

	@Autowired
	private BookRepository bookRepo;

	private List<Author> authors = new ArrayList<>(Arrays.asList(new Author(1, "Robert", "Brown")));

	public Author addAuthor(String firstName, String lastName) {
		authorId++;
		Author author = new Author(authorId, firstName, lastName);
		authors.add(author);
		return author;
	}

	public Author getAuthor(int bookId) {
		Book book = bookRepo.getBooks().stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
		Author author = authors.stream().filter(a -> a.getAuthorId() == book.getAuthorId()).findFirst().orElse(null);
		return author;
	}

	public List<Author> getAuthors(){
		return authors;
	}
}
