package leetcode.editor.cn;

//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 585 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class _103_二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        Solution solution = new _103_二叉树的锯齿形层序遍历().new Solution();

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

        LinkedList<TreeNode> q = new LinkedList<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();

            // flag == true 表示从左往右，flag == false 表示从右往左
            boolean flag = true;

            // 初始化
            if (root != null) q.push(root);

            while (!q.isEmpty()) {
                List<Integer> l = new ArrayList<>();
                int length = q.size();

                for (int i = 0; i < length; i++) {
                    TreeNode n = q.poll();
                    if (n.left != null) q.offer(n.left);
                    if (n.right != null) q.offer(n.right);
                    l.add(n.val);
                }

                if (!flag) {
                    Collections.reverse(l);
                }

                flag = !flag;

                ans.add(l);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}