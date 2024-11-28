import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && numbers[i] >= stack.peek()) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            
            stack.push(numbers[i]);
        }
        
        return result;
    }
}