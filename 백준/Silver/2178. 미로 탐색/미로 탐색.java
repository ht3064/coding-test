import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int[][] arr;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            char[] crr = br.readLine().toCharArray();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = crr[j] - '0';
            }
        }

        bfs(0, 0);

        System.out.println(answer);
    }

    private static void bfs(int row, int col) {
        visited[row][col] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col, 1));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.row == arr.length - 1 && cur.col == arr[0].length - 1) {
                answer = cur.cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (canMove(nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    q.add(new Node(nextRow, nextCol, cur.cnt + 1));
                }
            }
        }
    }

    private static boolean canMove(int row, int col) {
        return row >= 0 && row < arr.length && col >= 0 && col < arr[0].length
                && !visited[row][col] && arr[row][col] != 0;
    }
}

class Node {
    int row;
    int col;
    int cnt;

    public Node(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}