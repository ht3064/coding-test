import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> heap = new PriorityQueue<>();
        
        for (int i : scoville) {
            heap.add(i);
        }
        
        int cnt = 0;
        while (true) {
            int first = heap.poll();
            int second = 0;
            if (heap.size() >= 1) {
                second = heap.poll();
            }
            
            if (first >= K) {
                break;
            } else if (heap.size() == 0 && first + second * 2 < K) {
                return -1;
            }
            
            heap.add(first + second * 2);
            cnt++;
        }
        
        return cnt;
    }
}