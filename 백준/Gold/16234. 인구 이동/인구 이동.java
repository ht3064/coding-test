import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() >= 2) {
                            move(sum);
                            flag = true;
                        }
                    }
                }
            }

            if (!flag) {
                System.out.println(cnt);
                break;
            }

            cnt++;
        }
    }

    private static int bfs(int row, int col) {
        list = new ArrayList<>();
        list.add(new Node(row, col));

        visited[row][col] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col));

        int sum = map[row][col];
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }

                if (!visited[nextRow][nextCol]) {
                    int next = Math.abs(map[nextRow][nextCol] - map[cur.row][cur.col]);
                    if (next >= l && next <= r) {
                        list.add(new Node(nextRow, nextCol));
                        sum += map[nextRow][nextCol];

                        visited[nextRow][nextCol] = true;
                        q.add(new Node(nextRow, nextCol));
                    }
                }
            }
        }

        return sum;
    }

    private static void move(int sum) {
        for (Node node : list) {
            map[node.row][node.col] = sum / list.size();
        }
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}