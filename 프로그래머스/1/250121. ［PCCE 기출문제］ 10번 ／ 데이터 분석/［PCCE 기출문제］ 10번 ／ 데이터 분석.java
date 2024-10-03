import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][map.get(ext)] < val_ext) {
                list.add(data[i]);
            }
        }
        
        list.sort(Comparator.comparing(arr -> arr[map.get(sort_by)]));
        
        return list;
    }
}