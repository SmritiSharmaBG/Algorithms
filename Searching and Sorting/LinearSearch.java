class Solution {
    public int search(int arr[], int n, int k) {

        //return linear(arr,n,k);
        return improvedLinear(arr,n,k);
    }
    
    // BRUTE FORCE 
    int linear(int arr[], int n, int k) {
        for(int i = 0; i < n; i ++) if (arr[i] == k) return (i+1);
        return -1;
    }
    
  // IMPROVED SOLUTION
    int improvedLinear(int arr[], int n, int k) {
        int left = 0;
        int right = n;
        int pos = -1;
        for(; left <= right; ) {
            if(arr[left ++] == k) return left;
            if(arr[-- right] == k) pos = right + 1;
        }
        return pos;
    }
}
