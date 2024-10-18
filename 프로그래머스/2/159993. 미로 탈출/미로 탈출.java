import java.util.*;

class Solution {
    static int drow;
    static int dcol;
    static char via = 'L';
    static boolean[][] visited;
    static final int[] mrow = {0, 0, 1, -1};
    static final int[] mcol = {1, -1, 0, 0};
    
    public int solution(String[] maps) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    drow = i;
                    dcol = j;
                } 
            }
        }
        
        int leverCnt = bfs(drow, dcol, maps);
        
        if (leverCnt == -1) {
            return -1;
        }
        
        int exitCnt = bfs(drow, dcol, maps);
        
        if (exitCnt == -1) {
            return -1;
        }
        
        return leverCnt + exitCnt;
    }
    
    public int bfs(int row, int col, String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];

        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(row, col, 0));
        visited[row][col] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (maps[cur.row].charAt(cur.col) == via) {
                drow = cur.row;
                dcol = cur.col;
                via = 'E';
                return cur.cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];
                
                if (canMove(nextRow, nextCol, maps)) {
                    q.add(new Node(nextRow, nextCol, cur.cnt + 1));
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        
        return -1;
    }
    
    public boolean canMove(int row, int col, String[] maps) {
        return row >= 0 && row < maps.length && col >= 0 && col < maps[0].length() 
            && !visited[row][col] && maps[row].charAt(col) != 'X';
    }
}

class Node {
    int row;
    int col;
    int cnt;
    
    public Node(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}