import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
        
    public List<int[]> solution(int n) {
        hanoi(n, 1, 2, 3);
        
        return list;
    }
    
    private void hanoi(int n, int s, int m, int e) {
        if (n == 0) {
            return;
        }
        
        hanoi(n - 1, s, e, m);
        list.add(new int[]{s, e});
        hanoi(n - 1, m, s, e);
    }
}