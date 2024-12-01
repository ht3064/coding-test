import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[5][5];
    static int[] arr = new int[7];
    static int[][] sevenMap;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            char[] crr = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                map[i][j] = crr[j];
            }
        }

        dfs(0, 0, 0);

        System.out.println(cnt);
    }

    private static void dfs(int depth, int at, int numY) {
        if (numY >= 4) {
            return;
        }

        if (depth == 7) {
            bfs();
            return;
        }

        for (int i = at; i < 25; i++) {
            arr[depth] = i;
            if (map[i / 5][i % 5] == 'Y') {
                dfs(depth + 1, i + 1, numY + 1);
            } else {
                dfs(depth + 1, i + 1, numY);
            }
        }
    }

    private static void bfs() {
        visited = new boolean[5][5];
        sevenMap = new int[5][5];
        for (int i = 1; i < arr.length; i++) {
            sevenMap[arr[i] / 5][arr[i] % 5] = 1;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(arr[0] / 5, arr[0] % 5));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (visited[cur.row][cur.col]) {
                continue;
            }
            visited[cur.row][cur.col] = true;

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= 5 || nextCol < 0 || nextCol >= 5) {
                    continue;
                }

                if (sevenMap[nextRow][nextCol] == 1) {
                    sevenMap[nextRow][nextCol] = 0;
                    q.add(new Node(nextRow, nextCol));
                }
            }
        }

        if (isValid()) {
            cnt++;
        }
    }

    private static boolean isValid() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (sevenMap[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
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