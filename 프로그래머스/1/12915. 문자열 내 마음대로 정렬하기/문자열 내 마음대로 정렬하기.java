import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        int i = 0;
        for (String string : strings) {
            answer[i] = string.charAt(n) + string;
            i++;
        }
        
        Arrays.sort(answer);
        
        int j = 0;
        for (String a : answer) {
            answer[j] = a.substring(1, a.length());
            j++;
        }
        
        return answer;
    }
}