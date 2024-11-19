import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] virusArr;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int max;
    
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
        
        dfs(0);
        
        System.out.println(max);
    }
    
    private static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wallCnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    
    private static void bfs() {
        virusArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            virusArr[i] = arr[i].clone();
        }
        
        Queue<Node> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusArr[i][j] == 2) {
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
                
                if (virusArr[nextRow][nextCol] == 0) {
                    virusArr[nextRow][nextCol] = 2;
                    q.add(new Node(nextRow, nextCol));
                }
            }
        }
        
        max = Math.max(max, cntSafeZone());
    }
    
    private static int cntSafeZone() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusArr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        
        return cnt;
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