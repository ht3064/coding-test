class Solution {
    public String solution(String s, int n) {
        char[] ch = s.toCharArray();
        
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i] == ' ') {
                    break;
                }
                ch[i]++;
                if (ch[i] > 'z') {
                    ch[i] = 'a';
                } 
                if (ch[i] > 'Z' && ch[i] < 'a') {
                    ch[i] = 'A';
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : ch) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}