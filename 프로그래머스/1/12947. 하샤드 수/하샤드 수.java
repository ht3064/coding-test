class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int total = 0;
        
        String st = String.valueOf(x);
        char[] arr = st.toCharArray();
            
        for (char a : arr) {
            total += Integer.parseInt(String.valueOf(a));
        }
        
        if (x % total != 0) {
            answer = false;
        }
        
        return answer;
    }
}