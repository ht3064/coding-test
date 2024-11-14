import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (n-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            sum += first + second;
            pq.add(first + second);
        }

        System.out.println(sum);
    }
}