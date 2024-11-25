import java.io.*;
import java.util.*;

public class Main {
    static int n, e;
    static List<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        e = Integer.parseInt(st.nextToken());
        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int sol1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int sol2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        if (sol1 >= INF && sol2 >= INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(sol1, sol2));
    }

    private static int dijkstra(int start, int end) {
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (visited[cur.idx]) {
                continue;
            }
            visited[cur.idx] = true;

            for (Node next : graph[cur.idx]) {
                if (dist[next.idx] > dist[cur.idx] + next.cost) {
                    dist[next.idx] = dist[cur.idx] + next.cost;
                    q.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        return dist[end];
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}