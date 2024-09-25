class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] binaryArr1 = intToBinary(arr1);
        String[] binaryArr2 = intToBinary(arr2);
        
        String[] answer = new String[n];
         
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (binaryArr1[i].charAt(j) == '1' || binaryArr2[i].charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    
    private String[] intToBinary(int[] arr) {
        String[] binaryArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
    
            String binary = Integer.toBinaryString(arr[i]);
            while (binary.length() < binaryArr.length) {
                StringBuilder sb = new StringBuilder();
                binary = sb.append("0").append(binary).toString();
            }
            binaryArr[i] = binary;
        }
        
        return binaryArr;
    }
}