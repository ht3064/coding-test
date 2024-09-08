import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int answer[] = new int[photo.length];
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            hashMap.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (hashMap.get(photo[i][j]) != null) {
                    answer[i] += hashMap.get(photo[i][j]);
                }
            }
        }
        
        return answer;
    }
}