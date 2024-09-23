class Solution {
    boolean solution(String s) {
        
        s = s.toLowerCase();
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'p') {
                count++;
            }
            if (c == 'y') {
                count--;
            }
        }
        
        if (count == 0) {
            return true;
        }
        
        return false;
    }
}