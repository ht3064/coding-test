import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static List<Node> wallPosition = new ArrayList<>();
    static int[] wallArr;
    static boolean[][] virusVisited;
    static int[][] virusMap;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    wallPosition.add(new Node(i, j));
                }
            }
        }

        wallArr = new int[3];
        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int depth, int start) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = start; i < wallPosition.size(); i++) {
            wallArr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();

        virusVisited = new boolean[n][m];
        virusMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virusMap[i][j] = map[i][j];
                if (virusMap[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        for (int i = 0; i < wallArr.length; i++) {
            int row = wallPosition.get(wallArr[i]).row;
            int col = wallPosition.get(wallArr[i]).col;
            virusVisited[row][col] = true;
            virusMap[row][col] = 1;
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                    continue;
                }

                if (!virusVisited[nextRow][nextCol] && virusMap[nextRow][nextCol] == 0) {
                    virusVisited[nextRow][nextCol] = true;
                    virusMap[nextRow][nextCol] = 2;
                    q.add(new Node(nextRow, nextCol));
                }
            }
        }

        max = Math.max(cntSafeZone(), max);
    }

    private static int cntSafeZone() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == 0) {
                    cnt++;
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