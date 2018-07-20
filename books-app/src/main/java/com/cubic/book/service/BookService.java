package com.cubic.book.service;

public interface BookService {

	BookData create(final BookData book);

	void modify(final BookData book);

	BookData get(final String id);

	void remove(final String id);

	BookSearchResult searchByName(final String name);

	BookSearchResult searchByAuthor(final String name);

	BookSearchResult searchById(final String name);
}
