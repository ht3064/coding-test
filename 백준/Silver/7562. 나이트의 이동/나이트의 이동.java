import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int startRow, startCol;
    static int endRow, endCol;
    static int[] mrow = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] mcol = {2, 1, -1, -2, -2, -1, 1, 2};
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            startRow = Integer.parseInt(st.nextToken());
            startCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endRow = Integer.parseInt(st.nextToken());
            endCol = Integer.parseInt(st.nextToken());

            bfs();

            System.out.println(min);
        }
    }

    private static void bfs() {
        visited[startRow][startCol] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startRow, startCol, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.row == endRow && cur.col == endCol) {
                min = cur.cnt;
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }

                if (!visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    q.add(new Node(nextRow, nextCol, cur.cnt + 1));
                }
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