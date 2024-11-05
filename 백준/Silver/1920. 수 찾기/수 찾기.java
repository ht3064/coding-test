import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        while (m-- > 0) {
            int targetNum = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = arr.length - 1;
            boolean flag = false;
            
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] > targetNum) {
                    end = mid - 1;
                } else if (arr[mid] < targetNum) {
                    start = mid + 1;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                sb.append("1\n");
                continue;
            }

            sb.append("0\n");
        }

        System.out.println(sb);
    }
}