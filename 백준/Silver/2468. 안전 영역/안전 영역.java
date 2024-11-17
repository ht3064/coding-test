import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i][j], max);
            }
        }

        int answer = 0;
        for (int h = 0; h <= max; h++) {
            visited = new boolean[n][n];
            cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] > h) {
                        dfs(i, j, h);
                        cnt++;
                    }
                }
            }

            answer = Math.max(cnt, answer);
        }

        System.out.println(answer);
    }

    private static void dfs(int row, int col, int h) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + mrow[i];
            int nextCol = col + mcol[i];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                continue;
            }

            if (!visited[nextRow][nextCol] && arr[nextRow][nextCol] > h) {
                dfs(nextRow, nextCol, h);
            }
        }
    }
}