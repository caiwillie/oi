package leetcode.editor.cn;

//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 684 👎 0

import java.util.ArrayList;
import java.util.List;

class _109_有序链表转换二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new _109_有序链表转换二叉搜索树().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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
        List <Integer> list = new ArrayList<>();

        public TreeNode sortedListToBST(ListNode head) {

            while (head != null) { // 将链表节点的值逐个推入数组arr
                list.add(head.val);
                head = head.next;
            }
            // 根据索引start到end的子数组构建子树
            return buildBST(0, list.size() - 1);
        }

        private TreeNode buildBST(int start, int end) {
            if(start > end) return null;
            int mid = (start + end) / 2;
            TreeNode left = buildBST(start, mid - 1);
            TreeNode right = buildBST(mid + 1, end);
            return new TreeNode(list.get(mid), left, right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}