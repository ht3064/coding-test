import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int repNode = find(Integer.parseInt(st.nextToken()));

        boolean flag = true;
        for (int i = 1; i < m; i++) {
            if (repNode != find(Integer.parseInt(st.nextToken()))) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void union(int i, int j) {
        i = find(i);
        j = find(j);

        arr[j] = i;
    }

    private static int find(int num) {
        if (num == arr[num]) {
            return num;
        }

        return arr[num] = find(arr[num]);
    }
}