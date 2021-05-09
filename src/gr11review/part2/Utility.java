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

  public static String alphaWord(String filenametxt) {
    BufferedReader keyboard = new BufferedReader(new FileReader(filenametxt));

    String alphabetical = "";
    alphabetical = keyboard.readLine();
    String fileLine = "";

    while (fileLine != "null") {
      fileLine = keyboard.readLine();

      if (fileLine != "null" && alphabetical.compareTo(fileLine) > 0) {
        alphabetical = fileLine;
      }
    }

    return alphabetical;
  }

  public static int[] notAlone(int[] nums, int value) {

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == value && i > 0 && i < nums.length - 1) {
        if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
          if (nums[i + 1] > nums[i - 1]) {
            nums[i] = nums[i + 1];
          } else {
            nums[i] = nums[i - 1];
          }
        }
      }
    }

    return nums;
  }
}
