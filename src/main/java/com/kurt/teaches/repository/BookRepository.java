package com.kurt.teaches.repository;

import com.kurt.teaches.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
  Book findByName(String name);
}
