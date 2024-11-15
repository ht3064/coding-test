import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static List<Integer>[] graph;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            visited = new int[V + 1];
            graph = new List[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            int E = Integer.parseInt(st.nextToken());
            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            flag = true;
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    dfs(i, 1);
                }
                if (!flag) {
                    break;
                }
            }

            if (flag) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int node, int color) {
        visited[node] = color;

        for (int n : graph[node]) {
            if (visited[n] == 0) {
                dfs(n, color * -1);
            } else if (visited[node] == visited[n]) {
                flag = false;
                return;
            }
        }
    }
}