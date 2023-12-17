class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Cell> queue = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        // store boundary elements in queue and mark as visited
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) { // boundary element
                    if (grid[i][j] == 1) {
                        queue.add(new Cell(i, j));
                        vis[i][j] = true;
                    }
                }
            }
        }

        // prepare array to move 4 directionally
        int[] moveH = {0, 1, 0, -1};
        int[] moveV = {-1, 0, 1, 0};

        // do BFS

        while(!queue.isEmpty()) {
            Cell cell = queue.remove();
            // make it 0
            grid[cell.r][cell.c] = 0;
            // move 4 directionally and find attached element
            for (int move = 0; move < 4; move ++) {
                int row = cell.r + moveV[move];
                int col = cell.c + moveH[move];

                if (isValid(row, col, m, n) && !vis[row][col] && grid[row][col] == 1) {
                    queue.add(new Cell(row, col));
                    vis[row][col] = true;
                }
            } // for
        } // while

        // count all left over 1s
        int ans = 0;

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    ans ++;
                }
            }
        }

        return ans;
    }

    private boolean isValid(int row, int col, int m, int n) {
        return (row >= 0 && row < m && col >= 0 && col < n);
    }

    private class Cell {
        int r;
        int c;

        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
