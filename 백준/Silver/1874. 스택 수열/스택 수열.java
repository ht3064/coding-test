import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack();

        int start = 1;
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            while (num >= start) {
                stack.push(start++);
                sb.append("+\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}