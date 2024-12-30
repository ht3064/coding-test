import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        Set<Integer> set = new HashSet<>(); 
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        
        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = k + 1;
        }
        
        for (int i : set) {
            for (int j = 1; j <= k; j++) {
                if (j - i >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - i] + 1);
                }
            }
        }
        
        if (dp[k] == k + 1) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(dp[k]);
    }
}