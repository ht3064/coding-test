import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int cnt;
    static int time;

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
            }
        }

        while (true) {
            visited = new boolean[n][m];
            cnt = 0;
            dfs(0, 0);

            time++;
            if (checkCheese()) {
                System.out.println(time);
                System.out.println(cnt);
                return;
            }
        }
    }

    private static void dfs(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nextRow = row + mrow[i];
            int nextCol = col + mcol[i];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                continue;
            }

            if (visited[nextRow][nextCol]) {
                continue;
            }

            visited[nextRow][nextCol] = true;
            if (map[nextRow][nextCol] == 1) {
                map[nextRow][nextCol] = -1;
                cnt++;
            } else {
                dfs(nextRow, nextCol);
            }
        }
    }

    private static boolean checkCheese() {
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                } else if (map[i][j] == 1) {
                    flag = false;
                }
            }
        }

        return flag;
    }
}