package com.kurt.teaches.model;
import java.time.LocalDate;

public class BookInput {

  private String name;
  private String author;
  private Status status = Status.TO_READ;
  private String publisher;
  private LocalDate publishedDate;
  private Genre genre;

  // Getters and Setters
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }

  public Status getStatus() { return status; }
  public void setStatus(Status status) { this.status = status; }

  public String getPublisher() { return publisher; }
  public void setPublisher(String publisher) { this.publisher = publisher; }

  public LocalDate getPublishedDate() { return publishedDate; }
  public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }

  public Genre getGenre() { return genre; }
  public void setGenre(Genre genre) { this.genre = genre; }

}