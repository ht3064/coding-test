import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        List<String> list = new ArrayList<>();
        String start = words[0];
        list.add(start);
        
        for (int i = 1; i < words.length; i++) {
            if (start.charAt(start.length() - 1) == words[i].charAt(0) && !list.contains(words[i])) {
                list.add(words[i]);
                start = words[i];
            } else {
                int count = 1;
                while (i + 1 > n) {
                    i -= n;
                    count++;
                }
                answer[0] = i + 1;
                answer[1] = count;
                break;
            }
        }

        return answer;
    }
}