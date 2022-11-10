class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        int top = 0;
        int down = r - 1;
        int left = 0;
        int right = c - 1;
        int dir = 0;
        while (top <= down && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i ++) {
                    arr.add(matrix[top][i]);
                }
                top ++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i ++) {
                    arr.add(matrix[i][right]);
                }
                right --;
            } else if (dir == 2) {
                for (int i = right; i >= left; i --) {
                    arr.add(matrix[down][i]);
                }
                down --;
            } else if (dir == 3) {
                for (int i = down; i >= top; i --) {
                    arr.add(matrix[i][left]);
                }
                left ++;
            }
            dir = (dir + 1) % 4;
        }
        return arr;
    }
}
