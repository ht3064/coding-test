class Solution {
    public int solution(int[] wallet, int[] bill) {
        int count = 0;
        
        while (true) {
            if (wallet[0] < wallet[1]) {
            int temp = wallet[0];
            wallet[0] = wallet[1];
            wallet[1] = temp;
            }
            
            if (bill[0] < bill[1]) {
            int temp = bill[0];
            bill[0] = bill[1];
            bill[1] = temp;
            }
            
            if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) {
                break;
            } else {
                bill[0] /= 2;
                count++;
            }
        }
        
        return count;
    }
}