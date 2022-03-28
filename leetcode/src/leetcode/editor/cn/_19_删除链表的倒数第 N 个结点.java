package leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 1777 👎 0

import java.util.ArrayList;
import java.util.List;

class _19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        Solution solution = new _19_删除链表的倒数第N个结点().new Solution();
/*        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);*/
        ListNode l3 = new ListNode(3, null);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        solution.removeNthFromEnd(l1, 3);

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1, head);
            ListNode slow = dummy, fast = head, pre = null;
            int dif = 1;
            while (fast != null) {
                fast = fast.next;
                if (dif < n) {
                    dif++;
                } else {
                    pre = slow;
                    slow = slow.next;
                }
            }

            if (pre != null) pre.next = slow.next;

            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}