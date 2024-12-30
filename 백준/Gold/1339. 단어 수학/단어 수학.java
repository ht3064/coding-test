import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                alphabet[s.charAt(j) - 'A'] += (int) Math.pow(10, s.length() - j - 1);
            }
        }

        Arrays.sort(alphabet);

        int sum = 0;
        int num = 9;
        for (int i = 25; i >= 0; i--) {
            if (alphabet[i] == 0) {
                break;
            }

            sum += alphabet[i] * num;
            num--;
        }

        System.out.println(sum);
    }
}