class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Cell> queue= new LinkedList<>();

        // Add all the rotten oranges in the queue for a start.
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                int orange = grid[i][j]; // 00, 01, 02 -> 10, 11, 12
                if (orange == 2) {
                    // orange is rotten -> add it in the queue
                    queue.add(new Cell(i, j));
                }
            }
        }

        // prepare array for 4-directional movement
        int[] moveH = {0, 1, 0, -1};
        int[] moveV = {-1, 0, 1, 0};

        int min = 0;

        // Do a BFS traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int l = 0; l < levelSize; l ++) {
                Cell rottenOrange = queue.remove();
                for (int i = 0; i < 4; i ++) {
                    int newRow = rottenOrange.row + moveV[i];
                    int newCol = rottenOrange.column + moveH[i];
                    if(isValid(newRow, newCol, m, n) && containsFreshOrange(newRow, newCol, grid)) {
                        // we found a fresh orange that is going to rot.
                        // Add it in queue and rot it
                        queue.add(new Cell(newRow, newCol));
                        grid[newRow][newCol] = 2;
                    }
                }
            }
            if (!queue.isEmpty()) min ++;

        }

        // if any fresh orange is left, return -1
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                int orange = grid[i][j]; // 00, 01, 02 -> 10, 11, 12
                if (orange == 1) {
                    // orange is fresh -> return -1
                    return -1;
                }
            }
        }

        return min;

    }

    private boolean isValid(int row, int column, int m, int n) {
        return (row >= 0 && row < m && column >= 0 && column < n);
    }

    private boolean containsFreshOrange(int row, int column, int[][] grid) {
        return grid[row][column] == 1;
    }

    private class Cell {
        int row;
        int column;

        Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
