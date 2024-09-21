class Solution {
    public long solution(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        long sum = 0;
        
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        
        return sum;
    }
}