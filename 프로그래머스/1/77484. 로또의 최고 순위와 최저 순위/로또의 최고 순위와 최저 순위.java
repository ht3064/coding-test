class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int countEq = 0;
        int countZero = 0;
        
        for (int i : lottos) {
            if (i == 0) {
                countZero++;
                continue;
            }
            for (int j : win_nums) {
                if (i == j) {
                    countEq++;
                    break;
                }
            }
        }
        
        int lowGrade = getGrade(countEq);
        int highGrade = getGrade(countEq + countZero);
        
        return new int[]{highGrade, lowGrade};
    }
    
    public int getGrade(int n) {
        switch (n) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default : 
                return 6;
        }
    }
}