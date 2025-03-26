class Solution {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        boolean isFind = false;
        for (String word : words) {
            if (word.equals(target)) {
                isFind = true;
            }
        }
        
        if (!isFind) {
            return 0;
        }
        
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return min;
    }
    
    private void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            min = Math.min(min, cnt);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (isChange(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean isChange(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        
        if (diff == 1) {
            return true;
        }
        
        return false;
    }
}