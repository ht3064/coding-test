import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int num = board[i][move - 1];
                
                if (num != 0) {
                    if (stack.isEmpty()) {
                        stack.push(num);
                        board[i][move - 1] = 0;
                        break;
                    } 
                    if (!stack.isEmpty() && num != stack.peek()) {
                        stack.push(num);
                        board[i][move - 1] = 0;
                        break;
                    }
                    if (!stack.isEmpty() && num == stack.peek()) {
                        stack.pop();
                        board[i][move - 1] = 0;
                        answer += 2;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}