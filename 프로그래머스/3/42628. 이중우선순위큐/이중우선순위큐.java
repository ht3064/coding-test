import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
        
        for (String op : operations) {
            String command = op.split(" ")[0];
            int num = Integer.parseInt(op.split(" ")[1]);
            
            if (command.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (map.isEmpty()) {
                    continue;
                }
                
                int key = 0;
                if (num == 1) {
                    key = map.firstKey();
                } else {
                    key = map.lastKey();
                }
                
                int count = map.get(key);
                if (count == 1) {
                    map.remove(key);
                } else {
                    map.put(key, count - 1);
                }
            }
        }
        
        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{map.firstKey(), map.lastKey()};
    }
}