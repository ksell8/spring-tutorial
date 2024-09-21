package com.kurt.teaches.library.scalar;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ISBNtoStringConverter implements Converter<String, ISBN> {
  @Override
  public ISBN convert(@NotNull String source) {
    return ISBN.of(source);
  }
}
