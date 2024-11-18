import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (i < j) {
                    set.add(s.substring(i, j));
                }
            }
        }
        
        System.out.println(set.size());
    }
}