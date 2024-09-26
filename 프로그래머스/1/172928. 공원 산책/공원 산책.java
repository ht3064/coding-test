class Solution {
    public int[] solution(String[] park, String[] routes) {
        int sx = 0;
        int sy = 0;
        
        char[][] arr = new char[park.length][park[0].length()];
        
        for (int i = 0; i < park.length; i++) {
            arr[i] = park[i].toCharArray();
                
            if (park[i].contains("S")) {
                sx = park[i].indexOf("S");
                sy = i;
            }
        }
        
        for (String route : routes) {
            String op = route.split(" ")[0];
            int n = Integer.parseInt(route.split(" ")[1]);
            
            int dx = sx;
            int dy = sy;
            
            for (int i = 0; i < n; i++) {
                if (op.equals("E")) {
                    dx++;
                } else if (op.equals("W")) {
                    dx--;
                } else if (op.equals("S")) {
                    dy++;
                } else if (op.equals("N")) {
                    dy--;
                }
                
                if (dx >= 0 && dy >= 0 && dx < arr[0].length && dy < arr.length) {
                    if (arr[dy][dx] == 'X') {
                        break;
                    }
                    if (i == n - 1) {
                        sx = dx;
                        sy = dy;
                    }
                }
            }
        }
        
        return new int[]{sy, sx};
    }
}