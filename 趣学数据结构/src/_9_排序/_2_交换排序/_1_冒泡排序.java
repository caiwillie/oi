package _9_排序._2_交换排序;

public class _1_冒泡排序 {

    static int length = 0;
    static int[] r = null;

    static void bubbleSort(int[] $r) {
        length = $r.length;
        r = new int[length + 1];
        System.arraycopy($r, 0, r, 1, length);

        for (int i = length; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if(r[j] > r[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    static void swap(int a, int b) {
        r[0] = r[a];
        r[a] = r[b];
        r[b] = r[0];
    }
}
