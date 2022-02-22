package leetcode.editor.cn;

//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 双指针 👍 813 👎 0

class _82_删除排序链表中的重复元素II {
    public static void main(String[] args) {
        Solution solution = new _82_删除排序链表中的重复元素II().new Solution();
        // 1,2,3,3,4,4,5
        ListNode _5 = new ListNode(5, null);
        ListNode _4_2 = new ListNode(4, _5);
        ListNode _4_1 = new ListNode(4, _4_2);
        ListNode _3_2 = new ListNode(3, _4_1);
        ListNode _3_1 = new ListNode(3, _3_2);
        ListNode _2 = new ListNode(2, _3_1);
        ListNode _1 = new ListNode(1, _2);

        ListNode ans = solution.deleteDuplicates(_1);
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1, head);
            ListNode g = dummy, f = dummy, cur = head;
            while(cur != null) {
                ListNode next = cur.next;
                if(next != null && next.val == cur.val) {

                } else {
                    if(f.next == cur) {
                        g.next = cur;
                        f = cur;
                        g = f;
                    } else {
                        f = cur;
                    }

                }
                cur = next;
            }
            // 这一行非常重要
            g.next = cur;

            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}