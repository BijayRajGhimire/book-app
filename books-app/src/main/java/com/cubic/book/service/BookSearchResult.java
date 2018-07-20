package com.cubic.book.service;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class BookSearchResult {
	@Builder.Default
	private List<BookData> results = new ArrayList<BookData>();
}
