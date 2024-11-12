import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static List<Integer>[] graph;
    static boolean[] visited;
    static List<Node> list = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            bfs(n, i);
            list.add(new Node(i, cnt));
        }

        list.sort((o1, o2) -> o2.cnt - o1.cnt);

        int max = list.get(0).cnt;
        for (Node node : list) {
            if (node.cnt == max) {
                result.add(node.idx);
            }
        }

        Collections.sort(result);
        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int n, int idx) {
        visited = new boolean[n + 1];
        cnt = 0;

        visited[idx] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(idx);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i : graph[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
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