import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[101];
    static int[] dist = new int[101];
    static boolean[] visited = new boolean[101];
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 100; i++) {
            arr[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x] = y;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u] = v;
        }

        dijkstra();

        System.out.println(min);
    }

    private static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        q.add(new Node(1, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.idx == 100) {
                min = cur.cnt;
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int nextIdx = cur.idx + i;

                if (nextIdx > 100) {
                    continue;
                }
                
                if (dist[arr[nextIdx]] > dist[cur.idx] + 1) {
                    visited[arr[nextIdx]] = true;
                    dist[arr[nextIdx]] = dist[cur.idx] + 1;
                    q.add(new Node(arr[nextIdx], dist[arr[nextIdx]]));
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