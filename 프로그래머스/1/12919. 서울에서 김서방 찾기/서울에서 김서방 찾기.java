class Solution {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder();
        
        int x = 0;
        
        for (String str : seoul) {
            if (str.equals("Kim")) {
                break;
            }
            x++;
        }
        
        return sb.append("김서방은 ").append(String.valueOf(x)).append("에 있다").toString();
    }
}