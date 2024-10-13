package com.kurt.teaches.library.model;

import com.kurt.teaches.library.scalar.ISBN;
import com.kurt.teaches.library.scalar.ISBN.ISBNType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Service
public class ExternalBookService {

  private final RestClient restClient;
  public static final String API_URL = "https://openlibrary.org/api/books?bibkeys=ISBN:{isbn}&jscmd=details&format=json";
  public static final String API_URL_GOOGLE = "https://www.googleapis.com/books/v1/volumes";
  public static final String API_URL_ISBN_LOOKUP = "https://isbnsearch.org/isbn/{isbn}";

  private static final Logger logger = LoggerFactory.getLogger(ExternalBookService.class);

  @Value("${google_api.key:default-api-key}")
  private String apiKey;

  public ExternalBookService() {
    this.restClient = RestClient.create();
  }

  public String getBookDetailsByIsbnLookup(ISBN isbn){
    return restClient.get()
            .uri(API_URL_ISBN_LOOKUP, isbn.getValue())
            .retrieve()
            .body(String.class);
  }

  public Map<String, Object> getBookDetailsByIsbnGoogle(ISBN isbn) {
    // generate the query string
    String queryString = "q=";
    // isbn attribute in google is based on isbn type so query string is diff for each
    if(isbn.getType() == ISBNType.ISBN_13){
      queryString = String.format("%sisbn_13=%s", queryString, isbn.getValue());
    }
    else{
      queryString = String.format("%sisbn_10=%s", queryString, isbn.getValue());
    }
    // google returns related books, only include matching one to save on time and space
    queryString += "&maxResults=1";
    // api key is to be provided in URL (https://developers.google.com/books/docs/v1/using#APIKey)
    queryString += String.format("&key=%s", apiKey);
    String api_url = String.format("%s?%s", API_URL_GOOGLE, queryString);
    logger.info("Running {}", api_url);
    return restClient.get()
            .uri(api_url)
            .retrieve()
            .body(Map.class);
  }

  public Map<String, Object> getBookDetailsByIsbn(ISBN isbn) {
    return restClient.get()
            .uri(API_URL, isbn.getValue())
            .retrieve()
            .body(Map.class);
  }
}