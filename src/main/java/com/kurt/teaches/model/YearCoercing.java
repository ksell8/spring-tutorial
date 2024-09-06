package com.kurt.teaches.model;
import org.jetbrains.annotations.NotNull;

import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.schema.CoercingSerializeException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingParseLiteralException;

import java.math.BigInteger;
import java.time.Year;
import java.util.Locale;


public class YearCoercing implements Coercing<Year, Integer> {

  @Override
  public Integer serialize(@NotNull Object dataFetcherResult,
                           @NotNull GraphQLContext graphQLContext,
                           @NotNull Locale locale)
          throws CoercingSerializeException {
    if (dataFetcherResult instanceof Year) {
      return ((Year) dataFetcherResult).getValue();
    } else {
      throw new CoercingSerializeException("Expected a Year object.");
    }
  }

  @Override
  public Year parseValue(@NotNull Object input,
                              @NotNull GraphQLContext graphQLContext,
                              @NotNull Locale locale)
          throws CoercingParseValueException {
    if (input instanceof Integer) {
      try {
        Year year = Year.of((Integer) input);
        validateYear(year);
        return year;
      } catch (Exception e) {
        throw new CoercingParseValueException("Invalid year format.");
      }
    } else {
      throw new CoercingParseValueException("Expected a Integer.");
    }
  }

  private static void validateYear(Year year) {
    if (year.isAfter(Year.now())) {
      throw new IllegalArgumentException("Year must be less than or equal to the current year.");
    }
  }

  @Override
  public Year parseLiteral(@NotNull Value<?> input,
                           @NotNull CoercedVariables variables,
                           @NotNull GraphQLContext graphQLContext,
                           @NotNull Locale locale) throws CoercingParseLiteralException {
    if (input instanceof graphql.language.IntValue) {
      try {
        Year year = Year.of(((graphql.language.IntValue) input).getValue().intValue());
        validateYear(year);
        return year;
      } catch (Exception e) {
        throw new CoercingParseLiteralException(String.format("Invalid year format. %s", e));
      }
    } else {
      throw new CoercingParseLiteralException("Expected an IntValue.");
    }
  }

  @Override
  public @NotNull Value<?> valueToLiteral(@NotNull Object input,
                                          @NotNull GraphQLContext graphQLContext,
                                          @NotNull Locale locale) {
    if (input instanceof Integer) {
      Year year = Year.of((Integer) input);
      validateYear(year);
      return new graphql.language.IntValue(BigInteger.valueOf((Integer) input));
    } else {
      throw new UnsupportedOperationException("Input is not a valid string for valueToLiteral.");
    }
  }
}