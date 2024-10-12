package com.kurt.teaches.library.model;

import com.kurt.teaches.library.exceptions.NoBookInfoFound;
import com.kurt.teaches.library.scalar.ISBN;
import static com.kurt.teaches.library.model.ExternalBookService.API_URL;

import com.kurt.teaches.library.schema.types.Book;
import com.kurt.teaches.library.schema.types.Genre;
import com.kurt.teaches.library.schema.types.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;

@Controller
public class ExternalBookController {
  private final ExternalBookService externalBookService;
  private final BookService bookService;


  public ExternalBookController(ExternalBookService externalBookService, BookService bookService){
    this.externalBookService = externalBookService;
    this.bookService = bookService;
  }

  @GetMapping("/bookform")
  public String renderForm(Model model) {
    model.addAttribute("isbn", "");
    return "bookform";
  }

  @GetMapping("/getBookDetails")
  public String getBookDetails(@RequestParam("isbn") String isbn, Model model){
    try {
      // Fetch book details by ISBN
      Map<String, Object> bookDetails = externalBookService.getBookDetailsByIsbn(ISBN.of(isbn));
      if(bookDetails != null
              && bookDetails.containsKey(String.format("ISBN:%s", isbn))
              && ((Map) bookDetails.get(String.format("ISBN:%s", isbn))).containsKey("details")){
        bookDetails = ((Map<String,Map<String, Object>>) bookDetails.get(String.format("ISBN:%s", isbn))).get("details");
        if(bookDetails.containsKey("publish_date")){
          String year = parseYearFromDate((String) bookDetails.get("publish_date"));
          if(year != null){
            bookDetails.put("publish_year", year);
          }
          bookDetails.put("isbn", isbn);
        }
      }
      else{
        throw new NoBookInfoFound(isbn);
      }
      // Pull in enums for setting dropdown options
      model.addAttribute("genres", Genre.values());
      model.addAttribute("statuses", Status.values());
      // Add book details map for setting defaults
      model.addAttribute("bookDetails", bookDetails);
      return "bookDetails";
    }
    // If ISBN is invalid or no info found, redirect to an error page
    catch (IllegalArgumentException ex) {
      model.addAttribute("title", "INVALID ISBN");
      model.addAttribute("errorMessage", String.format("%s is not a valid ISBN.", isbn));
      return "error";
    }
    catch(NoBookInfoFound ex){
      model.addAttribute("title", "NO INFO ON ISBN");
      model.addAttribute("errorMessage",
              String.format("%s does not have info on %s",
                      API_URL.split("/")[2], isbn));
      return "error";
    }
    catch(Exception ex){
      model.addAttribute("title", "ERROR");
      model.addAttribute("errorMessage", String.format("Unexpected error in getBookDetails: %s", ex.getMessage()));
      return "error";
    }
  }

  public static String parseYearFromDate(String date){
    // Regular expression to match a year that starts with 19 or 20 and has four digits
    String yearPattern = "\\b(19|20)\\d{2}\\b";
    Pattern p = Pattern.compile(yearPattern);
    Matcher m = p.matcher(date);

    if (m.find()) {
      return m.group(); // Return the matched year
    } else {
      return null;
    }
  }

  @PostMapping("/addBook")
  public String addBook(@RequestParam("title") String name,
                        @RequestParam("author") String author,
                        @RequestParam(value = "publisher", required = false) String publisher,
                        @RequestParam(value = "publishYear", required = false) Year publishYear,
                        @RequestParam(value = "pages", required = false) Integer pages,
                        @RequestParam(value = "genre", required = false) Genre genre,
                        @RequestParam(value = "status", required = false) Status status,
                        @RequestParam(value = "hardcover") Boolean hardcover,
                        @RequestParam("isbn") ISBN isbn,
                        Model model) {
    try {
      Book book = new Book();
      book.setName(name);
      book.setAuthor(author);
      book.setPublisher(publisher);
      book.setPublishedYear(publishYear);
      book.setPages(pages);
      book.setGenre(genre);
      book.setStatus(status);
      book.setHardcover(hardcover);
      book.setIsbn(isbn);

      bookService.addBook(book);

      model.addAttribute("bookString", book.toString());
      return "bookAdded";
    } catch (Exception e) {
      model.addAttribute("title", "ERROR ADDING BOOK");
      model.addAttribute("errorMessage", e.getMessage());
      return "error";
    }
  }


}
