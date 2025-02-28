class Solution {
    public int solution(int n, int k) {
        int res = 0;
        String[] arr = Long.toString(n, k).split("0");
        
        for (String s : arr) {
            if (s.isBlank() || s.isEmpty()) {
                continue;
            }
            if (isPrime(Long.parseLong(s))) {
                res++;
            }
        }
        
        return res;
    }
    
    private boolean isPrime(long num) {
        if (num == 0 || num == 1) {
            return false;
        }
        
        for (long i = 2; i <= (long) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}