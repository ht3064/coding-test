import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int start;
    static int end;
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            graph[x].add(y);
            graph[y].add(x);
        }
        
        dfs(start, 0);
        
        if (answer == 0) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(answer);
    }
    
    private static void dfs(int node, int cnt) {
        if (node == end) {
            answer = cnt;
            return;
        }
            
        visited[node] = true;
        
        for (int n : graph[node]) {
            if (!visited[n]) {
                dfs(n, cnt + 1);
            }
        }
    }
}