import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        int cameraCnt = 0;
        int cameraPos = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] > cameraPos) {
                cameraCnt++;
                cameraPos = route[1];
            }
        }
        
        return cameraCnt;
    }
}