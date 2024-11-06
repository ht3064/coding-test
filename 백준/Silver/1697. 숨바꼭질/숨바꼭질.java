import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);
    }

    private static void bfs(int row, int k) {
        visited[row] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.row == k) {
                System.out.println(cur.cnt);
                return;
            }

            if (cur.row + 1 <= 100000 && !visited[cur.row + 1]) {
                visited[cur.row + 1] = true;
                q.add(new Node(cur.row + 1, cur.cnt + 1));
            }

            if (cur.row - 1 >= 0 && !visited[cur.row - 1]) {
                visited[cur.row - 1] = true;
                q.add(new Node(cur.row - 1, cur.cnt + 1));
            }

            if (cur.row * 2 <= 100000 && !visited[cur.row * 2]) {
                visited[cur.row * 2] = true;
                q.add(new Node(cur.row * 2, cur.cnt + 1));
            }
        }
    }

    static class Node {
        int row;
        int cnt;

        public Node(int row, int cnt) {
            this.row = row;
            this.cnt = cnt;
        }
    }
}