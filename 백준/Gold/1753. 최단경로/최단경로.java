import java.io.*;
import java.util.*;

public class Main {
    static int[] dist;
    static boolean[] visited;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1];
        visited = new boolean[V + 1];

        int K = Integer.parseInt(br.readLine());
        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }

    private static void dijkstra(int idx) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(idx, 0));

        while (!pq.isEmpty()) {
            int curIdx = pq.poll().idx;

            if (visited[curIdx]) {
                continue;
            }
            visited[curIdx] = true;

            for (Node next : graph[curIdx]) {
                if (dist[curIdx] + next.cost < dist[next.idx]) {
                    dist[next.idx] = dist[curIdx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
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