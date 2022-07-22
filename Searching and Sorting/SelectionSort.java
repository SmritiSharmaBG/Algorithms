package SearchingSorting;

public class SelectionSort {
    void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i ++) {
            int smallest = i;
            for(int j = i + 1; j < arr.length; j ++) {
                if(arr[smallest] > arr[j]) smallest = j;
            }
            // swap smallest with ith element
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
}
