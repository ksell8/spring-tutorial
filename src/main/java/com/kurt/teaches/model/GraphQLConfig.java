package com.kurt.teaches.model;

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
      wiringBuilder.scalar(dateScalar());
    };
  }

  private GraphQLScalarType dateScalar() {
    return GraphQLScalarType.newScalar()
            .name("Year")
            .description("A valid year prior to the current year.")
            .coercing(new YearCoercing())
            .build();
  }
}
