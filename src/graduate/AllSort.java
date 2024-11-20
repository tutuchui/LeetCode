package graduate;

public class AllSort {
    public static void main(String[] args) {
//        int[] array = {49,38,65,97,76,13,27,49};
        AllSort allSort = new AllSort();
////        allSort.selectionSort(array);
////        allSort.printArray(array);
//        allSort.quickSort(array,0,array.length-1);
//        allSort.printArray(array);

//        System.out.println(allSort.isNetworkConnected(list,5));

    }


    public void printArray(int[] array) {
        for (int tmp : array) {
            System.out.print(tmp + " ");
        }
        System.out.println();
    }

    /***************************Quick Sort***********************************/
    public void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;

        int key = a[low];

        while (i < j) {
            while (i < j && a[j] > key) {
                j--;
            }
            while (i < j && a[i] <= key) {
                i++;
            }
            if (i < j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }

        int p = a[i];
        a[i] = a[low];
        a[low] = p;

        quickSort(a, low, i - 1);
        quickSort(a, i + 1, high);
    }

    /********************************Heap Sort*****************************/
    public void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeap(array, i, 0);
        }
    }

    public void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int half = array.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }

    }

    public void maxHeap(int[] array, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < heapSize && array[largest] < array[left]) {
            largest = left;
        }
        if (right < heapSize && array[largest] < array[right]) {
            largest = right;
        }

        if (index != largest) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            maxHeap(array, heapSize, largest);
        }
    }

    /************************ Merge Sort ****************************/

    public void merge(int[] A, int p, int q, int r) {
        int n_1 = q - p + 1;
        int n_2 = r - q;
        int[] L = new int[n_1 + 1];
        int[] R = new int[n_2 + 1];
        for (int i = 0; i < n_1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n_2; j++) {
            R[j] = A[q + j + 1];
        }
        L[n_1] = (int) Double.POSITIVE_INFINITY;
        L[n_2] = (int) Double.POSITIVE_INFINITY;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
    }

    /*****************************Insertion Sort*************************************/
    public void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    /********************Bubble Sort***************************/
    public void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
    }

    /************************Selection Sort**********************/
    public void selectionSort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            int greatPos = 0;
            for (int j = 0; j <= i; j++) {
                if (array[j] >= array[greatPos]) {
                    greatPos = j;
                }
            }

            if (greatPos != i) {
                int temp = array[i];
                array[i] = array[greatPos];
                array[greatPos] = temp;
            }
        }
    }
}
    /*****************************************************************/


