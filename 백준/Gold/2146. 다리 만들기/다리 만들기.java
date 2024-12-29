import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int area = 1;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j);
                    area++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(min);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        map[row][col] = area;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + mrow[i];
            int nextCol = col + mcol[i];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                continue;
            }

            if (visited[nextRow][nextCol] || map[nextRow][nextCol] != 1) {
                continue;
            }

            dfs(nextRow, nextCol);
        }
    }

    private static void bfs(int row, int col) {
        visited = new boolean[n][n];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col, 0));
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (map[cur.row][cur.col] != 0 && map[cur.row][cur.col] != map[row][col]) {
                min = Math.min(min, cur.cnt - 1);
            }

            if (cur.cnt > min) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }

                if (visited[nextRow][nextCol] || map[nextRow][nextCol] == map[row][col]) {
                    continue;
                }

                visited[nextRow][nextCol] = true;
                q.add(new Node(nextRow, nextCol, cur.cnt + 1));
            }
        }
    }

    static class Node {
        int row;
        int col;
        int cnt;

        public Node(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
}