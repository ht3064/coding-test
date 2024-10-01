class Solution {
    public String solution(String s) {
        String[] word = s.split(" ", -1);
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < word.length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < word[i].length(); j++) {
                if (j % 2 == 0) {
                    sb.append(Character.toUpperCase(word[i].charAt(j)));
                } else {
                    sb.append(Character.toLowerCase(word[i].charAt(j)));
                }
            }
            answer.append(sb);
            if (word.length - 1 != i) {
                answer.append(" ");
            }
        }
        
        return answer.toString();
    }
}