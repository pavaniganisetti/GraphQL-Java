package com.graphql.springboot.project.models;

public class Book {
	private int bookId;
	private String name;
	private int pageCount;
	private int authorId;


	public Book(int bookId, String bookName, int pageCount, int authorId) {
		super();
		this.bookId = bookId;
		this.name = bookName;
		this.pageCount = pageCount;
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", pageCount=" + pageCount + ", authorId=" + authorId
				+ "]";
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String bookName) {
		this.name = bookName;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
