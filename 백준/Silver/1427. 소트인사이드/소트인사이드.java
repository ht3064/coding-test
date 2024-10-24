import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] c = br.readLine().toCharArray();

        int[] arr = new int[c.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = c[i] - '0';
        }

        for (int i = 0; i < arr.length; i++) {
            int idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idx] < arr[j]) {
                    idx = j;
                }
            }

            if (arr[i] < arr[idx]) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }

        for (int i : arr) {
            sb.append(i);
        }

        System.out.println(sb);
    }
}