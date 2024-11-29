import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int emptySpace;
    static List<Node> virusList = new ArrayList<>();
    static int[] virusArr;
    static boolean[][] virusVisited;
    static int[][] virusMap;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptySpace++;
                } else if (map[i][j] == 2) {
                    virusList.add(new Node(i, j, 0));
                }
            }
        }

        virusArr = new int[m];

        dfs(0, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(min);
    }

    private static void dfs(int depth, int at) {
        if (depth == m) {
            bfs();
            return;
        }

        for (int i = at; i < virusList.size(); i++) {
            virusArr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    private static void bfs() {
        virusVisited = new boolean[n][n];
        virusMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            virusMap[i] = map[i].clone();
        }

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            int row = virusList.get(virusArr[i]).row;
            int col = virusList.get(virusArr[i]).col;
            virusVisited[row][col] = true;
            virusMap[row][col] = 0;
            q.add(virusList.get(virusArr[i]));
        }

        int cnt = 0;
        int zeroCnt = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }

                if (virusVisited[nextRow][nextCol] || virusMap[nextRow][nextCol] == 1) {
                    continue;
                }

                virusVisited[nextRow][nextCol] = true;
                if (virusMap[nextRow][nextCol] == 0) {
                    zeroCnt++;
                    cnt = Math.max(cnt, cur.cnt + 1);
                }
                q.add(new Node(nextRow, nextCol, cur.cnt + 1));
            }
        }

        if (emptySpace == zeroCnt) {
            min = Math.min(min, cnt);
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