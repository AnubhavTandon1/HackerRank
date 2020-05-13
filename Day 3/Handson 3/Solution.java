import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static HashMap<Character, Character> bMap;

    static {
        bMap = new HashMap<>();
        bMap.put('(', ')');
        bMap.put('[', ']');
        bMap.put('{', '}');
    }

    static String isBalanced(String str) {

        if ((str.length() % 2) != 0) {
            return "NO";
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(bMap.containsKey(ch)) {
                stack.push(ch);
            } else if(stack.isEmpty() || ch != bMap.get(stack.pop())) {
                return "NO";
            }
        }

        return stack.isEmpty()? "YES": "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
