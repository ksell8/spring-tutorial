package com.kurt.teaches.library;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class LibraryApplication {

	@Bean
	public RuntimeWiringConfigurer runtimeWiringConfigurer() {
		return wiringBuilder -> {
			wiringBuilder.scalar(dateTimeScalar());
		};
	}

	private GraphQLScalarType dateTimeScalar() {
		return GraphQLScalarType.newScalar()
						.name("DateTime")
						.description("A date in the ISO-8601 calendar system.")
						.coercing(new Coercing<LocalDate, String>() {
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

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
