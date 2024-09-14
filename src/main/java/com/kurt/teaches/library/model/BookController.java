package com.kurt.teaches.library.model;

import com.kurt.teaches.library.model.types.Book;
import com.kurt.teaches.library.model.types.BookInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

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

  @QueryMapping
  public Page<Book> books(@Argument int pageNumber, @Argument int pageSize){
    return bookService.books(pageNumber, pageSize);
  }

  @MutationMapping
  public Book addBook(@Argument BookInput bookInput) {
    Book book = new Book();
    book.setName(bookInput.getName());
    book.setAuthor(bookInput.getAuthor());
    book.setStatus(bookInput.getStatus());
    book.setPublisher(bookInput.getPublisher());
    book.setpublishedYear(bookInput.getpublishedYear());
    book.setGenre(bookInput.getGenre());
    return bookService.addBook(book);
  }

  @MutationMapping
  public Boolean deleteById(@Argument String id){
    bookService.deleteById(id);
    return true;
  }
}
