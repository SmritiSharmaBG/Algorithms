package dp;

public class PrintLCS {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        String s1 = "zx2fe";
        String s2 = "cbbcad";
        System.out.println(findLCS(n, m, s1, s2));
    }

    public static String findLCS(int n, int m, String s1, String s2) {
        int[][] dp = new int[n + 1][m + 1];

        // generate table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                int match = 0;
                int notMatch = 0;

                if (c1 == c2) {
                    match = dp[i - 1][j - 1] + 1;
                } else {
                    int possibility1 = dp[i - 1][j];
                    int possibility2 = dp[i][j - 1];
                    notMatch = Math.max(possibility1, possibility2);
                }
                dp[i][j] = Math.max(match, notMatch);
            }
        }

        int i = n;
        int j = m;
        String ans = "";

        while (i > 0 && j > 0) {
            char c1 = s1.charAt(i - 1);
            char c2 = s2.charAt(j - 1);
            if (c1 == c2) {
                ans = new StringBuilder(ans).append(c1).toString();
                i--;
                j--;
            } else {
                int up = dp[i - 1][j];
                int side = dp[i][j - 1];
                if (up > side) {
                    i--;
                } else {
                    j--;
                }
            }
        } // while
        return new StringBuilder(ans).reverse().toString();
    }
}
