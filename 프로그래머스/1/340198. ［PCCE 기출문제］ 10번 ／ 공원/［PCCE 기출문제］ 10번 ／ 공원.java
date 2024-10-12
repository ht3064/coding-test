import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] arr = new int[park.length][park[0].length];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (park[i][j].equals("-1")) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
    
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                
                arr[i][j] = Math.min(arr[i - 1][j - 1], Math.min(arr[i][j - 1], arr[i - 1][j])) + 1;
                set.add(arr[i][j]);
            }
        }
        
        int answer = -1;
        for (int i : mats) {
            if (set.contains(i)) {
                answer = Math.max(answer, i);
            }
        }
        
        return answer;
    }
}