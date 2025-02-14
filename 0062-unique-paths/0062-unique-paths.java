class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        // fill the top row
        for(int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }

        // fill the left row
        for(int i=1; i<= m; i++) {
            dp[i][1] = 1;
        }

        // start building dp
        for(int i = 2; i <= m; i++) {
            for(int j = 2; j <=n ; j++) {
                // System.out.println(dp[i-1][j] + dp[i][j-1]);
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }
}