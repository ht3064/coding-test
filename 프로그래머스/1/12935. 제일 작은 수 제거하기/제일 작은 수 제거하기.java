class Solution {
    public int[] solution(int[] arr) {
        if (arr.length - 1 == 0) {
            return new int[]{-1};
        }
                
        int min = Integer.MAX_VALUE;
        
        for (int a : arr) {
            min = Math.min(a, min);
        }
        
        int[] answer = new int[arr.length - 1];

        int i = 0;
        
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != min) { 
                answer[i] = arr[j];
                i++;
            }
        }
        
        return answer;        
    }
}