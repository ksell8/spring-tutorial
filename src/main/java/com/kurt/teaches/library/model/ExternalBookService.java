package com.kurt.teaches.library.model;

import com.kurt.teaches.library.scalar.ISBN;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class ExternalBookService {

  private final RestClient restClient;
  private final String API_URL = "https://openlibrary.org/api/books?bibkeys=ISBN:{isbn}&jscmd=details&format=json";

  public ExternalBookService() {
    this.restClient = RestClient.create();
  }

  @SuppressWarnings("unchecked")
  public Map<String, Object> getBookDetailsByIsbn(ISBN isbn) {
    return restClient.get()
            .uri(API_URL, isbn.getValue())
            .retrieve()
            .body(Map.class);
  }
}