package leetcode.editor.cn;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1419 👎 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class _105_从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        Solution solution = new _105_从前序与中序遍历序列构造二叉树().new Solution();
        // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        TreeNode ans = solution.buildTree(preorder, inorder);
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

        int[] preorder = null;

        // 缓存结果
        Map<Integer, TreeNode> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.inorder = inorder;
            this.preorder = preorder;

            cs.push(new int[]{0, inorder.length - 1, 0, preorder.length - 1, -1});

            while (!cs.isEmpty()) {
                c = cs.peek();
                if (c != ss.peek()) {
                    int[] last = ss.peek();
                    ss.push(c);
                    TreeNode node = new TreeNode(preorder[c[2]]);
                    if (last != null) {
                        TreeNode root = map.get(last[2]);
                        if (c[4] == 0) {
                            root.left = node;
                        } else if (c[4] == 1) {
                            root.right = node;
                        }
                    }

                    map.put(c[2], node);

                    push();
                } else {
                    ss.pop();
                    cs.pop();
                }
            }

            return map.get(0);
        }


        void push() {
            int is = c[0];
            int ie = c[1];
            int ps = c[2];
            int pe = c[3];

            int i = is;
            while (i <= ie) {
                if (inorder[i] == preorder[ps]) {
                    break;
                }
                i++;
            }
            // 0 代表左节点，1代表右节点
            if (ps + 1 <= ps + i - is) cs.push(new int[]{is, i - 1, ps + 1, ps + i - is, 0});
            if (ps + i + 1- is <= pe) cs.push(new int[]{i + 1, ie, ps + i + 1- is, pe, 1});
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}