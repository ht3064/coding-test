import java.util.*;

class Solution {
    static int time;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        
        int idx = 0;
        int curWeight = 0;
        while (idx < truck_weights.length) {
            curWeight -= q.poll();
            
            if (curWeight + truck_weights[idx] <= weight) {
                q.offer(truck_weights[idx]);
                curWeight += truck_weights[idx++];
            } else {
                q.offer(0);
            }
            
            time++;
        }
        
        return time + bridge_length;
    }
}