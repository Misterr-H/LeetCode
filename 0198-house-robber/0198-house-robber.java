class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(dp[1], nums[1]);

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }

        return dp[n];
    }
}