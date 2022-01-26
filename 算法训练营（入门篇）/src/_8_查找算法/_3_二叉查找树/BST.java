package _8_查找算法._3_二叉查找树;

public class BST {

    /*
    BST的结构
    * */
    static class BSTree {
        int value;
        BSTree left;
        BSTree right;

        public BSTree(int value, BSTree left, BSTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /*
    F....
        :
        :...p

    * */


    /**
     * 查找
     *
     * @param t     the t
     * @param value the value
     * @return the bs tree
     */
    BSTree search(BSTree t, int value) {
        BSTree p = t;
        while(p != null) {
            if(p.value == value) {
                break;
            }

            if (p.value > value) {
                // 当前节点比目标值大，在左子树中找
                p = p.left;
            } else {
                // 当前节点比目标值小，在右子树中找
                p = p.right;
            }

        }

        return p;
    }

    /**
     * 插入
     *
     * @param t     the t
     * @param value the value
     */
    void insert(BSTree t, int value) {
        BSTree f = null, p = t, s = null;
        while(p != null) {
            if(p.value == value) {
                break;
            }
            // f 为 p 的父节点
            f = p;
            if (p.value > value) {
                // 当前节点比目标值大，在左子树中找
                p = p.left;
            } else {
                // 当前节点比目标值小，在右子树中找
                p = p.right;
            }
        }

        if(p != null) return;

        s = new BSTree(value, null, null);

        if(f == null) {
            t = s;
        } else if (p == f.left) {
            f.left = s;
        } else {
            f.right = s;
        }
    }

    /**
     * 删除
     *
     * @param t     the t
     * @param value the value
     * O(n) = logn, 主要就是查找的时间以及找前驱和后继的时间
     */
    void delete(BSTree t, int value) {
        BSTree f = null, p = t, q = null, s = null;
        while(p != null) {
            if(p.value == value) {
                break;
            }
            // f 为 p 的父节点
            f = p;
            if (p.value > value) {
                // 当前节点比目标值大，在左子树中找
                p = p.left;
            } else {
                // 当前节点比目标值小，在右子树中找
                p = p.right;
            }
        }

        if(p == null) return;

        if (p.left != null && p.right != null) {
            // 左右子树都不为空
            q = p;
            s = p.left;
            while(s.right != null) {
                // 在左子树中找前驱
                q = s;
                s = s.right;
            }

            //然后修改q节点的指针
            if(q != p) {
                q.right = s.left;
            } else {
                q.left = s.left;
            }

            // 修改s的左右指针
            s.left = p.left;
            s.right = p.right;

        } else {
            // 左右子树至少有一个为空，已经包含了左右子树都为空
            if(p.left == null) {
                s = p.right;
            } else {
                s = p.left;
            }
        }

        if(f == null) {
            t = s;
        } else if (p == f.left) {
            f.left = s;
        } else {
            f.right = s;
        }
    }
    

}
