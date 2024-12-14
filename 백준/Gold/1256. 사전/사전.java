import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static double[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new double[n + 1][m + 1];

        if (comb(n, m) < k) {
            System.out.println(-1);
            return;
        }

        find(n, m, k);

        System.out.println(sb);
    }

    private static double comb(int n, int m) {
        if (dp[n][m] > 0) {
            return dp[n][m];
        }

        if (n == 0 || m == 0) {
            return dp[n][m] = 1;
        }

        return dp[n][m] = Math.min(comb(n - 1, m) + comb(n, m - 1), 1_000_000_001);
    }

    private static void find(int n, int m, double k) {
        if (n == 0) {
            for (int i = 0; i < m; i++) {
                sb.append("z");
            }

            return;
        }

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }

            return;
        }

        double comb = comb(n - 1, m);

        if (comb < k) {
            sb.append("z");
            find(n, m - 1, k - comb);
        } else {
            sb.append("a");
            find(n - 1, m, k);
        }
    }
}