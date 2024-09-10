import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String st = br.readLine();
        br.close();
        
        int n = Integer.parseInt(st.split(" ")[0]);
        int m = Integer.parseInt(st.split(" ")[1]);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
}