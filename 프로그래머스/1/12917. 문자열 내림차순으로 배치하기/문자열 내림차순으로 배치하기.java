import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[s.length()];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.split("")[i];
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (String a : arr) {
            sb.append(a);
        }
        
        return sb.toString();
    }
}