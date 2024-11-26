class Solution {
    static int[] op;
    static int result;
    
    public int solution(int[] numbers, int target) {
        op = new int[numbers.length];
        
        dfs(0, numbers, target);
        
        return result;
    }
    
    private void dfs(int depth, int[] numbers, int target) {
        if (depth == numbers.length) {
            calculate(numbers, target);
            return;
        }
        
        for (int i = 0; i <= 1; i++) {
            op[depth] = i;
            dfs(depth + 1, numbers, target);
        } 
    }
    
    private void calculate(int[] numbers, int target) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (op[i] == 0) {
                sum += numbers[i];
            } else {
                sum -= numbers[i];
            }
        }
        
        if (sum == target) {
            result++;
        }
    }
}