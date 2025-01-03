import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            bfs();

            if (checkCheese()) {
                System.out.println(time);
                break;
            }

            time++;
        }
    }

    private static boolean checkCheese() {
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] >= 3) {
                    map[i][j] = 0;
                    flag = false;
                } else if (map[i][j] == 2) {
                    map[i][j] = 1;
                    flag = false;
                }
            }
        }

        return flag;
    }

    private static void bfs() {
        visited = new boolean[n][m];
        visited[0][0] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                if (map[nextRow][nextCol] == 0) {
                    visited[nextRow][nextCol] = true;
                    q.add(new Node(nextRow, nextCol));
                } else {
                    map[nextRow][nextCol] += 1;
                }
            }
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