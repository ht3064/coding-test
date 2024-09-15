class Solution {
    public int solution(int n) {
        if (n % 2 == 1) {
            return 2;
        }
    
        for (int i = 3; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
    
        return n;
    }
}