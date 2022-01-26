package _8_查找算法._2_字符串模式匹配;

public class _2_KMP算法 {

    static void getNext(String $t) {
        int length = $t.length();
        char[] t = new char[length + 1];
        System.arraycopy($t.toCharArray(), 0, t, 1, length);
        int[] next = new int[length + 1];

        next[0] = -1;
        int k = -1;
        // a,b -> k = 0(next[1]), a[1], a[2]
        // a,a -> k = 0(next[1]), a[1], a[2]
        // aa,a -> k = 1(next[2]), a[2], a[3] 比较
        // ab,a -> k = 0(next[2]), a[1], a[3]
        // i = 2, k 代表 i = 1 时的长度
        // i = 3, k = 1

        // k 代表 i - 1时的最大长度
        for (int i = 1; i <= length; i++) {
            while(true) {
                if(k == -1 || t[k + 1] == t[i]) {
                    next[i] = ++k;
                    break;
                } else {
                    k = next[k];
                }
            }
        }
    }


    public static void main(String[] args) {
        getNext("abba");
        return;


    }

}