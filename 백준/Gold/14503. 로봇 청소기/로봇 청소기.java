import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int r, c, d;
    static int[][] map;
    static boolean[][] visited;
    static int[] mrow = {-1, 0, 1, 0};
    static int[] mcol = {0, 1, 0, -1};
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(cnt);
    }

    private static void bfs() {
        visited[r][c] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, 1, d));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            int dir = cur.dir;

            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                dir -= 1;
                if (dir < 0) {
                    dir = 3;
                }

                int nextRow = cur.row + mrow[dir];
                int nextCol = cur.col + mcol[dir];

                if (map[nextRow][nextCol] == 1) {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                flag = true;
                visited[nextRow][nextCol] = true;

                q.add(new Node(nextRow, nextCol, cur.cnt + 1, dir));
                break;
            }

            if (!flag) {
                int nextRow = cur.row - mrow[dir];
                int nextCol = cur.col - mcol[dir];

                if (map[nextRow][nextCol] == 1) {
                    cnt = cur.cnt;
                    break;
                }

                q.add(new Node(nextRow, nextCol, cur.cnt, dir));
            }
        }
    }

    static class Node {
        int row;
        int col;
        int cnt;
        int dir;

        public Node(int row, int col, int cnt, int dir) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
}