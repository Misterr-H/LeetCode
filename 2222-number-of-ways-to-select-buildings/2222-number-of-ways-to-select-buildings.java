// class Solution {
//     long[][][] dp;
//     int count = 0;
//     public long numberOfWays(String s) {
//         dp = new long[100001][4][3];
//         for(int i = 0; i < 100001; i++) {
//             for(int j = 0; j < 4; j++) {
//                 for(int k = 0; k < 3; k++) {
//                     dp[i][j][k] = -1;
//                 }
//             }
//         }
//         long res =  solve(s, 0, 3, -1);
//         System.out.println(count);
//         return res;
//     }

//     private long solve(String s, int index, int selections, int prev) {
//         int m = s.length();

//         // base case
//         if(selections <=0) return 1;
//         if(index>=m) return 0;
//         if(dp[index][selections][prev+1]!=-1) return dp[index][selections][prev+1];
//         count++;

//         long take = 0, skip;

//         // selections
//         if((s.charAt(index) - '0') != prev) {
//             // dp[index][selections][prev+1] = solve(s, index+1, selections-1, s.charAt(index) - '0') + solve(s, index+1, selections, prev);
//             take = solve(s, index+1, selections-1, s.charAt(index) - '0');
//         } else {
//             // dp[index][selections][prev+1] = solve(s, index+1, selections, prev);
            
            
//         }
//         skip = solve(s, index+1, selections, prev);
//         return dp[index][selections][prev+1] = take+skip;
//     }
// }


class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        long[][] dp = new long[4][2]; // Only store for last char: 0 or 1

        dp[0][0] = dp[0][1] = 1; // Base case: No selections means 1 way
        
        for (char c : s.toCharArray()) {
            int num = c - '0';

            for (int i = 3; i > 0; i--) { // Reverse iteration to prevent overwriting
                dp[i][num] += dp[i - 1][1 - num]; // Transition step
            }
        }
        return dp[3][0] + dp[3][1]; // Sum of all valid sequences of length 3
    }
}
