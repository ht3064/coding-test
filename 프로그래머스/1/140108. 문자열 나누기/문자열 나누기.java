class Solution {
    public int solution(String s) {
        int answer = 0;
        
        while (s.length() > 0) {
            int count = 1;
            
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(0) == s.charAt(i)) {
                    count++;
                } else if (s.charAt(0) != s.charAt(i)) {
                    count--;
                }
            
                if (count == 0) {
                    answer++;
                    s = s.substring(i + 1, s.length());
                    break;
                }
            }
            if (count != 0) {
                answer++;
                s = "";
            }
        }
        
        return answer;
    }
}