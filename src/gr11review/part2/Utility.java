package gr11review.part2;

import java.io.*;

public class Utility {

  public static int sumNumbers(String str) {

    char letter;
    int strLength = str.length();
    int returnSum = 0;
    int intermediate = 0;

    for (int i = 0; i < strLength; i++) {
      letter = str.charAt(i);

      if (Character.isDigit(letter)) {
        intermediate = intermediate * 10 + Integer.parseInt(String.valueOf(letter));
      } else {
        returnSum += intermediate;
        intermediate = 0;
      }
    }

    if (Character.isDigit(str.charAt(strLength - 1))) {
      returnSum += intermediate;
    }

    return returnSum;
  }
}
