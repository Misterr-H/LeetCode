class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int answer = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                answer += Math.min(tickets[i], tickets[k]);
            } else {
                answer += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return answer;
    }
}