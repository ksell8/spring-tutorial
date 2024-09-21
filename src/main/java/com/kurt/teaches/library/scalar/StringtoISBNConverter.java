package com.kurt.teaches.library.scalar;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringtoISBNConverter implements Converter<ISBN, String> {
  @Override
  public String convert(ISBN source) {
    return source.getValue();
  }
}
