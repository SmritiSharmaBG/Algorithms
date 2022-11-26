class Solution {
    int median(int A[][], int R, int C) {
        // find low
        int low = A[0][0];
        for (int i = 0; i < R; i ++) {
            int x = A[i][0];
            if (x < low) low = x;
        }
        
        // find high
        int high = A[0][C - 1];
        for (int i = 0; i < R; i ++) {
            int x = A[i][C - 1];
            if (x > high) high = x;
        }
        
        int mid = (low + high) / 2;
        int total = R * C; // always odd
        int midCount = total / 2 + 1;
        while (low <= high) {
            mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < R; i ++)
                count += getAllCount(A[i], mid);
            if (count >= midCount) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    
    private int getAllCount(int[] A, int num) {
        int c = 0;
        for (int i : A) {
            if (i <= num) c ++;
            else return c;
        }
        return c;
    }
}
