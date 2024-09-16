package com.kurt.teaches.library.model;

import com.kurt.teaches.library.schema.types.Book;
import com.kurt.teaches.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceTests {

  @Autowired
  private BookService bookService;

  @MockBean
  private BookRepository bookRepository;

  @Test
  void testGetBookById() {
    // Arrange
    Book book = new Book();
    book.setId("1");
    when(bookRepository.findById("1")).thenReturn(Optional.of(book));

    // Act
    Book result = bookService.getBookById("1");

    // Assert
    assertNotNull(result);
    assertEquals("1", result.getId());
    verify(bookRepository, times(1)).findById("1");
  }

  @Test
  void testGetBookByName() {
    // Arrange
    Book book = new Book();
    book.setName("Test Book");
    when(bookRepository.findByName("Test Book")).thenReturn(book);

    // Act
    Book result = bookService.getBookByName("Test Book");

    // Assert
    assertNotNull(result);
    assertEquals("Test Book", result.getName());
    verify(bookRepository, times(1)).findByName("Test Book");
  }

  @Test
  void testBooks() {
    // Arrange
    Book book1 = new Book();
    Book book2 = new Book();
    Page<Book> page = new PageImpl<>(Arrays.asList(book1, book2));
    when(bookRepository.findAllBy(any(PageRequest.class))).thenReturn(page);

    // Act
    Page<Book> result = bookService.books(0, 2);

    // Assert
    assertNotNull(result);
    assertEquals(2, result.getSize());
    verify(bookRepository, times(1)).findAllBy(any(PageRequest.class));
  }

  @Test
  void testAddBook() {
    // Arrange
    Book book = new Book();
    book.setName("Test Book");
    when(bookRepository.save(any(Book.class))).thenReturn(book);

    // Act
    Book result = bookService.addBook(book);

    // Assert
    assertNotNull(result);
    assertEquals("Test Book", result.getName());
    verify(bookRepository, times(1)).save(any(Book.class));
  }

  @Test
  void testDeleteById() {
    // Act
    bookService.deleteById("1");

    // Assert
    verify(bookRepository, times(1)).deleteById("1");
  }
}
