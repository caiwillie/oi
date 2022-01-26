package _10_高级数据结构._1_并查集;

/**
 * 并查集合（Disjoint Set Union）
 */
public class DSU {

    private int[] father;


    /**
     * 递归查询祖先
     *
     * @param x the x
     * @return the int
     */
    int find(int x) {
        if(x != father[x]) {
            father[x] = find(father[x]); // 递归查找，并且在返回时，修改节点当前父级节点为祖先节点
        }
        return father[x];
    }

    /**
     * 合并两个集合的祖先，默认规定将大序号改成大序号
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    int union(int a, int b) {
        int p = find(a); // 查找a的祖先
        int q = find(b); // 查找b的祖先
        if(p == q) {
            return 0;
        }

        // 合并两个祖先
        if(p > q) {
            father[p] = q;
        } else {
            father[q] = p;
        }

        return 1;
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

    }
}
