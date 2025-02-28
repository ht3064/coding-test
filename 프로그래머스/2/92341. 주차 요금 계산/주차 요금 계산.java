import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> totalFee = new TreeMap<>();
        
        for (String record : records) {
            String[] str = record.split(" ");
            
            String time = str[0];
            int hour = Integer.parseInt(time.split(":")[0]) * 60;
            int minute = Integer.parseInt(time.split(":")[1]);
            int totalTime = hour + minute;
            
            String carNum = str[1];
            String inOut = str[2];
            
            if (inOut.equals("IN")) {
                map.put(carNum, totalTime);
            } else {
                if (!totalFee.containsKey(carNum)) {
                    totalFee.put(carNum, totalTime - map.get(carNum));
                } else {
                    totalFee.put(carNum, totalTime - map.get(carNum) + totalFee.get(carNum));
                }
                map.remove(carNum);
            }
        }
        
        if (!map.isEmpty()) {
            for (String key : map.keySet()) {
                Integer fee = totalFee.get(key);
                fee = (fee == null) ? 0 : fee;
                totalFee.put(key, fee + 1439 - map.get(key));
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (String key : totalFee.keySet()) {
            if (totalFee.get(key) < fees[0]) {
                list.add(fees[1]);
                continue;
            }
            int sum = (int) (fees[1] + Math.ceil((totalFee.get(key) - fees[0]) / (double) fees[2]) * fees[3]);
            list.add(sum);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}