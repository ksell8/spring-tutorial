package com.kurt.teaches.library.scalar;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.time.Year;
import java.util.Locale;

public class ISBNCoercing implements Coercing<ISBN, String> {
  @Override
  public String serialize(@NotNull Object dataFetcherResult,
                           @NotNull GraphQLContext graphQLContext,
                           @NotNull Locale locale)
          throws CoercingSerializeException {
    if (dataFetcherResult instanceof ISBN) {
      return ((ISBN) dataFetcherResult).getValue();
    } else {
      throw new CoercingSerializeException("Expected a ISBN object.");
    }
  }

  @Override
  public ISBN parseValue(@NotNull Object input,
                         @NotNull GraphQLContext graphQLContext,
                         @NotNull Locale locale)
          throws CoercingParseValueException {
    if (input instanceof String) {
      try {
        ISBN isbn = ISBN.of((String) input);
        return isbn;
      } catch (Exception e) {
        throw new CoercingParseValueException("Invalid year format.");
      }
    } else {
      throw new CoercingParseValueException("Expected a Integer.");
    }
  }

  @Override
  public ISBN parseLiteral(@NotNull Value<?> input,
                           @NotNull CoercedVariables variables,
                           @NotNull GraphQLContext graphQLContext,
                           @NotNull Locale locale) throws CoercingParseLiteralException {
    if (input instanceof graphql.language.StringValue) {
      try {
        return ISBN.of(((graphql.language.StringValue) input).getValue());
      } catch (Exception e) {
        throw new CoercingParseLiteralException(String.format("Invalid ISBN format. %s", e));
      }
    } else {
      throw new CoercingParseLiteralException("Expected an StringValue.");
    }
  }

  @Override
  public @NotNull Value<?> valueToLiteral(@NotNull Object input,
                                          @NotNull GraphQLContext graphQLContext,
                                          @NotNull Locale locale) {
    if (input instanceof String) {
      // check it's a valid ISBN
      ISBN.validate((String) input);
      return new graphql.language.StringValue((String) input);
    } else {
      throw new UnsupportedOperationException("Input is not a valid string for valueToLiteral.");
    }
  }
}
