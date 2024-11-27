import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] graph;
    static int[] d;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        m = Integer.parseInt(st.nextToken());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            d[b]++;
        }

        topologySort();

        System.out.println(sb);
    }

    private static void topologySort() {
        if (result.size() == n) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] == 0 && !visited[i]) {
                visited[i] = true;
                result.add(i);
                sb.append(i).append(" ");
                for (int next : graph[i]) {
                    d[next]--;
                }
                topologySort();
            }
        }
    }
}