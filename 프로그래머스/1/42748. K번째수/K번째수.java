import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] subArr = new int[j - i + 1];
            int index = 0;
            
            for (int b = i - 1; b <= j - 1; b++) {
                subArr[index++] = array[b];
            }
            
            Arrays.sort(subArr);
            
            answer[a] = subArr[k - 1];
        }
        
        return answer;
    }
}