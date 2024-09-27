class Solution {
    public int solution(int n, int m, int[] section) {
        int roller = section[0];
        int count = 1;
    
        for (int i = 1; i < section.length; i++) {
            if (section[i] > roller + m - 1) {
                count++;
                roller = section[i];
            }
        }
        
        return count;
    }
}