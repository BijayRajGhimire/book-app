package com.cubic.book;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.cubic.book.resource.BookResource;
@Configuration
public class BookConfig extends ResourceConfig {
	
	public BookConfig(){
		this.register(BookResource.class);
	}

}
