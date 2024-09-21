class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            char[] arr = targets[i].toCharArray();
            int sum = 0;
            
            for (char a : arr) {
                int index = Integer.MAX_VALUE;
                
                // keymap "ABC"
                // targets "DA"
                
                for (int j = 0; j < keymap.length; j++) {
                    if (keymap[j].indexOf(a) != -1) {
                        index = Math.min(index, keymap[j].indexOf(a));
                    }
                }
                
                if (index == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                } else{
                    sum += index + 1;
                }
            }
            
            result[i] = sum;
        }
        
        return result;
    }
}