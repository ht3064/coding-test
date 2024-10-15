import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        
        for (String st : s.split("")) {
            if (stack.isEmpty()) {
                stack.push(st);
                continue;
            }
        
            if (stack.peek().equals(st)) {
                stack.pop();
                continue;
            }
            
            stack.push(st);
        }
        
        if (stack.size() == 0) {
            return 1;
        }
        
        return 0;
    }
}