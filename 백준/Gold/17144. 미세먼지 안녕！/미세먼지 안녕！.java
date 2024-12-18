import java.io.*;
import java.util.*;

public class Main {
    static int r, c, t;
    static int[][] map;
    static Queue<Node> q = new LinkedList<>();
    static Node top, bottom;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        boolean flag = false;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    q.add(new Node(i, j, map[i][j]));
                } else if (map[i][j] == -1 && !flag) {
                    top = new Node(i, j, -1);
                    bottom = new Node(i + 1, j, -1);
                    flag = true;
                }
            }
        }

        while (true) {
            bfs();

            time++;
            if (time == t) {
                System.out.println(cntDust());
                return;
            }
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Node cur = q.poll();

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) {
                    continue;
                }

                if (map[nextRow][nextCol] != -1) {
                    map[nextRow][nextCol] += cur.value / 5;
                    cnt++;
                }
            }

            map[cur.row][cur.col] -= cur.value / 5 * cnt;
        }

        spreadTop();
        spreadBottom();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    q.add(new Node(i, j, map[i][j]));
                }
            }
        }
    }

    private static void spreadTop() {
        for (int i = top.row - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }

        for (int i = 0; i < c - 1; i++) {
            map[0][i] = map[0][i + 1];
        }

        for (int i = 0; i < top.row; i++) {
            map[i][c - 1] = map[i + 1][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            map[top.row][i] = map[top.row][i - 1];
        }

        map[top.row][1] = 0;
    }

    private static void spreadBottom() {
        for (int i = bottom.row + 1; i < r - 1; i++) {
            map[i][0] = map[i + 1][0];
        }

        for (int i = 0; i < c - 1; i++) {
            map[r - 1][i] = map[r - 1][i + 1];
        }

        for (int i = r - 1; i > bottom.row; i--) {
            map[i][c - 1] = map[i - 1][c - 1];
        }

        for (int i = c - 1; i > 1; i--) {
            map[bottom.row][i] = map[bottom.row][i - 1];
        }

        map[bottom.row][1] = 0;
    }

    private static int cntDust() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }

        return sum;
    }

    static class Node {
        int row;
        int col;
        int value;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}