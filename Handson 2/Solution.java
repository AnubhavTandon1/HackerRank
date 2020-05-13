import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        // Split the string by :
    String[] sTime = s.split(":");

    int x = 0;

    // if PM and hours >12, add additional 12 to hours
    // for AM and hour = 12, set hour to 00
    if(sTime[sTime.length - 1].contains("PM") && !sTime[0].equals("12"))
        x = 12;

    String val1 = "";
    if(x == 12)
        val1 = (Integer.parseInt(sTime[0]) + x) + "";
    else {
        if(sTime[0].equals("12") && sTime[sTime.length - 1].contains("AM"))
            val1 = "00";
        else
            val1 = sTime[0];
    }

    // merge the string and return the result
    String result = val1 + ":" + sTime[1] + ":" + sTime[2].substring(0,2);
    return result;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
