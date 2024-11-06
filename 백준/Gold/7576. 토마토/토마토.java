import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    visited[i][j] = true;
                    q.add(new Node(i, j, 0));
                }
            }
        }

        bfs();
    }

    private static void bfs() {
        int cnt = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            cnt = cur.cnt;

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (canMove(nextRow, nextCol)) {
                    if (arr[nextRow][nextCol] == 0) {
                        visited[nextRow][nextCol] = true;
                        arr[nextRow][nextCol] = 1;
                        q.add(new Node(nextRow, nextCol, cnt + 1));
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);
    }

    private static boolean canMove(int row, int col) {
        return row >= 0 && row < arr.length && col >= 0 && col < arr[0].length
                && !visited[row][col] && arr[row][col] != -1;
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