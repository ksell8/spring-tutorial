package com.kurt.teaches.model;

import java.time.Year;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {

  @Id
  private String id;
  private String name;
  private String author;
  private Status status;
  private String publisher;
  private Year publishedDate;
  private Genre genre;

  // Constructors, Getters, and Setters

  public Book() {}

  public Book(String name, String author, Status status, String publisher, Year publishedDate) {
    this.name = name;
    this.author = author;
    this.status = status;
    this.publisher = publisher;
    this.publishedDate = publishedDate;
  }

  public String getId() { return id; }
  public void setId(String id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }

  public Status getStatus() { return status; }
  public void setStatus(Status status) { this.status = status; }

  public String getPublisher() { return publisher; }
  public void setPublisher(String publisher) { this.publisher = publisher; }

  public Year getPublishedDate() { return publishedDate; }
  public void setPublishedDate(Year publishedDate) { this.publishedDate = publishedDate; }

  public Genre getGenre() { return genre; }
  public void setGenre(Genre genre) { this.genre = genre; }
}

