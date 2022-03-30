package leetcode.editor.cn;

//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 755 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _145_二叉树的后序遍历 {
    public static void main(String[] args) {
        Solution solution = new _145_二叉树的后序遍历().new Solution();
        TreeNode _3 = new TreeNode(3, null, null);
        TreeNode _2 = new TreeNode(2, null, _3);
        TreeNode _1 = new TreeNode(1, null, _2);
        List<Integer> ans = solution.postorderTraversal(_1);
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

        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> cs = new LinkedList<>();
        LinkedList<TreeNode> ss = new LinkedList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            if(root != null) cs.push(root);

            while (!cs.isEmpty()) {
                TreeNode c = cs.peek();
                if (c != ss.peek()) {
                    ss.push(c);

                    // 后序
                    cs.pop();
                    cs.push(c);
                    // push
                    if(c.right != null) cs.push(c.right);
                    if(c.left != null) cs.push(c.left);
                } else {
                    // add
                    ans.add(c.val);

                    cs.pop();
                    ss.pop();
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}