package Recusrion;

import java.util.ArrayList;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        int n = 4;
        Solution s = new Solution();
        ArrayList<String> ans = s.findPath(m,n);
        for (String i : ans) System.out.println(i);
    }

    private static class Solution {
        public static ArrayList<String> findPath(int[][] m, int n) {
            boolean[][] vis = new boolean[n][n];
            vis[0][0] = true;
            ArrayList<String> ans = new ArrayList<>();
            rec(0,0,ans,"",n,m, vis);
            return ans;
        }

        private static void rec(int r, int c, ArrayList<String> ans, String str, int n, int[][]m, boolean[][] vis) {
            if(m[r][c] == 0) return;

            if (r == n - 1 && c == n - 1) {
                ans.add(str);
                return;
            }


            // move down
            if(r + 1 < n && c < n && !vis[r + 1][c]) {
                vis[r + 1][c] = true;
                rec(r + 1, c, ans, str + 'D', n, m, vis);
                vis[r + 1][c] = false;
            }

            // move left
            if(r < n && c - 1 >= 0 && !vis[r][c - 1]) {
                vis[r][c - 1] = true;
                rec(r, c - 1, ans, str + 'L', n, m, vis);
                vis[r][c - 1] = false;
            }

            // move Right
            if(r < n && c + 1 < n && !vis[r][c + 1]) {
                vis[r][c + 1] = true;
                rec(r, c + 1, ans, str + 'R', n, m, vis);
                vis[r][c + 1] = false;
            }

            // move up
            if(r - 1 >= 0 && c < n && !vis[r - 1][c]) {
                vis[r - 1][c] = true;
                rec(r - 1, c, ans, str + 'U', n, m, vis);
                vis[r - 1][c] = false;
            }
        }
    }
}
