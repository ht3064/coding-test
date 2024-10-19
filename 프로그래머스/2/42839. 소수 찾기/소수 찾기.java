import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "", 0);
        
        return set.size();
    }
    
    public void dfs(String numbers, String s, int cnt) {
        if (cnt > numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (isPrime(Integer.parseInt(s + numbers.charAt(i)))) {
                    set.add(Integer.parseInt(s + numbers.charAt(i)));
                }
                dfs(numbers, s + numbers.charAt(i), cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}