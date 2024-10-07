class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                left[0] = number / 3;
                left[1] = 0;
            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                right[0] = number / 3 - 1;
                right[1] = 2;
            } else {
                int numberX = number / 3;
                int numberY = 1;
                if (number == 0) {
                    numberX = 3;
                }
                int manhLeft = Math.abs(numberX - left[0]) + Math.abs(numberY - left[1]);
                int manhRight = Math.abs(numberX - right[0]) + Math.abs(numberY - right[1]);
                if (manhLeft > manhRight) {
                    sb.append("R");
                    right[0] = numberX;
                    right[1] = numberY;
                } else if (manhLeft < manhRight) {
                    sb.append("L");
                    left[0] = numberX;
                    left[1] = numberY;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right[0] = numberX;
                        right[1] = numberY;
                    } else {
                        sb.append("L");
                        left[0] = numberX;
                        left[1] = numberY;
                    }
                }
            }
        }
        
        return sb.toString();
    }
}