import java.io.*;
import java.util.*;

public class Main {
    static int l, c;
    static String[] arr;
    static String[] alphabet;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new String[l];
        alphabet = br.readLine().split(" ");

        Arrays.sort(alphabet);

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int depth, int at) {
        if (depth == l) {
            StringBuilder sb = new StringBuilder();
            int a = 0;
            int b = 0;
            for (String i : arr) {
                if (i.equals("a") || i.equals("e") || i.equals("i") || i.equals("o") || i.equals("u")) {
                    a++;
                } else {
                    b++;
                }
                sb.append(i);
            }

            if (a < 1 || b < 2) {
                return;
            }
            result.append(sb).append("\n");

            return;
        }

        for (int i = at; i < alphabet.length; i++) {
            arr[depth] = alphabet[i];
            dfs(depth + 1, i + 1);
        }
    }
}