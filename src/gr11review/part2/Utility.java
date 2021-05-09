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
       * Array 3 One Dimensional Two Loops
       * Checks to see if the outer array
       * Has the numbers of the inner array
       * Assuming both arrays are sorted by number size
       * @author A. Wong
       */
      public static boolean linearIn(int[] outer, int[] inner){

        if (inner.length == 0){

            return true;

        }


        int innerIndex = 0;
        boolean ifEqual;

        for (int counter = 0; counter < outer.length; counter++){

            if(inner[innerIndex] < outer[counter]){

                return false;


            }
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
       * Array 5 - Two Dimensional
       * Prints a pascal's traingle with a size based on the inputed numbers
       * @author A. Wong
       */

       public static void pascalTri(int i, int j) throws IOException{

        int[][] pascalArr = new int[i][j];

        File myObj = new File("pascalOut.txt");
        FileWriter myWriter = new FileWriter("pascalOut.txt");
        
        myObj.createNewFile();

        for (int rowIndex = 0; rowIndex < i; rowIndex++){

            for (int columnIndex = 0; columnIndex < j; columnIndex++){

                if (rowIndex == 0 || columnIndex == 0){

                    pascalArr[rowIndex][columnIndex] = 1;

                }
                else{

                    pascalArr[rowIndex][columnIndex] = pascalArr[rowIndex - 1][columnIndex] + pascalArr[rowIndex][columnIndex - 1]; 

                }

                if (columnIndex < (j - 1)){

                    myWriter.write(pascalArr[rowIndex][columnIndex] + ",");

                }

            }

            myWriter.write(pascalArr[rowIndex][j - 1] + "\n");
            

        }

        myWriter.close();

       }

}