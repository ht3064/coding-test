class Solution {
    public int[] solution(int n, int m) {
        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        
        int[] answer = new int[2];
        
        answer[0] = gcd(n, m);
        answer[1] = n * m / answer[0];
    
        return answer;
    }
    
    public int gcd(int n, int m) {
        while (m != 0) {
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}