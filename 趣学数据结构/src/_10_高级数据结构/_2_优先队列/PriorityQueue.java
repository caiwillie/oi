package _10_高级数据结构._2_优先队列;

/**
 * 优先级队列
 */
public class PriorityQueue {

    int[] r;

    /**
     * 下沉操作
     *
     * @param k k元素的下标（k的左孩子下标为 2*k, k的右孩子下标为 2*k + 1）
     * @param n 总共的元素个数
     */
    void sink(int k, int n) {
        while(2 * k <= n) {
            int j = 2 * k;
            if(j < n && r[j] < r[j + 1]) {
                // j < n 说明肯定有右孩子，然后在比较右孩子是否比左孩子大
                j = j + 1;
            }
            // 此时j代表比较大的孩子的下标， 然后再比较当前节点和比较大的孩子
            if(r[k] >= r[j]) {
                break;
            } else {
                swap(k, j);
                k = j;
            }
        }
    }

    /**
     * 交换两个下标的内容
     *
     * @param k the k
     * @param j the j
     */
    void swap(int k, int j) {
        int temp = r[k];
        r[k] = r[j];
        r[j] = temp;
    }

    int pop(int n) {
       int a = r[1];
       r[1] = r[n];
       n--; // 出列了一个元素，忽略末尾
       sink(1, n);
       return a;
    }

}
