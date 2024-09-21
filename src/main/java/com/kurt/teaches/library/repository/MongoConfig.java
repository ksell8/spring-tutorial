package com.kurt.teaches.library.repository;

import com.kurt.teaches.library.scalar.ISBNtoStringConverter;
import com.kurt.teaches.library.scalar.IntegerToYearConverter;
import com.kurt.teaches.library.scalar.StringtoISBNConverter;
import com.kurt.teaches.library.scalar.YearToIntegerConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

@Configuration
public class MongoConfig {

  @Bean
  public MongoCustomConversions customConversions() {
    return new MongoCustomConversions(Arrays.asList(
            new YearToIntegerConverter(),
            new IntegerToYearConverter(),
            new ISBNtoStringConverter(),
            new StringtoISBNConverter()
    ));
  }
}
