import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static int[][] arr;
    static boolean[][] visited;
    static boolean[] alphabet;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        visited = new boolean[r][c];
        alphabet = new boolean[26];
        for (int i = 0; i < r; i++) {
            char[] crr = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = crr[j] - 'A';
            }
        }

        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int row, int col, int cnt) {
        visited[row][col] = true;
        alphabet[arr[row][col]] = true;

        max = Math.max(cnt, max);

        for (int i = 0; i < 4; i++) {
            int nextRow = row + mrow[i];
            int nextCol = col + mcol[i];

            if (nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c || alphabet[arr[nextRow][nextCol]]) {
                continue;
            }

            if (!visited[nextRow][nextCol]) {
                dfs(nextRow, nextCol, cnt + 1);
                visited[nextRow][nextCol] = false;
                alphabet[arr[nextRow][nextCol]] = false;
            }
        }
    }
}