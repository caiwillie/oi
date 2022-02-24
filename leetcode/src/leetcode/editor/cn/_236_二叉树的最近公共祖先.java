package leetcode.editor.cn;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1535 👎 0

import java.util.LinkedList;

class _236_二叉树的最近公共祖先 {
    public static void main(String[] args) {
        Solution solution = new _236_二叉树的最近公共祖先().new Solution();
        TreeNode _6 = new TreeNode(6, null, null);

        TreeNode _7 = new TreeNode(7, null, null);
        TreeNode _4 = new TreeNode(4, null, null);
        TreeNode _2 = new TreeNode(2, _7, _4);
        TreeNode _5 = new TreeNode(5, _6, _2);


        TreeNode _8 = new TreeNode(8, null, null);
        TreeNode _0 = new TreeNode(0, null, null);
        TreeNode _1 = new TreeNode(1, _0, _8);

        TreeNode _3 = new TreeNode(3, _5, _1);

        TreeNode ans = solution.lowestCommonAncestor(_3, _5, _1);
        return;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        int count = 0;
        TreeNode r = null;
        LinkedList<TreeNode> ss = new LinkedList<>();
        LinkedList<TreeNode> cs = new LinkedList<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            LinkedList<TreeNode> s1 = new LinkedList<>();
            LinkedList<TreeNode> s2 = new LinkedList<>();

            r = root;
            push();
            while (!cs.isEmpty()) {
                TreeNode c = cs.peek();
                if (ss.peek() != c) {
                    ss.push(c);
                    if (c == p || c == q) {
                        count++;
                        if (count == 1) {
                            s1.addAll(ss);
                        } else {
                            s2.addAll(ss);
                            break;
                        }
                    }
                    r = c.left;
                    push();
                    r = c.right;
                    push();
                } else {
                    ss.pop();
                    cs.pop();
                }
            }

            TreeNode ans = null;
            while (s1.peekLast() == s2.peekLast()) {
                ans = s1.peekLast();
                s1.pollLast();
                s2.pollLast();
            }
            return ans;
        }

        void push() {
            if (r != null) {
                cs.push(r);
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}