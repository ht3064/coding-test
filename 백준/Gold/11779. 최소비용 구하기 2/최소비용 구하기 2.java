import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Node>[] graph;
    static int[] dist;
    static int[] parent;
    static int a, b;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        dist = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, v));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(dist[b]);

        searchPath();
        System.out.println(stack.size());

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        boolean[] visited = new boolean[n + 1];
        dist[a] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(a, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (visited[cur.idx]) {
                continue;
            }
            visited[cur.idx] = true;

            for (Node next : graph[cur.idx]) {
                if (dist[next.idx] > dist[cur.idx] + next.cost) {
                    dist[next.idx] = dist[cur.idx] + next.cost;
                    parent[next.idx] = cur.idx;
                    q.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }

    private static void searchPath() {
        int cur = b;

        while (cur != a) {
            stack.push(cur);
            cur = parent[cur];
        }

        stack.push(cur);
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