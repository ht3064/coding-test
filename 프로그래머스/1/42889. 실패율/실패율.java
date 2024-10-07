import java.util.*;

class Solution {
    public List solution(int N, int[] stages) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Double> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            map.put(i, (double) 0);
        }
        
        for (int stage : stages) {
            if (stage > N) {
                continue;
            } 
            cntMap.put(stage, cntMap.getOrDefault(stage, 0) + 1);
        }
        
        int len = stages.length;
        for (int key : cntMap.keySet()) {
            map.put(key, (double) cntMap.get(key) / len);
            len -= cntMap.get(key);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list;
    }
}