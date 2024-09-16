package com.kurt.teaches.library.model;

import com.kurt.teaches.library.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.kurt.teaches.library.schema.types.Book;

@Service
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book getBookById(String id) {
    return bookRepository.findById(id).orElse(null);
  }

  public Book getBookByName(String name) {
    return bookRepository.findByName(name);
  }

  public Page<Book> books(int pageNumber, int pageSize){
    return bookRepository.findAllBy(PageRequest.of(pageNumber, pageSize));
  }

  public Book addBook(Book book) {
    return bookRepository.save(book);
  }

  public void deleteById(String id){
    bookRepository.deleteById(id);
  }
}
