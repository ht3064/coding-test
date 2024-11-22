import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] crr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = crr[j] - '0';
            }
        }
        
        dijkstra();
        
        System.out.println(min);
    }
    
    private static void dijkstra() {
        visited = new boolean[n][n];
        visited[0][0] = true;
        
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        q.add(new Node(0, 0, 0));
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.row == n - 1 && cur.col == n - 1) {
                min = Math.min(min, cur.cnt);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];
                
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }
                
                if (!visited[nextRow][nextCol]) {
                    if (map[nextRow][nextCol] == 0) {
                        visited[nextRow][nextCol] = true;
                        q.add(new Node(nextRow, nextCol, cur.cnt + 1));
                    } else if (map[nextRow][nextCol] == 1) {
                        visited[nextRow][nextCol] = true;
                        q.add(new Node(nextRow, nextCol, cur.cnt));                        
                    }
                }
            }
        }
    }
    
    static class Node {
        int row;
        int col;
        int cnt;
        
        public Node(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
}