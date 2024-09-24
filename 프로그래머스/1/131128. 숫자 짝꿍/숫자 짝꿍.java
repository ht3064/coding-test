import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> mapX = new HashMap<>();
        Map<String, Integer> mapY = new HashMap<>();
        
        for (String s : X.split("")) {
            mapX.put(s, mapX.getOrDefault(s, 0) + 1);
        }
        
        for (String s : Y.split("")) {
            mapY.put(s, mapY.getOrDefault(s, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 9; i >= 0; i--) {
            String key = String.valueOf(i);
            if (mapX.containsKey(key) && mapY.containsKey(key)) {
                for(int j = 0; j < Math.min(mapX.get(key), mapY.get(key)); j++) {
                    sb.append(key);
                }
            }
        }
        
        if (sb.toString().equals("")) {
            return "-1";
        } else if (sb.toString().startsWith("0")) {
            return "0";
        }
        
        return sb.toString();
    }
}