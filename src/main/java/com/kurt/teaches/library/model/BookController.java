package com.kurt.teaches.library.model;

import com.kurt.teaches.library.schema.types.Book;
import com.kurt.teaches.library.schema.types.BookInput;
import com.kurt.teaches.library.schema.types.PageBook;
import com.kurt.teaches.library.schema.DgsConstants;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

@DgsComponent
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @DgsQuery
  public Book bookById(@InputArgument(DgsConstants.QUERY.BOOKBYID_INPUT_ARGUMENT.Id) String id) {
    return bookService.getBookById(id);
  }

  @DgsQuery
  public Book bookByName(@InputArgument(DgsConstants.QUERY.BOOKBYNAME_INPUT_ARGUMENT.Name) String name) {
    return bookService.getBookByName(name);
  }

  @DgsQuery
  public PageBook books(
          @InputArgument(DgsConstants.QUERY.BOOKS_INPUT_ARGUMENT.PageNumber) Integer pageNumber,
          @InputArgument(DgsConstants.QUERY.BOOKS_INPUT_ARGUMENT.PageSize) Integer pageSize) {
    Page<Book> pages = bookService.books(pageNumber, pageSize);
    PageBook pageBook = new PageBook();
    pageBook.setContent(pages.getContent());
    pageBook.setTotalPages(pages.getTotalPages());
    pageBook.setHasNext(pages.hasNext());
    pageBook.setHasPrevious(pages.hasPrevious());
    pageBook.setNumber(pages.getNumber());
    pageBook.setSize(pages.getSize());
    pageBook.setNumberOfElements(pages.getNumberOfElements());
    pageBook.setTotalElements((int) pages.getTotalElements());
    return pageBook;
  }

  @DgsMutation
  public Book addBook(@InputArgument(DgsConstants.MUTATION.ADDBOOK_INPUT_ARGUMENT.BookInput) BookInput bookInput) {
    Book book = new Book();
    book.setName(bookInput.getName());
    book.setAuthor(bookInput.getAuthor());
    book.setStatus(bookInput.getStatus());
    book.setPublisher(bookInput.getPublisher());
    book.setPublishedYear(bookInput.getPublishedYear());
    book.setGenre(bookInput.getGenre());
    book.setHardcover(bookInput.getHardcover());
    book.setPages(bookInput.getPages());
    book.setIsbn(bookInput.getIsbn());
    return bookService.addBook(book);
  }

  @DgsMutation
  public String deleteById(@InputArgument(DgsConstants.MUTATION.DELETEBYID_INPUT_ARGUMENT.Id) String id) {
    bookService.deleteById(id);
    return id;
  }
}
