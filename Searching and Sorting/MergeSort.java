class MergeSorting
{
    void merge(int arr[], int l, int mid, int r)
    {
         int[] merged = new int[r - l + 1];
         
         int idx1 = l;
         int idx2 = mid + 1; 
         int x = 0;
         
         while(idx1 <= mid && idx2 <= r) {
             if (arr[idx1] <= arr[idx2]) merged[x ++] = arr[idx1 ++];
             else merged[x ++] = arr[idx2 ++];
         }
         
         while(idx1 <= mid) merged[x ++] = arr[idx1 ++];
         
         while(idx2 <= r) merged[x ++] = arr[idx2 ++];
         
         for(int i = 0, j = l; j <= r; i ++, j ++) arr[j] = merged[i];
    }
    void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }
}
