import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int node = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        for (int i = 1; i <= n; i++) {
            list[i].sort((o1, o2) -> o1 - o2);
        }

        sb.append(node).append(" ");
        dfs(node);

        visited = new boolean[n + 1];
        sb.append("\n").append(node).append(" ");
        bfs(node);

        System.out.println(sb);
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int i :list[node]) {
            if (!visited[i]) {
                sb.append(i).append(" ");
                dfs(i);
            }
        }
    }

    private static void bfs(int node) {
        visited[node] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i : list[cur]) {
                if(!visited[i]) {
                    visited[i] = true;
                    sb.append(i).append(" ");
                    q.add(i);
                }
            }
        }
    }
}