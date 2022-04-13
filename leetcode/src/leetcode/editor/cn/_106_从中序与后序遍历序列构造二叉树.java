package leetcode.editor.cn;

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 672 👎 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class _106_从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new _106_从中序与后序遍历序列构造二叉树().new Solution();
        // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode ans = solution.buildTree(inorder, postorder);
        return;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        int[] c = null;
        LinkedList<int[]> cs = new LinkedList<>();
        LinkedList<int[]> ss = new LinkedList<>();

        int[] inorder = null;

        int[] postorder = null;

        // 缓存结果
        Map<Integer, TreeNode> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.inorder = inorder;
            this.postorder = postorder;

            cs.push(new int[]{0, inorder.length - 1, 0, postorder.length - 1, -1});

            while (!cs.isEmpty()) {
                c = cs.peek();
                if (c != ss.peek()) {
                    int[] last = ss.peek();
                    ss.push(c);
                    TreeNode node = new TreeNode(postorder[c[3]]);
                    if (last != null) {
                        TreeNode root = map.get(last[3]);
                        if (c[4] == 0) {
                            root.left = node;
                        } else if (c[4] == 1) {
                            root.right = node;
                        }
                    }

                    map.put(c[3], node);

                    push();
                } else {
                    ss.pop();
                    cs.pop();
                }
            }

            return map.get(postorder.length - 1);
        }

        void push() {
            int is = c[0];
            int ie = c[1];
            int ps = c[2];
            int pe = c[3];

            int i = is;
            while (i <= ie) {
                if (inorder[i] == postorder[pe]) {
                    break;
                }
                i++;
            }
            // 0 代表左节点，1代表右节点
            if (ps <= ps + i - 1 - is) cs.push(new int[]{is, i - 1, ps, ps + i - 1 - is, 0});
            if (ps + i - is <= pe - 1) cs.push(new int[]{i + 1, ie, ps + i - is, pe - 1, 1});
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}