import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }
        
        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (list.get(0).equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
    
        return sb.toString();
    }
}