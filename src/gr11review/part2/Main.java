package gr11review.part2;

import java.io.*;

public class Main {
  public static void main(String[] args)throws IOException {

    System.out.println(Utility.sumNumbers("5233 87 hasdfas"));

    System.out.println(Utility.alphaWord("test.txt"));

    int[] array = {1,2,3,4};
    array = Utility.notAlone(array, 2);

    for (int element: array) {
      System.out.println(element);
    }

    System.out.println("hi");
  }
}