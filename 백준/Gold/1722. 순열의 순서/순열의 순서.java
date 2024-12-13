import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long k;
    static long[] f;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        f = new long[n];
        f[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            f[i] = f[i + 1] * (n - i - 1);
        }

        arr = new int[n];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        if (Integer.parseInt(st.nextToken()) == 1) {
            k = Long.parseLong(st.nextToken());

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (f[i] < k) {
                        k -= f[i];
                    } else {
                        visited[j] = true;
                        arr[i] = j;
                        break;
                    }
                }
            }

            for (int i : arr) {
                sb.append(i).append(" ");
            }
        } else {
            long cnt = 1;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    cnt += f[i];
                }

                visited[arr[i]] = true;
            }

            sb.append(cnt);
        }

        System.out.println(sb);
    }
}