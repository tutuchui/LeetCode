public class AllSort {
    public static void main(String[] args) {
        int[] array = {14,3,2,9,6,8,5};
        AllSort allSort = new AllSort();
        allSort.heapSort(array);
        allSort.printArray(array);
    }

    public void printArray(int[] array){
        for(int tmp : array){
            System.out.print(tmp + " ");
        }
        System.out.println();
    }
    public void quickSort(int[] a, int low, int high){
       if(low > high){
           return;
       }
       int i = low;
       int j = high;

       int key = a[low];

       while(i < j){
           while(i < j && a[j] > key){
               j--;
           }
           while(i < j && a[i] <= key){
               i++;
           }
           if( i < j){
               int p = a[i];
               a[i] = a[j];
               a[j] = p;
           }

           int p = a[i];
           a[low] = a[i];
           a[i] = p;

           quickSort(a,low,i-1);
           quickSort(a,i+1,high);
       }
    }

    public void heapSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        buildMaxHeap(array);
        for(int i = array.length - 1; i >= 1; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeap(array,i,0);
        }
    }

    public void buildMaxHeap(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        int half = array.length / 2;
        for(int i = half; i >= 0; i--){
            maxHeap(array,array.length,i);
        }

    }

    public void maxHeap(int[] array, int heapSize, int index){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if(left < heapSize && array[largest] < array[left]){
            largest = left;
        }
        if(right < heapSize && array[largest] < array[right]){
            largest = right;
        }

        if(index != largest){
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            maxHeap(array,heapSize,largest);
        }
    }


}
