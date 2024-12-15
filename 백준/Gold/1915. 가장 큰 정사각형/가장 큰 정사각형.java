import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] dp;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] crr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                dp[i][j] = crr[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i >= 1 && j >= 1 && dp[i][j] != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max * max);
    }
}