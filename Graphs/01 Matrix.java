class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<Data> queue = new LinkedList<>();
        int[][] distance = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        // initially, add all the cells containing 0s in the queue. The distance will be 0 for them

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                int element = mat[i][j];
                if (element == 0) {
                    queue.add(new Data(i, j, 0));
                    distance[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }

        // perform a BFS traversal

        int[] moveV = {-1, 0, 1, 0};
        int[] moveH = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Data data = queue.remove();
            distance[data.row][data.col] = data.d;
            // traverse the 4 directions

            for (int move = 0; move < 4; move ++) {
                int r = data.row + moveV[move];
                int c = data.col + moveH[move];

                if (isValid(r, c, m, n) && !vis[r][c]) {
                    queue.add(new Data(r, c, data.d + 1));
                    vis[r][c] = true;
                }
            }
        }

        return distance;
    }

    private boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }

    private class Data {
        int row;
        int col;
        int d;

        Data(int row, int col, int d) {
            this.row = row;
            this.col = col;
            this.d = d;
        }
    }
}
