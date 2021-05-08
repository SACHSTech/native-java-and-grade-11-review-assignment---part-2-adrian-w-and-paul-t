package gr11review.part2;
import java.io.*;

public class Utility {

    /**
     * Replaces all zips, zaps, and zops with zp
     * @author A. Wong
     */
    public static String zipZap(String methodInput){

        methodInput = methodInput.replaceAll("zap","zp").replaceAll("zip","zp").replaceAll("zop","zp");

        return methodInput;

    }

    
}
