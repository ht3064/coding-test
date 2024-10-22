import java.io.*;
import java.util.*;

public class Main {
    static char[] dna = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        for (char c : dna) {
            map.put(c, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < p; i++) {
            map.put(arr[i], map.get(arr[i]) - 1);
        }

        int cnt = 0;
        if (isValid(map)) {
            cnt++;
        }

        int start = 0;
        while (s > p) {
            map.put(arr[start], map.get(arr[start]) + 1);
            map.put(arr[p], map.get(arr[p]) - 1);
            if (isValid(map)) {
                cnt++;
            }
            start++;
            p++;
        }

        bw.write(cnt + "");
        bw.flush();
    }

    private static boolean isValid(Map<Character, Integer> map) {
        for (char c : map.keySet()) {
            if (map.get(c) > 0) {
                return false;
            }
        }

        return true;
    }
}