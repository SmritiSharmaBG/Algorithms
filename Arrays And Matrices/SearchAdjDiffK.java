class Complete{
    // Function for finding maximum and value pair
    public static int search (int arr[], int n, int x, int k) {
        int pos = 0;
        while (pos < n) {
            int a = arr[pos];
            if (a == x) return pos;
            int diff = a - x > 0 ? a - x : x - a;
            int jump = diff / k;
            if (jump == 0) jump = 1;
            pos += jump;
        }
        return -1;
    }
}
