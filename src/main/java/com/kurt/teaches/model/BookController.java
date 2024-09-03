package com.kurt.teaches.model;

import com.kurt.teaches.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

  private final BookRepository bookRepository;

  @Autowired
  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
  // Query to get a book by its ID
  @QueryMapping
  public Book bookById(@Argument String id) {
    return bookRepository.findById(id).orElse(null);
  }

  // Query to get a book by its name
  @QueryMapping
  public Book bookByName(@Argument String name) {
    return bookRepository.findByName(name);
  }

  // Mutation to add a new book
  @MutationMapping
  public Book addBook(@Argument BookInput bookInput) {
    Book book = new Book();
    book.setName(bookInput.getName());
    book.setAuthor(bookInput.getAuthor());
    book.setStatus(bookInput.getStatus());
    book.setPublisher(bookInput.getPublisher());
    book.setPublishedDate(bookInput.getPublishedDate());
    book.setGenre(bookInput.getGenre());
    return bookRepository.save(book);
  }
}
