import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[x] = 0;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, 1));
        }

        dijkstra(x);

        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(list);
        for (int i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int idx) {
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(idx, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.idx]) {
                continue;
            }
            visited[cur.idx] = true;

            for (Node next : graph[cur.idx]) {
                if (dist[next.idx] > dist[cur.idx] + next.cost) {
                    dist[next.idx] = dist[cur.idx] + next.cost;
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