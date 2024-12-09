import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[][] map;
    static int[][] dp;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (dp[row][col] == -1) {
            dp[row][col] = 0;

            for (int i = 0; i < 4; i++) {
                int nextRow = row + mrow[i];
                int nextCol = col + mcol[i];

                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                    continue;
                }

                if (map[nextRow][nextCol] < map[row][col]) {
                    dp[row][col] += dfs(nextRow, nextCol);
                }
            }
        }

        return dp[row][col];
    }
}