import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            char[] crr = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = crr[j] - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            left(num - 1, -d);
            right(num + 1, -d);
            turn(num, d);
        }

        int sum = 0;
        int score = 1;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                sum += score;
            }
            score *= 2;
        }

        System.out.println(sum);
    }

    private static void left(int num, int d) {
        if (num < 0) {
            return;
        }

        if (arr[num][2] == arr[num + 1][6]) {
            return;
        }

        left(num - 1, -d);
        turn(num, d);
    }

    private static void right(int num, int d) {
        if (num > 3) {
            return;
        }

        if (arr[num][6] == arr[num - 1][2]) {
            return;
        }

        right(num + 1, -d);
        turn(num, d);
    }

    private static void turn(int num, int d) {
        if (d == 1) {
            int temp = arr[num][7];
            for (int i = 7; i >= 1; i--) {
                arr[num][i] = arr[num][i - 1];
            }
            arr[num][0] = temp;
        } else {
            int temp = arr[num][0];
            for (int i = 0; i < 7; i++) {
                arr[num][i] = arr[num][i + 1];
            }
            arr[num][7] = temp;
        }
    }
}