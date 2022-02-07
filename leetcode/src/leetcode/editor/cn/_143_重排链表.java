package leetcode.editor.cn;

//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 785 👎 0

import java.util.*;

class _143_重排链表 {
    public static void main(String[] args) {
        Solution solution = new _143_重排链表().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        List<ListNode> list = new ArrayList<>();

        public void reorderList(ListNode head) {
            while(head != null) {
                list.add(head);
                head = head.next;
            }

            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;
            int i = 0, j = list.size() - 1;
            while(i <= j) {
                ListNode n1 = list.get(i);
                current.next = n1;
                if(i < j) {
                    ListNode n2 = list.get(j);
                    n1.next = n2;
                    n2.next = null;
                    current = n2;
                } else {
                    n1.next = null;
                }
                i++;
                j--;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

