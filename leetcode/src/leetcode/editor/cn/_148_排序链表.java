package leetcode.editor.cn;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1459 👎 0

class _148_排序链表 {
    public static void main(String[] args) {
        Solution solution = new _148_排序链表().new Solution();
        // 4,2,1,3
        ListNode _4 = new ListNode(3, null);
        ListNode _3 = new ListNode(1, _4);
        ListNode _2 = new ListNode(2, _3);
        ListNode _1 = new ListNode(4, _2);

        ListNode ans = solution.sortList(_1);
        return;
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
        public ListNode sortList(ListNode head) {
            int length = 0;
            ListNode node = head;
            while (node != null) {
                length++;
                node = node.next;
            }
            ListNode dummy = new ListNode(-1, head);
            for (int subLength = 1; subLength < length; subLength = 2 * subLength) {
                ListNode g = dummy, cur = dummy.next;
                while (cur != null) {
                    ListNode head1 = cur;
                    ListNode pre = null;
                    for (int i = 1; i <= subLength && cur != null; i++) {
                        pre = cur;
                        cur = cur.next;
                    }
                    pre.next = null;

                    pre = null;
                    ListNode head2 = cur;

                    for (int i = 1; i <= subLength && cur != null; i++) {
                        pre = cur;
                        cur = cur.next;
                    }
                    if (pre != null) pre.next = null;

                    ListNode merged = merge(head1, head2);
                    g.next = merged;
                    while (g.next != null) {
                        g = g.next;
                    }
                }
            }
            return dummy.next;
        }

        ListNode merge(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy, p = list1, q = list2;
            while (p != null && q != null) {
                if (p.val <= q.val) {
                    cur.next = p;
                    p = p.next;
                } else {
                    cur.next = q;
                    q = q.next;
                }
                cur = cur.next;
            }
            if (p != null) {
                cur.next = p;
            } else if (q != null) {
                cur.next = q;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}