import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = 1;
        int cnt = 1;

        int startIdx = 1;
        int endIdx = 1;

        while (endIdx != n) {
            if (sum == n) {
                cnt++;
                endIdx++;
                sum += endIdx;
            } else if (sum > n) {
                sum -= startIdx;
                startIdx++;
            } else {
                endIdx++;
                sum += endIdx;
            }
        }

        bw.write(cnt + "");
        bw.flush();
    }
}