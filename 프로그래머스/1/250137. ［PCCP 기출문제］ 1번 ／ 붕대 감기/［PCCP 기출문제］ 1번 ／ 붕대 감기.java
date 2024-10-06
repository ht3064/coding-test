class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int lastTime = attacks[attacks.length - 1][0];
        int index = 0;
        int count = 0;
        
        for (int i = 1; i <= lastTime; i++) {
            if (i == attacks[index][0]) {
                answer -= attacks[index][1];
                index++;
                count = 0;
            } else {
                answer += bandage[1];
                count++;
            }
            if (count == bandage[0]) {
                answer += bandage[2];
                count = 0;
            }
            if (answer > health) {
                answer = health;
            }
            if (answer <= 0) {
                return -1;
            }
        }
        
        return answer;
    }
}