class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // return method1(arr, n, m);
        return method2(arr, n, m);
    }
    
    // time complexity : O(n + m)
    // space complexity : O(1)
    int method2(int arr[][], int n, int m) {
        int row = -1;
        int max = 0;
        int pos = m;
        for (int i = 0; i < n; i ++) {
            for (int j = pos - 1; j >= 0; j --) {
                if (arr[i][j] == 0) break;
                else pos = j;
                if (pos == 0) return i;
            }
            int count = m - pos;
            if (count > max) {
                max = count;
                row = i;
            }
        }
        return row;
    }
  
    // time complexity : O(n log m)
    // space complexity : O(1)
    int method1(int arr[][], int n, int m) {
        int max = 0;
        int row = -1;
        for (int i = 0; i < n; i ++) {
            int low = 0;
            int high = m - 1;
            int mid = (low + high) / 2;
            int pos = m;
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[i][mid] == 1) pos = mid;
                if (arr[i][mid] < 1) low = mid + 1;
                else high = mid - 1;
            }
            int count = m - pos;
            // System.out.println("i = " + i + " count = " + count);
            if (count > max) {
                max = count;
                row = i;
            }
        }
        return row;
    }
}
