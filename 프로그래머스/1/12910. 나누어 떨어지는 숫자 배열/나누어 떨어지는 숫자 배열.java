import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for (int a : arr) {
            if (a % divisor == 0) {
                list.add(a);
            }
        }
        
        if (list.size() == 0) {
            return new int[]{-1};
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}