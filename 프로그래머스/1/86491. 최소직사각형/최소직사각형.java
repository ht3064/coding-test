import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int w = Integer.MIN_VALUE;
        int h = Integer.MIN_VALUE;
        
        for (int[] size : sizes) {
            Arrays.sort(size);
            w = Math.max(size[0], w);
            h = Math.max(size[1], h);
        }
        
        return w * h;
    }
}