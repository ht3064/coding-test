import java.util.*;

class Solution {
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }

        for (int i = 0; i < stack.size() - k; i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}