import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] arr;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] mcol = {1, -1, 0, 0, 1, -1, -1, 1};
    static int cnt;
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if (w == 0 && h == 0) {
                System.out.println(sb);
                return;
            }
            
            arr = new int[h][w];
            visited = new boolean[h][w];
      
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine()); 
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            
            sb.append(cnt).append("\n");
        }
    }
    
    private static void dfs(int row, int col) {
        visited[row][col] = true;
        
        for (int i = 0; i < 8; i++) {
            int nextRow = row + mrow[i];
            int nextCol = col + mcol[i];
            
            if (nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w) {
                continue;
            }
            
            if (!visited[nextRow][nextCol] && arr[nextRow][nextCol] == 1) {
                dfs(nextRow, nextCol);
            }
        }
    }
}