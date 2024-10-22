class Solution {
    public int solution(int n) {
        int startIdx = 1;
        int endIdx = 1;
        
        int sum = 1;
        int cnt = 1;
        
        while (endIdx != n) {
            if (sum < n) {
                endIdx++;
                sum += endIdx;
            } else if (sum > n) {
                sum -= startIdx;
                startIdx++;
            } else {
                cnt++;
                endIdx++;
                sum += endIdx;
            }
        }
        
        return cnt;
    }
}