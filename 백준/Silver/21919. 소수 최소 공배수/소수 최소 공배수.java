import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (isPrime(num)) {
                list.add((long) num);
            }
        }
        
        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }
        
        while (list.size() > 1) {
            list.add(lcm(list.get(0), list.get(1)));
            list.remove(0);
            list.remove(0);
        }
        
        System.out.println(list.get(0));
    }
    
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private static long gcd(long n, long m) {
        if (n % m == 0) {
            return m;
        }
        
        return gcd(m, n % m);
    }
    
    private static long lcm(long n, long m) {
        return n * m / gcd(n, m);
    }
}