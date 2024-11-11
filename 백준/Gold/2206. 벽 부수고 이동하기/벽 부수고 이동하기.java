import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            char[] crr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = crr[j] - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int row, int col) {
        visited[row][col][0] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col, 1, false));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.row == arr.length - 1 && cur.col == arr[0].length - 1) {
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= arr.length || nextCol < 0 || nextCol >= arr[0].length) {
                    continue;
                }

                if (cur.destroyed) {
                    if (arr[nextRow][nextCol] == 0 && !visited[nextRow][nextCol][0]) {
                        visited[nextRow][nextCol][0] = true;
                        q.add(new Node(nextRow, nextCol, cur.cnt + 1, true));
                    }
                } else {
                    if (arr[nextRow][nextCol] == 0 && !visited[nextRow][nextCol][1]) {
                        visited[nextRow][nextCol][1] = true;
                        q.add(new Node(nextRow, nextCol, cur.cnt + 1, false));
                    } else if (arr[nextRow][nextCol] == 1 && !visited[nextRow][nextCol][0]) {
                        visited[nextRow][nextCol][0] = true;
                        q.add(new Node(nextRow, nextCol, cur.cnt + 1, true));
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int row;
        int col;
        int cnt;
        boolean destroyed;

        public Node(int row, int col, int cnt, boolean destroyed) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }
}