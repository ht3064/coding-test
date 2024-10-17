import java.util.*;

class Solution {
    static final char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        List<String> list = new ArrayList<>();
        
        dfs(list, "");
        
        return list.indexOf(word);
    }
    
    public void dfs(List<String> list, String word) {
        list.add(word);
        
        if (word.length() == 5) {
            return;
        }
        
        for (char c : alphabet) {
            dfs(list, word + c);
        }
    }
}