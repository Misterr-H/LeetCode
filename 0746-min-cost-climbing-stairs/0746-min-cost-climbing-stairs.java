class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        // Fill the dp array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        
        // The minimum cost to reach the top of the floor
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}