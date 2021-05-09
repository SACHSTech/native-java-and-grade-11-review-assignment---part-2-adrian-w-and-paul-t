package gr11review.part2;

import java.io.*;
import java.util.*;

public class Utility { 
  /**
     * Methods 1
     * Replaces all zips, zaps, and zops with zp
     * @author A. Wong
     */
  public static String zipZap(String methodInput){

      //Replaces all zaps, zips, and zops with zp
      methodInput = methodInput.replaceAll("zap","zp").replaceAll("zip","zp").replaceAll("zop","zp");

      return methodInput;

  }
  
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
     * File IO - Read 1
     * Reades a file and outputs the longest word in the file
     * @author A. Wong
     */

   public static String longestWord(String filenametxt) throws IOException{

        //Sets up a file scanner
        File myObj = new File(filenametxt);
        Scanner myReader = new Scanner(myObj);

        String longestWord = "";
        int length = 0;

        //While the file has more lines checks if the next word is longer
        //If it is it becomes the new set word
        while (myReader.hasNextLine()){

                String tempString = myReader.nextLine();

                if (tempString.length() >= length){

                    longestWord = tempString;
                    length = tempString.length();

                }

        }

        myReader.close();

        return longestWord;

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
      *Array 1 One Dimensional
      *For each multiple of 10 in the given array, 
      *change all the values following it to be that multiple of
      *10, until encountering another multiple of 10.
      *So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
      *@author A. Wong
      */

      public static int[] tenRun(int[] nums){

        int currentMultiple = 0;
        boolean hasReachedFirst = false;

        //Checks if the number is divisible by 10 without remainders
        //Replaces all following numbers with multiple of 10
        //If there is a new multiple of 10, it takes that number instead
        for (int counter = 0; counter < nums.length; counter++){

            if (nums[counter] % 10 == 0){

                currentMultiple = nums[counter];
                hasReachedFirst = true;

            }
            else if (hasReachedFirst){

                nums[counter] = currentMultiple;


            }


        }

        return nums;

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
       * Array 3 One Dimensional Two Loops
       * Checks to see if the outer array
       * Has the numbers of the inner array
       * Assuming both arrays are sorted by number size
       * @author A. Wong
       */
      public static boolean linearIn(int[] outer, int[] inner){

        //If the array is empty then it is always true
        if (inner.length == 0){

            return true;

        }

        int innerIndex = 0;
        boolean ifEqual;

        //Checks if the outer array number is bigger than the inner array number
        //If bigger return false
        for (int counter = 0; counter < outer.length; counter++){

            if(inner[innerIndex] < outer[counter]){

                return false;


            }
            //If equal add to counter
            //When counter equals array length return true
            else if (inner[innerIndex] == outer[counter]){

                innerIndex++;
                counter = 0;

                if (innerIndex == inner.length){

                    return true;

                }

            }

            

        }

        return false;

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
          * Array 5 - Two Dimensional
          * Prints a pascal's traingle with a size based on the inputed numbers
          * @author A. Wong
          */

        public static void pascalTri(int i, int j) throws IOException{

        //Sets up an array
        int[][] pascalArr = new int[i][j];

        //Sets up a file printer
        File myObj = new File("pascalOut.txt");
        FileWriter myWriter = new FileWriter("pascalOut.txt");
        
        myObj.createNewFile();

        for (int rowIndex = 0; rowIndex < i; rowIndex++){

            for (int columnIndex = 0; columnIndex < j; columnIndex++){

                //If the row or index is 0 set number to 1
                if (rowIndex == 0 || columnIndex == 0){

                    pascalArr[rowIndex][columnIndex] = 1;

                }
                //Adds the number above and the number to the left
                else{

                    pascalArr[rowIndex][columnIndex] = pascalArr[rowIndex - 1][columnIndex] + pascalArr[rowIndex][columnIndex - 1]; 

                }

                //If it is not the right most column, include a comma
                if (columnIndex < (j - 1)){

                    myWriter.write(pascalArr[rowIndex][columnIndex] + ",");

                }

            }

            //If it is the right most column make a new line
            myWriter.write(pascalArr[rowIndex][j - 1] + "\n");
            

        }

        myWriter.close();

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

