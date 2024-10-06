package com.kurt.teaches.library.scalar;

public class ISBN {
  private final String formattedValue;

  public ISBN(String formattedValue) {
    this.formattedValue = formattedValue;
  }

  // Factory method to create an ISBN object
  public static ISBN of(String value) {
    validate(value);
    return new ISBN(value);
  }

  public static void validate(String input) {
    String cleanedInput = removeHyphens(input);

    if (cleanedInput.length() == 10) {
      validateISBN10(input, cleanedInput);
    } else if (cleanedInput.length() == 13) {
      validateISBN13(input, cleanedInput);
    } else {
      throw new IllegalArgumentException("Invalid ISBN length. Must be either 10 or 13 digits.");
    }
  }

  public String getValue() {
    return formattedValue;
  }

  private static String removeHyphens(String input) {
    return input.replace("-", "");
  }

  private static void validateISBN10(String originalInput, String digitsOnly) {
    for (int i = 0; i < 9; i++) {
      if (!Character.isDigit(digitsOnly.charAt(i))) {
        throw new IllegalArgumentException("ISBN-10 must contain digits in the first 9 positions.");
      }
    }

    // Check if the last character is a digit or 'X' (which represents 10)
    char lastChar = digitsOnly.charAt(9);
    if (!Character.isDigit(lastChar) && lastChar != 'X') {
      throw new IllegalArgumentException("ISBN-10 last character must be a digit or 'X'.");
    }

    // Validate checksum for ISBN-10
    if (!isValidISBN10Checksum(digitsOnly)) {
      throw new IllegalArgumentException("Invalid ISBN-10 checksum.");
    }
  }

  private static void validateISBN13(String originalInput, String digitsOnly) {
    // Check if all characters are digits
    if (!digitsOnly.matches("\\d{13}")) {
      throw new IllegalArgumentException("ISBN-13 must only contain digits.");
    }

    // ISBN-13 must start with 978 or 979
    if (!(digitsOnly.startsWith("978") || digitsOnly.startsWith("979"))) {
      throw new IllegalArgumentException("ISBN-13 must start with '978' or '979'.");
    }

    // Validate checksum for ISBN-13
    if (!isValidISBN13Checksum(digitsOnly)) {
      throw new IllegalArgumentException("Invalid ISBN-13 checksum.");
    }
  }

  private static boolean isValidISBN10Checksum(String digitsOnly) {
    int sum = 0;

    // Use decreasing weights starting from 10 down to 2 for the first 9 digits
    for (int i = 0; i < 9; i++) {
      sum += (10 - i) * Character.getNumericValue(digitsOnly.charAt(i));
    }

    // Check the last character
    char lastChar = digitsOnly.charAt(9);
    int checksum = (lastChar == 'X') ? 10 : Character.getNumericValue(lastChar);

    // Add the last digit's contribution
    sum += checksum;

    return sum % 11 == 0;
  }

  private static boolean isValidISBN13Checksum(String digitsOnly) {
    int sum = 0;
    // add each number to the sum alternating with weights 1 & 3
    for (int i = 0; i < 12; i++) {
      int digit = Character.getNumericValue(digitsOnly.charAt(i));
      sum += (i % 2 == 0) ? digit : 3 * digit;
    }

    int checksum = (10 - (sum % 10)) % 10;
    // checksum is equivalent to last digit
    return checksum == Character.getNumericValue(digitsOnly.charAt(12));
  }
}