import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            indexMap.put(id_list[i], i);
        }
        
        for (String s : report) {
            map.get(s.split(" ")[1]).add(s.split(" ")[0]);
        }
        
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> set = map.get(id_list[i]);
            if (set.size() >= k) {
                for (String s : set) {
                    answer[indexMap.get(s)]++;
                }
            }
        }
        
        return answer;
    }
}