package _8_查找算法._2_字符串模式匹配;

import sun.text.normalizer.UCharacter;

public class _2_KMP算法 {






    static int sl = 0;
    static int tl = 0;
    static char[] s = null;
    static char[] t = null;
    static int[] next = null;

    static int kmp(String $s, String $t) {
        // 处理数据
        sl = $s.length();
        tl = $t.length();
        s = new char[sl + 1];
        t = new char[tl + 1];
        next = new int[tl + 1];
        System.arraycopy($t.toCharArray(), 0, t, 1, tl);
        System.arraycopy($s.toCharArray(), 0, s, 1, sl);
        getNext($t);
        int i, j = 1;
        // s=abaabaabeca, t=abaabe: i = 1, j = 1
        for (i = 1; i <= sl && j <= tl; i++) {
            while(true) {
                if(j == 0 || s[i] == t[j]) {
                    j++;
                    break;
                } else {
                    j = next[j];
                }
            }
        }

        if(j > tl) {
            return i - tl;
        } else
            return -1;
    }


    static void getNext(String $t) {

        int k = next[0] = -1;
        // k 代表 i - 1时的最大长度
        // a,b -> k = 0(next[1]), a[1], a[2]
        // a,a -> k = 0(next[1]), a[1], a[2]
        // aa,a -> k = 1(next[2]), a[2], a[3] 比较
        // ab,a -> k = 0(next[2]), a[1], a[3]
        // i = 2, k 代表 i = 1 时的长度
        // i = 3, k = 1

        for (int i = 1; i <= tl; i++) {
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
        int kmp = kmp("abaabaabeca", "abaab");
        System.out.println(kmp);
    }

}