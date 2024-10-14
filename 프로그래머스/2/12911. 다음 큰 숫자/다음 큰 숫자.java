class Solution {
    public int solution(int n) {
        int k = n + 1;

        while (true) {
            int countK = countNum(k);
            if (countK == countNum(n)) {
                return k;
            }
            k++;
        }
    }
    
    private int countNum(int num) {
        int countNum = 0;
        char[] arr = Integer.toString(num, 2).toCharArray();
        for (char c : arr) {
            if (c == '1') {
                countNum++;
            }
        }
        return countNum;
    } 
}