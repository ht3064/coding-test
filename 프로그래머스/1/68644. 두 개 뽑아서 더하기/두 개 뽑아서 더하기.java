import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> treeSet = new TreeSet<>();
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                treeSet.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[treeSet.size()];
        int index = 0;
        
        for (int a : treeSet) {
            answer[index++] = a;
        }
        
        return answer;
    }
}