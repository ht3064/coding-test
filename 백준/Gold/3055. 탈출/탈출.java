import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Node> q = new LinkedList<>();
    static Node start, end;
    static int[] mrow = {0, 0, 1, -1};
    static int[] mcol = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            char[] crr = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = crr[j];
                if (map[i][j] == '*') {
                    visited[i][j] = true;
                    q.add(new Node(i, j, 0));
                } else if (map[i][j] == 'S') {
                    start = new Node(i, j, 0);
                } else if (map[i][j] == 'D') {
                    end = new Node(i, j, 0);
                }
            }
        }

        bfs();
    }

    private static void bfs() {
        visited[start.row][start.col] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.row == end.row && cur.col == end.col) {
                System.out.println(cur.cnt);
                return;
            }

            if (map[cur.row][cur.col] == '*') {
                for (int i = 0; i < 4; i++) {
                    int nextRow = cur.row + mrow[i];
                    int nextCol = cur.col + mcol[i];

                    if (nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) {
                        continue;
                    }

                    if (map[nextRow][nextCol] == 'X' || map[nextRow][nextCol] == 'D') {
                        continue;
                    }

                    if (!visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        map[nextRow][nextCol] = '*';
                        q.add(new Node(nextRow, nextCol, cur.cnt));
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int nextRow = cur.row + mrow[i];
                    int nextCol = cur.col + mcol[i];

                    if (nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) {
                        continue;
                    }

                    if (map[nextRow][nextCol] == 'X' || map[nextRow][nextCol] == '*') {
                        continue;
                    }

                    if (!visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        q.add(new Node(nextRow, nextCol, cur.cnt + 1));
                    }
                }
            }
        }

        System.out.println("KAKTUS");
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