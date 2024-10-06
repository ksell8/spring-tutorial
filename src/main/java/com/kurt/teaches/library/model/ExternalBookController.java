package com.kurt.teaches.library.model;

import com.kurt.teaches.library.scalar.ISBN;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ExternalBookController {
  private ExternalBookService externalBookService;


  public ExternalBookController(ExternalBookService externalBookService){
    this.externalBookService = externalBookService;
  }

  @GetMapping("/bookform")
  public String renderForm(Model model) {
    model.addAttribute("isbn", "");
    return "bookform";
  }

  @GetMapping("/getBookDetails")
  public @ResponseBody Map<String,Object> getBookDetails(@RequestParam("isbn") String isbn, Model model){
    try {
      // Fetch book details by ISBN
      Map<String, Object> bookDetails = externalBookService.getBookDetailsByIsbn(ISBN.of(isbn));
      //model.addAttribute("bookDetails", bookDetails);
      return bookDetails;
    } catch (IllegalArgumentException ex) {
      // If ISBN is invalid, redirect to an error page
      //model.addAttribute("errorMessage", isbn + " is not a valid ISBN.");
      return Map.of("isbnError",isbn + " is not a valid ISBN."); // Render the error page with message
    }
  }

}
