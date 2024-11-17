import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] arr;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }

        int answer = 0;
        while (max >= 0) {
            visited = new boolean[n][n];
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] <= max) {
                        arr[i][j] = 1;
                    }
                }
            }

            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] != 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            answer = Math.max(cnt, answer);
            max--;
        }

        System.out.println(answer);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + mrow[i];
            int nextCol = col + mcol[i];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                continue;
            }

            if (!visited[nextRow][nextCol] && arr[nextRow][nextCol] != 1) {
                dfs(nextRow, nextCol);
            }
        }
    }
}