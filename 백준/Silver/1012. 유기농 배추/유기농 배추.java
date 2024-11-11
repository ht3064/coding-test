import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[m][n];
            visited = new boolean[m][n];

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                arr[row][col] = 1;
            }

            cnt = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] != 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void bfs(int row, int col) {
        visited[row][col] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= arr.length || nextCol < 0 || nextCol >= arr[0].length) {
                    continue;
                }

                if (!visited[nextRow][nextCol] && arr[nextRow][nextCol] != 0) {
                    visited[nextRow][nextCol] = true;
                    q.add(new Node(nextRow, nextCol));
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