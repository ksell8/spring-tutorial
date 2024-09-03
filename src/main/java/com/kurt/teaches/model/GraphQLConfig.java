package com.kurt.teaches.model;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// without proxyBeanMethods = false the scalar isn't initialized before the graphql server
@Configuration(proxyBeanMethods = false)
public class GraphQLConfig {

  @Bean
  public RuntimeWiringConfigurer runtimeWiringConfigurer() {
    return wiringBuilder -> {
      wiringBuilder.scalar(dateScalar());
    };
  }

  private GraphQLScalarType dateScalar() {
    return GraphQLScalarType.newScalar()
            .name("Date")
            .description("A date in the ISO-8601 calendar system.")
            .coercing(new Coercing<LocalDate, String>() {
              // yyyy-mm-dd
              // TODO: create custom error for inappropriate scalar format/support other formats? Year only?
              private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

              @Override
              public String serialize(Object dataFetcherResult) {
                return ((LocalDate) dataFetcherResult).format(formatter);
              }

              @Override
              public LocalDate parseValue(Object input) {
                return LocalDate.parse((String) input, formatter);
              }

              @Override
              public LocalDate parseLiteral(Object input) {
                return LocalDate.parse((String) input, formatter);
              }
            })
            .build();
  }
}
