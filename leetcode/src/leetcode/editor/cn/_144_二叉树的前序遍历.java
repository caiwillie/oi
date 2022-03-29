package leetcode.editor.cn;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 776 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _144_二叉树的前序遍历{
    public static void main(String[] args) {
        Solution solution = new _144_二叉树的前序遍历().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> cs = new LinkedList<>();
        LinkedList<TreeNode> ss = new LinkedList<>();
        if(root != null) cs.push(root);

        while (!cs.isEmpty()) {
            TreeNode c = cs.peek();
            if (c != ss.peek()) {
                ss.push(c);

                cs.pop();

                // push
                if(c.right != null) cs.push(c.right);
                if(c.left != null) cs.push(c.left);
                // 前序
                cs.push(c);
            } else {
                // add
                res.add(c.val);

                cs.pop();
                ss.pop();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}