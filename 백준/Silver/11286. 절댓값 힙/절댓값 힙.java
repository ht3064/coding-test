import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 > o2 ? 1 : -1;
            }
            return Math.abs(o1) - Math.abs(o2);
        });
        
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            
            if (num != 0) {
                q.add(num);
                continue;
            }
            
            if (!q.isEmpty()) {
                sb.append(q.poll()).append("\n");
                continue;
            }
            
            sb.append(0).append("\n");
        }
        
        System.out.println(sb);
    }
}