class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        int index = -1;
        char[] c = dartResult.toCharArray();
        
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '1' && c[i + 1] == '0') {
                score[++index] = 10;
                i++;
            } else if (c[i] >= '0' && c[i] <= '9') {
                score[++index] = Integer.parseInt(String.valueOf(c[i]));
            }
            
            switch (c[i]) {
                case 'D' :
                    score[index] = (int) Math.pow(score[index], 2);
                    break;
                case 'T' :
                    score[index] = (int) Math.pow(score[index], 3);
                    break;
                case '*' :
                    if (index == 0) {
                        score[index] = score[index] * 2;
                    } else {
                        score[index - 1] = score[index - 1] * 2;
                        score[index] = score[index] * 2;
                    }
                    break;
                case '#' :
                    score[index] = -score[index];
                    break;
            }
        }
        
        int answer = 0;
        for (int s : score) {
            answer += s;
        }
        
        return answer;
    }
}