package _9_排序._1_插入排序;

public class _1_直接插入排序 {

    static int length = 0;
    static int[] r = null;

    static void straightInsertSort(int[] $r, int n) {
        // 处理数据
        length = $r.length;
        r = new int[length + 1];
        System.arraycopy($r, 0, r, 1, length);

        for (int i = 2; i <= length ; i++) {
            r[0] = r[i]; // 将i暂存在下标0的位置
            int j;
            for (j = i - 1; r[j] > r[0]; j--) { // j >=1, 就默认约束在, r[j] > r[0]
                r[j + 1] = r[j];
            }
            r[j+1] = r[0];
        }
    }

}
