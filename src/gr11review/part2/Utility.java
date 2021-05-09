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

    String alphabetical;
    alphabetical = keyboard.readLine();
    String fileLine = "";

    //reads file until end
    while (fileLine != "null") {
      fileLine = keyboard.readLine();

      //checks if new word is alphabetically first
      if (fileLine != "null" && alphabetical.compareTo(fileLine) > 0) {
        alphabetical = fileLine;
      }
    }

    return alphabetical;
  }

  public static int[] notAlone(int[] nums, int value) {

    //Checks if each element of the array with the value is alone
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == value && i > 0 && i < nums.length - 1) {
        if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
          nums[i] = Math.max(nums[i - 1], nums[i + 1]);
        }
      }
    }

    return nums;
  }

  public static boolean canBalance(int[] nums) {
    int arrayLength = nums.length;

    int arraySum = 0;
    int leftSide = 0;

    //Calculate sum of array
    for (int i = 0; i < arrayLength; i++) {
      arraySum += nums[i];
    }
      
    //If leftSide of array is equal to half of arraySum at any point, array can be split
    for (int j = 0; j < arrayLength; j++) {
      leftSide += nums[j];
            
      if (leftSide * 2 == arraySum) {
        return true;
      }
    }

    return false;
	}
  
}
