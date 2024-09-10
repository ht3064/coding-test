class Solution {
    public long[] solution(long x, int n) {
        long[] arr = new long[n];
        long add = x;
        
        for (int i = 0; i < n; i++) {
            arr[i] = x;
            x += add;
        }
        
        return arr;
    }
}