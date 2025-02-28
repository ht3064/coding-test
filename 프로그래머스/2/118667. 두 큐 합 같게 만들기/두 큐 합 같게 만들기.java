import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long total = 0;
        long q1Sum = 0;
        int cnt = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            total += queue1[i] + queue2[i];
            q1Sum += queue1[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        if (total % 2 != 0) {
            return -1;
        }
        
        long target = total / 2;
        while (true) {
            if (cnt >= (queue1.length + queue2.length) * 2) {
                return -1;
            }
            
            if (target == q1Sum) {
                break;
            } else if (target > q1Sum) {
                q1Sum += q2.peek();
                q1.add(q2.poll());
            } else {
                q1Sum -= q1.peek();
                q2.add(q1.poll());
            }
            cnt++;
        }
        
        return cnt;
    }
}