class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        // step 1. FIND LCS
        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i ++) {
            for (int j = 1; j <= len2; j ++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);

                int match = 0;
                int notMatch = 0;

                if (c1 == c2) match = dp[i - 1][j - 1] + 1;
                else notMatch = Math.max(dp[i - 1][j], dp[i][j - 1]);

                dp[i][j] = Math.max(match, notMatch);
            }
        }

        int lcs = dp[len1][len2];
        int deletionInWord1 = len1 - lcs;
        int deletionInWord2 = len2 - lcs;

        return deletionInWord1 + deletionInWord2;

    }
}
