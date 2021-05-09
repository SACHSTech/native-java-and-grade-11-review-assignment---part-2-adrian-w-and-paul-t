package gr11review.part2;

import java.io.*;
import java.util.*;

public class Utility {
  
  /**
     * Methods 2
     * Returns the sum of all distinct numbers in a string
     * @author P. Tran
     */
  public static int sumNumbers(String str) {
    
    char letter;
    int strLength = str.length();
    int returnSum = 0;
    int intermediate = 0;

    //checks each letter
    for (int i = 0; i < strLength; i++) {
      letter = str.charAt(i);

      //if digit, multiply previous digit by 10 and add on
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
  
    /**
     * File IO 2
     * Returns the alphabetically first word in a text file
     * @author P. Tran
     */
    public static String alphaWord(String filenametxt)throws IOException {

      String alphabetical = "";

      try {
        BufferedReader keyboard = new BufferedReader(new FileReader(filenametxt));
      
        String fileLine = "";
        alphabetical = keyboard.readLine();

        while(fileLine != "null") {
          fileLine = keyboard.readLine();
          if (fileLine != "null" && alphabetical.compareTo(fileLine) > 0) {
            alphabetical = fileLine;
          }
        }

        keyboard.close();

       } catch(Exception e) {
         System.out.println("Error.");
       }

       return alphabetical;
     }

      /**
        * Array 2
        * All "alone" elements take on the greater of the two values to the left and right of it
        * @author P. Tran
        */
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


       
      /**
        * Array 4
        * Returns true if an integer array can be split so that the sum of the numbers on both sides are equal
        * @author P. Tran
        */
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

  /**
     * Array 6
     * Prints onto a text file a two dimensional array of size n
     * @author P. Tran
     */
  public static void diagonal(int n)throws IOException {

    try {
      PrintWriter theout = new PrintWriter(new FileWriter("src/grd11review/part2/diagonalOut.txt", true));

      String line = "";

      //i and j are row and column indexes
      for (int i = 0; i < n; i++) {
        line = "";

        //add 0, 1, 2 to line according to array position
        for (int j = 0; j < n; j++) {
          if (i + j == n - 1) {
            line += "1";
          } else if (i + j > n - 1) {
            line += "2";
          } else {
            line += "0";
          }

          //add comma to number if not at the end
          if (j != n - 1) {
            line += ",";
          }
        }
        theout.println(line);
      }
      theout.close();
    } catch(Exception e) {
      System.out.println("error.");
    }
  }
}

