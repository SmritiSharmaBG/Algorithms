class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        
        // get the LCS
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i ++) {
            for (int j = 1; j <= len2; j ++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);

                int match = 0;
                int notMatch = 0;

                if (c1 == c2) match = dp[i - 1][j - 1] + 1;
                else {
                    int possibility1 = dp[i - 1][j];
                    int possibility2 = dp[i][j - 1];
                    notMatch = Math.max(possibility1, possibility2);
                }

                dp[i][j] = Math.max(match, notMatch);
            }
        }

        String superSeq = getSuperSequence(dp, len1, len2, str1, str2);

       return superSeq;
    }

    private String getSuperSequence(int[][] dp, int len1, int len2, String str1, String str2) {
        int i = len1;
        int j = len2;

        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            char c1 = str1.charAt(i - 1);
            char c2 = str2.charAt(j - 1);

            if (c1 == c2) {
                lcs.append(c1);
                i --;
                j --;
            } else {
                int up = dp[i - 1][j];
                int side = dp[i][j - 1];
                if (up > side) {
                    lcs.append(c1);
                    i --;
                }
                else {
                    lcs.append(c2);
                    j --;
                }
            }
        }

        while (j > 0) {
            char c2 = str2.charAt(j - 1);
            lcs.append(c2);
            j --;
        }

        while (i > 0) {
            char c2 = str1.charAt(i - 1);
            lcs.append(c2);
            i --;
        }

        return lcs.reverse().toString();
    }
}
