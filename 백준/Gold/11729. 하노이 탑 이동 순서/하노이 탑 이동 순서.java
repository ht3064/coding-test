import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        hanoi(n, 1, 2, 3);
        
        System.out.println(cnt);
        System.out.println(sb);
    }
    
    private static void hanoi(int n, int s, int m, int e) {
        if (n == 0) {
            return;
        }
        
        hanoi(n - 1, s, e, m);
        cnt++;
        sb.append(s).append(" ").append(e).append("\n");
        hanoi(n - 1, m, s, e);
    }
}