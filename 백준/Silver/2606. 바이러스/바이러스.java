import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static boolean[] visited;
    static List<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        visited = new boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        
        bfs(1);
        
        System.out.println(cnt);
    }
    
    private static void bfs(int idx) {
        visited[idx] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i : graph[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    cnt++;
                }
            }
        }
    }
}