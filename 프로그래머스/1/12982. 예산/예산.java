import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        
        for (int i = 0; i < d.length; i++) {
            budget = budget - d[i];
            if (budget < 0) {
                return answer;
            }
            answer++;
        }
        
        return answer;
    }
}