package SearchingSorting;
public class BubbleSearch {
    void bubbleSearch(int [] arr) {
        for(int i = 0; i < arr.length - 1; i ++) {
           for(int j = 0; j < arr.length - i - 1; j ++) {
               if(arr[j] > arr[j + 1]) {
                   // swapping
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j + 1] = temp;
               }
           }
        }
    }
}