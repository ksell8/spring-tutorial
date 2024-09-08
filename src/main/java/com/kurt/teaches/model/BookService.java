package com.kurt.teaches.model;

import com.kurt.teaches.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kurt.teaches.model.types.Book;

@Service
public class BookService {

  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book getBookById(String id) {
    return bookRepository.findById(id).orElse(null);
  }

  public Book getBookByName(String name) {
    return bookRepository.findByName(name);
  }

  public Book addBook(Book book) {
    return bookRepository.save(book);
  }

  public void deleteById(String id){
    bookRepository.deleteById(id);
  }
}
