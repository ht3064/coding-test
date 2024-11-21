import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static List<Node> virusPosition = new ArrayList<>();
    static int[] virusArr;
    static int[][] virusMap;
    static boolean[][] virusVisited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());        
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusPosition.add(new Node(i, j, 0));
                }
            }
        }
        
        virusArr = new int[m];
        dfs(0, 0);
        
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(min);
    }
    
    private static void dfs(int depth, int start) {
        if (depth == m) {
            bfs();
            return;
        }
        
        for (int i = start; i < virusPosition.size(); i++) {
            virusArr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
    
    private static void bfs() {
        virusVisited = new boolean[n][n];
        virusMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    virusMap[i][j] = 0;
                    continue;
                }
                
                virusMap[i][j] = map[i][j];
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            int row = virusPosition.get(virusArr[i]).row;
            int col = virusPosition.get(virusArr[i]).col;
            virusMap[row][col] = 2;
            virusVisited[row][col] = true;
            
            q.add(virusPosition.get(virusArr[i]));
        }
        
        int cnt = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            cnt = Math.max(cur.cnt, cnt);
            
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];
                
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }
            
                if (!virusVisited[nextRow][nextCol] && virusMap[nextRow][nextCol] == 0) {
                    virusVisited[nextRow][nextCol] = true;
                    virusMap[nextRow][nextCol] = 2;
                    q.add(new Node(nextRow, nextCol, cur.cnt + 1));
                }
            }
        }
        
        if (spreadVirus()) {
            min = Math.min(cnt, min);
        }
    }
    
    private static boolean spreadVirus() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (virusMap[i][j] == 0) {
                    return false;
                }
            }
        }
        
        return true;
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