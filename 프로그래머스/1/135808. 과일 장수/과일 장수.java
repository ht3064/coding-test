import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int sum = 0;
        
        Arrays.sort(score);
        
        for (int i = score.length - 1; i >= m - 1; i -= m) {
            sum += m * score[i - m + 1];
        }
        
        return sum;
    }
}