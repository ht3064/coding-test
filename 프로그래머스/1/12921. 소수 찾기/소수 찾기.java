class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 2; i <= n; i++) {
            int count = 0;
            
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    count++;
                }
                if (count >= 2) {
                    break;
                }
            }
            
            if (count == 1) {
                answer++;
            }
        }
        
        return answer;
    }
}