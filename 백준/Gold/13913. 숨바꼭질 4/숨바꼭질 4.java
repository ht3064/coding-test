import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] dist = new int[100_001];
    static boolean[] visited = new boolean[100_001];
    static int[] parent = new int[100_001];
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 100_000; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[n] = 0;

        bfs();
        System.out.println(dist[k]);

        searchPath();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (visited[cur.idx]) {
                continue;
            }
            visited[cur.idx] = true;

            if (cur.idx - 1 >= 0 && dist[cur.idx - 1] > dist[cur.idx] + 1) {
                dist[cur.idx - 1] = dist[cur.idx] + 1;
                parent[cur.idx - 1] = cur.idx;
                q.add(new Node(cur.idx - 1, dist[cur.idx - 1]));
            }

            if (cur.idx + 1 <= 100_000 && dist[cur.idx + 1] > dist[cur.idx] + 1) {
                dist[cur.idx + 1] = dist[cur.idx] + 1;
                parent[cur.idx + 1] = cur.idx;
                q.add(new Node(cur.idx + 1, dist[cur.idx + 1]));
            }

            if (cur.idx * 2 <= 100_000 && dist[cur.idx * 2] > dist[cur.idx] + 1) {
                dist[cur.idx * 2] = dist[cur.idx] + 1;
                parent[cur.idx * 2] = cur.idx;
                q.add(new Node(cur.idx * 2, dist[cur.idx * 2]));
            }
        }
    }

    private static void searchPath() {
        int cur = k;

        while (cur != n) {
            stack.push(cur);
            cur = parent[cur];
        }

        stack.push(cur);
    }

    static class Node {
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}