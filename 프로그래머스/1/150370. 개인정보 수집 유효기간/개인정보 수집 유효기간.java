import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String term : terms) {
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }
        
        int todayYear = Integer.parseInt(today.split("\\.")[0]);
        int todayMonth = Integer.parseInt(today.split("\\.")[1]);
        int todayDay = Integer.parseInt(today.split("\\.")[2]);

        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            int year = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[0]);
            int month = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[1]);
            int day = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[2]);
            String type = privacies[i].split(" ")[1];
            
            month += map.get(type);
            day -= 1;
            while (month > 12) {
                year += 1;
                month -= 12;
            }
            if (day == 0) {
                month -= 1;
                day = 28;
            }
            
            if (year > todayYear) {
                continue;
            }
            if (year == todayYear && month > todayMonth) {
                continue;
            }
            if (year == todayYear && month == todayMonth && day >= todayDay) {
                continue;
            }
            
            list.add(i + 1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}