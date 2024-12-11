import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] arr;
    static List<Node> home = new ArrayList<>();
    static List<Node> chicken = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int depth, int at) {
        if (depth == m) {
            int sum = 0;
            for (Node h : home) {
                int min = Integer.MAX_VALUE;
                for (int i : arr) {
                    int d = Math.abs(h.row - chicken.get(i).row) + Math.abs(h.col - chicken.get(i).col);
                    min = Math.min(min, d);
                }

                sum += min;
            }
            result = Math.min(result, sum);

            return;
        }

        for (int i = at; i < chicken.size(); i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
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