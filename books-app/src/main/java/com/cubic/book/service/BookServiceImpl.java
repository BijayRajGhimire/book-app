package com.cubic.book.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class BookServiceImpl implements BookService {

	private final Map<String, BookData> db = new HashMap<String, BookData>();
	private int count = 100;

	public BookData create(BookData book) {
		log.debug("this is a debug test");
		log.debug("BookData = {}", book);
		count++;
		book.setId(String.valueOf(count));
		db.put(book.getId(), book);
		return book;

	}

	public void modify(BookData book) {
		if (db.containsKey(book.getId())) {
			db.put(book.getId(), book);
		}

	}

	public BookData get(String id) {
		db.containsKey(id);
		return db.get(id);

	}

	public void remove(String id) {
		if (db.containsKey(id)) {
			db.remove(id);
		}

	}

	public BookSearchResult search(final String name) {
		final BookSearchResult result = BookSearchResult.builder().build();
		final Collection<BookData> book = db.values();
		for (BookData books : book) {
			if (books.getBookName().toLowerCase().startsWith(name.toLowerCase())) {
				result.getResults().add(books);
			}

		}
		return result;

	}
	public BookSearchResult searchByAuthor(final String name) {
		final BookSearchResult result = BookSearchResult.builder().build();
		final Collection<BookData> book = db.values();
		for (BookData books : book) {
			if (books.getAuthor().toLowerCase().startsWith(name.toLowerCase())) {
				result.getResults().add(books);
			}

		}
		return result;

	}
	public BookSearchResult searchByName(final String name) {
		final BookSearchResult result = BookSearchResult.builder().build();
		final Collection<BookData> book = db.values();
		for (BookData books : book) {
			if (books.getBookName().toLowerCase().startsWith(name.toLowerCase())) {
				result.getResults().add(books);
			}

		}
		return result;

	}

	public BookSearchResult searchById(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
