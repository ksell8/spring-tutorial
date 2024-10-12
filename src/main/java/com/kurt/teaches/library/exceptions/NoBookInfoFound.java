package com.kurt.teaches.library.exceptions;

public class NoBookInfoFound extends Exception{
  public NoBookInfoFound(String isbn){
    super(String.format("No data found for isbn: %s", isbn));
  }
}
