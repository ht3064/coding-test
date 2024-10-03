class Solution {
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        
        int n = board.length;
        String color = board[h][w];
        
        int[] dh = {0, 0, 1, -1};
        int[] dw = {1, -1, 0, 0};
        
        for (int i = 0; i <= 3; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            
            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                if (color.equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}