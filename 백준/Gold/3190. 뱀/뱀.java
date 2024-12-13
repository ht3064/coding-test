import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static HashMap<Integer, String> hashMap = new HashMap<>();
    static int[] mrow = {-1, 0, 1, 0};
    static int[] mcol = {0, -1, 0, 1};
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            map[row][col] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        while (l-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            hashMap.put(x, c);
        }

        move();

        System.out.println(time);
    }

    private static void move() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 3));
        map[0][0] = 2;
        
        int row = 0;
        int col = 0;
        int d = 3;

        while (!q.isEmpty()) {
            time++;

            int nextRow = row + mrow[d];
            int nextCol = col + mcol[d];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                return;
            }

            if (map[nextRow][nextCol] == 2) {
                return;
            }

            if (map[nextRow][nextCol] == 0) {
                Node node = q.poll();
                map[node.row][node.col] = 0;
            }

            if (hashMap.containsKey(time)) {
                if (hashMap.get(time).equals("L")) {
                    d += 1;
                    if (d > 3) {
                        d = 0;
                    }
                } else {
                    d -= 1;
                    if (d < 0) {
                        d = 3;
                    }
                }
            }

            map[nextRow][nextCol] = 2;
            row = nextRow;
            col = nextCol;

            q.add(new Node(row, col, d));
        }
    }

    static class Node {
        int row;
        int col;
        int d;

        public Node(int row, int col, int d) {
            this.row = row;
            this.col = col;
            this.d = d;
        }
    }
}