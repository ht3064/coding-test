import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        if (set.size() <= nums.length / 2) {
            return set.size();
        }
        
        return nums.length / 2;
    }
}