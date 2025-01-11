import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[][] map;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = arr[j] - '0';
            }
        }
        
        dijkstra();
    }
    
    private static void dijkstra() {        
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(0, 0, 0));
        
        visited = new boolean[n][m];
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.row == n - 1 && cur.col == m - 1) {
                System.out.println(cur.cost);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];
                
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                
                if (visited[nextRow][nextCol]) {
                    continue;
                }
                visited[nextRow][nextCol] = true;
                
                if (map[nextRow][nextCol] == 0) {
                    q.add(new Node(nextRow, nextCol, cur.cost));
                } else {
                    q.add(new Node(nextRow, nextCol, cur.cost + 1));
                }
            }
        }
    }
    
    static class Node {
        int row;
        int col;
        int cost;
        
        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
}