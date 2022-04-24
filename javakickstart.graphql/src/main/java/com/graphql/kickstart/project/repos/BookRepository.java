package com.graphql.kickstart.project.repos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.graphql.kickstart.project.models.Book;

@Repository
public class BookRepository {

	private int bookId = 1;

	private List<Book> books = new ArrayList<>(Arrays.asList(new Book(bookId, "Davinci Code", 500, 1)));

	public Book addBook(String bookName, int pageCount, int authorId) {
		bookId++;
		Book book = new Book(bookId, bookName, pageCount, authorId);
		books.add(book);
		return book;
	}

	public List<Book> getBooks() {
		return books;
	}

	public Book getBookById(int bookId) {
		Book book = books.stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);
		return book;
	}
}

