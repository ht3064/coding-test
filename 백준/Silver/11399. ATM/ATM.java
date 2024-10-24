import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        String[] arr = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            map.put(i + 1, Integer.parseInt(arr[i]));
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o1) - map.get(o2));
        
        int sum = 0;
        int totalSum = 0;
        for (int i : list) {
            sum += map.get(i);
            totalSum += sum;
        }
        
        System.out.println(totalSum);
    }
}