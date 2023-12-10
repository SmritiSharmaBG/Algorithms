class Solution {
  /* 
  Traverse only the boundary. The Os connected to boundary directly and/or indirectly can never be converted to X.
  Other can be converted to X.

  1. Traverse only the boundary Os.
  2. Traverse all the other Os connected to it (boundary/non-boundary) using DFS
  3. We will keep track of visited Os using boolean vis array.
  4. Once done travsering with all the boundary elements, We need to convert Os into Xs.
  5. For this, travserse the whole board. The element that is visited and O, is NOT to be converted into X. Rest all Os can be converted to X.
  
  */
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] moveH = {0, 1, 0, -1};
        int[] moveV = {-1, 0, 1, 0};

        boolean[][] vis = new boolean[m][n];

        // traversing only the boundaries

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i != 0 && i != m - 1 && j != 0 && j != n -1) continue;
                char c = board[i][j];
                if (c == 'X') continue;
                if (c == 'O') {
                    dfs(board, i, j, vis, moveH, moveV, m, n);
                }
            }
        }    

        // visited Os must not be X, rest all Os can be put as X
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'O' && !vis[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] vis, int[] moveH, int[] moveV, int m, int n) {
        vis[i][j] = true;
        for (int move = 0; move < 4; move ++) {
            int row = i + moveV[move];
            int col = j + moveH[move];
            if (isValid(row, col, m, n) && board[row][col] == 'O' && !vis[row][col]) 
                dfs(board, row, col, vis, moveH, moveV, m, n);
            else continue;
        }
    }

    private boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }
}
