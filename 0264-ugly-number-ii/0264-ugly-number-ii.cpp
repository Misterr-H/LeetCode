class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int> dp(n+1);
        dp[1]=1;
        int p1=1, p2=1, p3=1;
        for(int i=2; i<=n; i++) {
            int mul2 = dp[p1]*2;
            int mul3 = dp[p2]*3;
            int mul5 = dp[p3]*5;

            dp[i] = min(mul2, min(mul3, mul5));

            if(dp[i] == mul2) p1++;
            if(dp[i] == mul3) p2++;
            if(dp[i] == mul5) p3++;
        }
        
        return dp[n];
    }
};