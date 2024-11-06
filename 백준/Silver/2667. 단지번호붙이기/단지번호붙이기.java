import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int cnt;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] crr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = crr[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] != 0) {
                    cnt = 1;
                    list.add(bfs(i, j));
                }
            }
        }

        System.out.println(list.size());
        list.sort((o1, o2) -> o1 - o2);

        for (int i : list) {
            System.out.println(i);
        }
    }

    private static int bfs(int row, int col) {
        visited[row][col] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (canMove(nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    cnt++;
                    q.add(new Node(nextRow, nextCol));
                }
            }
        }

        return cnt;
    }

    private static boolean canMove(int row, int col) {
        return row >= 0 && row < arr.length && col >= 0 && col < arr[0].length
                && !visited[row][col] && arr[row][col] != 0;
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