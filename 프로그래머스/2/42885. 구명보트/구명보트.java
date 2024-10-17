import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int ltIdx = 0;
        int rtIdx = people.length - 1;
        
        while (rtIdx - ltIdx > -1) {
            if (people[rtIdx] + people[ltIdx] <= limit) {
                rtIdx--;
                ltIdx++;
            } else {
               rtIdx--; 
            }
            
            answer++;
        }
        
        return answer;
    }
}