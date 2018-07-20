package com.cubic.book.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cubic.book.service.BookData;
import com.cubic.book.service.BookSearchResult;
import com.cubic.book.service.BookService;
import com.cubic.book.service.exceptions.InvalidDataException;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Builder
@Data
@Service
@Path("/book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
	
	@Autowired
	private BookService bs;
	
 	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBook(final BookData book) {
 		log.debug("this is inside create book method");
		final BookData results = bs.create(book);
		log.info("this checks the ifo log");
		return Response.ok().entity(results).build();
	}

	@GET
	@Path("/{bookId}")
	public Response getBook(@PathParam("bookId") final String id) {
		log.error("this is a sample error mesage inside find book method");
		final BookData result = bs.get(id);
		return Response.ok().entity(result).build();
	}

	@PUT
	@Path("/{bookId}") //modified later by me
	public Response modify(@PathParam("bookId") final BookData book) {
		//return Response.ok().entity(book).build();
		 return Response.noContent().build();
	}

	@DELETE
	@Path("/{bookId}")
	public Response removeBook(@PathParam("bookId") final String id) {
		log.debug("Entering customerResource.create");
		bs.remove(id);
		return Response.noContent().build();
	}

	@GET
	@Path("/searchByName")
	public Response searchByName(@QueryParam("name") final String name) {
		final BookSearchResult result = bs.searchByName(name);
		return Response.ok().entity(result).build();
	}

	@GET
	@Path("/searchByAuthor")
	public Response searchByAuthor(@QueryParam("author") final String author) {
		final BookSearchResult result = bs.searchByAuthor(author);
		return Response.ok().entity(result).build();

	}
	private void validateBook(final BookData book) {
		if (book == null || StringUtils.isEmpty(book.getBookName())) {
			throw new InvalidDataException("Invalid data.unable to process the request");
		}
	}
}
