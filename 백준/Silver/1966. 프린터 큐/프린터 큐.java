import java.io.*;
import java.util.*;

public class Main {
    static int t, n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                q.add(new Node(i, Integer.parseInt(st.nextToken())));
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Node cur = q.poll();

                boolean flag = true;
                for (Node node : q) {
                    if (node.value > cur.value) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) {
                    q.add(cur);
                } else {
                    cnt++;
                    if (cur.idx == m) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }

    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}