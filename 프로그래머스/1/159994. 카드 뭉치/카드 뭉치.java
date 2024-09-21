class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Index = 0;
        int card2Index = 0;
        
        for (String s : goal) {
            if(card1Index < cards1.length && s.equals(cards1[card1Index])) {
                card1Index++; 
            } else if (card2Index < cards2.length && s.equals(cards2[card2Index])) {
                card2Index++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}