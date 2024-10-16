class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (String w : s.split(" ", -1)) {
            if (w.isBlank()) {
                sb.append(" ");
                continue;
            }
            
            sb.append(w.substring(0, 1).toUpperCase());
            sb.append(w.substring(1, w.length()).toLowerCase()).append(" ");
        }
        
        return sb.substring(0, sb.length() - 1).toString();
    }
}