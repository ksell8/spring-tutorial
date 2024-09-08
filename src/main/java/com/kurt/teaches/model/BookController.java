package com.kurt.teaches.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.kurt.teaches.model.types.Book;
import com.kurt.teaches.model.types.BookInput;

@Controller
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @QueryMapping
  public Book bookById(@Argument String id) {
    return bookService.getBookById(id);
  }

  @QueryMapping
  public Book bookByName(@Argument String name) {
    return bookService.getBookByName(name);
  }

  @MutationMapping
  public Book addBook(@Argument BookInput bookInput) {
    Book book = new Book();
    book.setName(bookInput.getName());
    book.setAuthor(bookInput.getAuthor());
    book.setStatus(bookInput.getStatus());
    book.setPublisher(bookInput.getPublisher());
    book.setPublishedDate(bookInput.getPublishedDate());
    book.setGenre(bookInput.getGenre());
    return bookService.addBook(book);
  }

  @MutationMapping
  public Boolean deleteById(@Argument String id){
    bookService.deleteById(id);
    return true;
  }
}
