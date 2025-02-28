class Solution {
    static int[] res = new int[11];
    static int[] lion;
    static int max = Integer.MIN_VALUE;
    
    public int[] solution(int n, int[] info) {
        backtracking(0, n, info);
        
        if (max == -1) {
            return new int[]{-1};
        }
        
        return lion;
    }
    
    private void backtracking(int depth, int n, int[] info) {
        if (depth == n) {
            int diff = diff(info);
            if (max <= diff) {
                max = diff;
                lion = res.clone();
            }
            
            return;
        }
        
        for (int i = 0; i < info.length && res[i] <= info[i]; i++) {
            res[i]++;
            backtracking(depth + 1, n, info);
            res[i]--;
        }
    }
    
    private int diff(int[] info) {
        int appeach = 0;
        int lion = 0;
        
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0 && res[i] == 0) {
                continue;
            }
            
            if (res[i] <= info[i]) {
                appeach += (10 - i);
            } else {
                lion += (10 - i);
            }
        }
        
        int diff = lion - appeach;
        if (diff <= 0) {
            return -1;
        }
        
        return diff;
    }
}