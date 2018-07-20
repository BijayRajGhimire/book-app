package com.cubic.book.service;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement
public class BookData {
	
	private String id;
	private String bookName;
	private String author;
	private String edition;
	private String price;

}
