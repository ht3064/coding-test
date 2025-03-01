import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        
        for (String str : info) {
            String[] data = str.split(" ");
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            Integer score = Integer.parseInt(data[4]);
            
            for (String language : languages) {
                for (String job : jobs) {
                    for (String exp : exps) {
                        for (String food : foods) {
                            String[] keyData = {language, job, exp, food};
                            String key = String.join(" ", keyData);
                            
                            ArrayList<Integer> list = map.getOrDefault(key, new ArrayList<>());
                            list.add(score);
                            
                            map.put(key, list);
                        }
                    }
                }
            }
        }
        
        for (ArrayList<Integer> list : map.values()) {
            list.sort(null);
        }
        
        int[] res = new int[query.length];
        int idx = 0;
        for (String q : query) {
            String[] data = q.split(" and ");
            Integer target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            
            String key = String.join(" ", data);
            
            if (map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key);
                
                int left = 0;
                int right = list.size();
                
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                
                res[idx] = list.size() - left;
            }
            idx++;
        }
        
        return res;
    }
}