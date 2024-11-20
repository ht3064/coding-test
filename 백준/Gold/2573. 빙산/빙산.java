import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        while (true) {
            visited = new boolean[n][m];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && arr[i][j] > 0) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            
            if (cnt >= 2) {
                System.out.println(answer);
                return;
            } else if (cnt == 0) {
                System.out.println(0);
                return;
            }
            
            bfs();
            answer++;
        }
    }
    
    private static void dfs(int row, int col) {
        visited[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int nextRow = row + mrow[i];
            int nextCol = col + mcol[i];
            
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                continue;
            }
            
            if (!visited[nextRow][nextCol] && arr[nextRow][nextCol] > 0) {
                dfs(nextRow, nextCol);
            }
        }
    }
    
    private static void bfs() {
        visited = new boolean[n][m];
        
        Queue<Node> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0) {
                    visited[i][j] = true;
                    q.add(new Node(i, j));
                }
            }
        }
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                
                if (!visited[nextRow][nextCol] && arr[nextRow][nextCol] == 0) {
                    if (arr[cur.row][cur.col] > 0) {
                        arr[cur.row][cur.col]--;
                    }
                }
            }
        }
    }
    
    static class Node {
        int row;
        int col;
        
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}