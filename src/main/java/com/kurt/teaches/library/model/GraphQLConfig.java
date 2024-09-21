package com.kurt.teaches.library.model;

import com.kurt.teaches.library.scalar.ISBNCoercing;
import com.kurt.teaches.library.scalar.YearCoercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

// without proxyBeanMethods = false the scalar isn't initialized before the graphql server
@Configuration(proxyBeanMethods = false)
public class GraphQLConfig {

  @Bean
  public RuntimeWiringConfigurer runtimeWiringConfigurer() {
    return wiringBuilder -> {
      wiringBuilder.scalar(dateScalar()).scalar(isbnScalar());
    };
  }

  private GraphQLScalarType dateScalar() {
    return GraphQLScalarType.newScalar()
            .name("Year")
            .description("A valid year prior to the current year.")
            .coercing(new YearCoercing())
            .build();
  }

  private GraphQLScalarType isbnScalar() {
    return GraphQLScalarType.newScalar()
            .name("ISBN")
            .description("A valid 13 or 10 digit ISBN.")
            .coercing(new ISBNCoercing())
            .build();
  }
}
