import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                System.out.println(i);
                return;
            }

            union(a, b);
        }

        System.out.println(0);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        parent[b] = a;
    }

    private static int find(int num) {
        if (num == parent[num]) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }
}