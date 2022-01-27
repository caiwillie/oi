package _9_排序._2_交换排序;

public class _2_快速排序 {

    static int length;
    static int[] r;




    static void quickSort(int[] $r) {
        length = $r.length;
        r = new int[length + 1];
        System.arraycopy($r, 0, r, 1, length);
        recursiveQuickSort(r, 1, length);
    }

    static void recursiveQuickSort(int[] r, int low, int high) {
        if(low < high) {
            int middle = partition(r, low, high);
            recursiveQuickSort(r, low, middle - 1);
            recursiveQuickSort(r, middle + 1, high);
        }
    }


    static int partition(int[] r, int low, int high) {
        int i = low, j = high, pivot = r[low];
        while(i < j) {
            while(i < j && r[j] > pivot) j--;
            if(i < j) {
                swap(i, j);
                i++;
            }
            while(i < j && r[i] >= pivot) i++;
            if(i < j) {
                swap(i, j);
                j--;
            }
        }

        return i;
    }

    static void swap(int a, int b) {
        r[0] = r[a];
        r[a] = r[b];
        r[b] = r[0];
    }


}
