import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int hIdx = citations.length;
        
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= hIdx) {
                break;
            } else {
                hIdx--;
            }
        }
        
        return hIdx;
    }
}