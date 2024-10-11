import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[] answer = new char[4];

        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            char before = survey[i].charAt(0);
            char after = survey[i].charAt(1);
            int score = choices[i];
            
            if (score > 4) {
                map.put(after, map.getOrDefault(after, 0) + score - 4);
            } else if (score < 4) {
                map.put(before, map.getOrDefault(before, 0) + 4 - score);
            }
        }
        
        String[] arr = {"RT", "CF", "JM", "AN"};

        StringBuilder sb = new StringBuilder();
        
        for (String s : arr) {
            if (map.getOrDefault(s.charAt(0), 0) < map.getOrDefault(s.charAt(1), 0)) {
                sb.append(s.charAt(1));
            } else {
                sb.append(s.charAt(0));
            }
        }
        
        return sb.toString();
    }
}