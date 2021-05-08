package gr11review.part2;
import java.io.*;
import java.util.Scanner;

public class Utility {

    /**
     * Methods 1
     * Replaces all zips, zaps, and zops with zp
     * @author A. Wong
     */
    public static String zipZap(String methodInput){

        methodInput = methodInput.replaceAll("zap","zp").replaceAll("zip","zp").replaceAll("zop","zp");

        return methodInput;

    }

    /**
     * File IO - Read 1
     * Reades a file and outputs the longest word in the file
     * @author A. Wong
     */

     public static String longestWord(String filenametxt) throws IOException{

        File myObj = new File(filenametxt);
        Scanner myReader = new Scanner(myObj);

        String longestWord = "";
        int length = 0;

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
      * Array 1 One Dimensional
      *@author A. Wong
      */
      
      public static int[] tenRun(int[] nums){

        int currentMultiple = 0;
        boolean hasReachedFirst = false;

        for (int counter = 0; counter <= nums.length; counter++){

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
    
}
