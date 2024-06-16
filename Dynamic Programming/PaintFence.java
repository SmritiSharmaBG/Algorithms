class Solution
{
  // This Solution is conceptually correct and passes 90.25% of the test cases. 
  // Rest it is not able to pass because of some issue in "modulo 10^9 + 7"
    long countWays(int n,int k)
        {
            if (n == 1) return k;
            return dp(n, k);
        }

        private long dp(int n, int k) {
            long MAX = 1000000007;
            
            // house x (last 2 same x last 2 different)
            long dp[][] = new long[n][2];

            // last 2 same / diff cant be done when only 1 house.

            // total number of ways last 2 same for 2 houses = k
            dp[1][0] = k;
            // total number of ways last 2 diff for 2 houses = k * (k - 1)
            dp[1][1] = k * (k - 1);

            for (int house = 2; house < n; house ++) {
                // last 2 same = (total number of ways last 2 diff for last house) * 1
                // why 1 ? because we need have only one option for each last diff
                // i.e. none other than the last color itself.
                // why dont we use last 2 same ? because it will result in last 3 same
                dp[house][0] = (dp[house - 1][1]) % MAX;
                // last 2 diff = (total number of ways last 2 diff/same for last house) * (k - 1)
                // why (k - 1) ? because we need have (k - 1) options for all the ways (diff/same)
                // i.e. all other than the last color used.
                dp[house][1] = ((dp[house - 1][0] + dp[house - 1][1])%MAX  * (k - 1)) % MAX;
            }

            return (dp[n - 1][0] + dp[n - 1][1]) % MAX;
        }
}
