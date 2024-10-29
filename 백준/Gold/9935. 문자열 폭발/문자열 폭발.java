import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String targetS = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);

            if (stack.size() >= targetS.length()) {
                boolean flag = true;

                for (int i = 0; i < targetS.length(); i++) {
                    if (stack.get(stack.size() - targetS.length() + i) != targetS.charAt(i)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int i = 0; i < targetS.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        for (char c : stack) {
            sb.append(c);
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
            return;
        }

        System.out.println(sb);
    }
}