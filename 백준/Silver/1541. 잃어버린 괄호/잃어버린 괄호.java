import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] arr = s.split("-");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (String st : arr[i].split("\\+")) {
                if (i == 0) {
                    sum += Integer.parseInt(st);
                } else {
                    sum -= Integer.parseInt(st);
                }
            }
        }

        System.out.println(sum);
    }
}