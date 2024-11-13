import java.io.*;
import java.util.*;

public class Main {
    static int m, n, k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int cnt;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            for (int i = m - ey; i < m - sy; i++) {
                for (int j = sx; j < ex; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    cnt = 1;
                    list.add(bfs(i, j));
                }
            }
        }

        System.out.println(list.size());

        Collections.sort(list);
        for (int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
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

                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                    continue;
                }

                if (!visited[nextRow][nextCol] && arr[nextRow][nextCol] == 0) {
                    visited[nextRow][nextCol] = true;
                    cnt++;
                    q.add(new Node(nextRow, nextCol));
                }
            }
        }

        return cnt;
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