import java.util.*;

class Solution {
    boolean solution(String s) {
        if (s.charAt(0) == ')') {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            if (stack.peek() == '(') {
                if (c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } 
        }
        
        if (stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}