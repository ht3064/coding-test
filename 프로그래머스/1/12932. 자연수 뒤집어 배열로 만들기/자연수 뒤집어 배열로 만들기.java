class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        
        String[] arr = sb.append(n).reverse().toString().split("");
        
        int[] answer = new int[arr.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }
        
        return answer;
    }
}