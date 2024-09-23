class Solution {
    public int solution(int n) {
        String[] arr = String.valueOf(n).split("");
        
        int sum = 0;
        
        for (String a : arr) {
            sum += Integer.parseInt(a);
        }
        
        return sum;
    }
}