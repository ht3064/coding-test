import java.io.*;
import java.util.*;

public class Main {
    static int[][][] arr;
    static boolean[][][] visited;
    static int[] mpage = {1, -1, 0, 0, 0 ,0};
    static int[] mrow = {0, 0, 0, 0, 1, -1};
    static int[] mcol = {0, 0, 1, -1, 0, 0};
    static Queue<Node> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        arr = new int[h][n][m];
        visited = new boolean[h][n][m];
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        q.add(new Node(i, j, k, 0));
                    }
                }
            }
        }
        
        bfs();
    }
    
    private static void bfs() {
        int cnt = 0;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            cnt = cur.cnt;
            
            for (int i = 0; i < 6; i++) {
                int nextPage = cur.page + mpage[i];
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];
                
                if (canMove(nextPage, nextRow, nextCol)) {
                    if (arr[nextPage][nextRow][nextCol] == 0) {
                        arr[nextPage][nextRow][nextCol] = 1;
                        q.add(new Node(nextPage, nextRow, nextCol, cnt + 1));
                    }
                }
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr[0][0].length; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        
        System.out.println(cnt);
    }
    
    private static boolean canMove(int page, int row, int col) {
        return page >= 0 && page < arr.length && row >= 0 && row < arr[0].length
            && col >= 0 && col < arr[0][0].length 
            && !visited[page][row][col] && arr[page][row][col] != -1;
    }
}

class Node {
    int page;
    int row;
    int col;
    int cnt;
    
    public Node(int page, int row, int col, int cnt) {
        this.page = page;
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}