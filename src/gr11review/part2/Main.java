package gr11review.part2;

import java.io.*;

public class Main {
  public static void main(String[] args)throws IOException {

    System.out.println(Utility.sumNumbers("872xx2x4 22"));
    
    System.out.println(Utility.alphaWord("src/gr11review/test2/Review2_3Test_3.txt"));

    System.out.println(Utility.notAlone(new int[] {1,2,3,4}, 2));

    System.out.println(Utility.canBalance(new int[] {1,1,1,1,2,}));

    Utility.diagonal(3);
  }
}