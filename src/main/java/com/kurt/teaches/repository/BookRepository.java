package com.kurt.teaches.repository;

import com.kurt.teaches.model.types.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
  Book findByName(String name);
  Page<Book> findAllBy(Pageable pageable);
}
