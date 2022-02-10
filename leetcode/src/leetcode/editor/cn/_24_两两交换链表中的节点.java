package leetcode.editor.cn;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1230 👎 0

class _24_两两交换链表中的节点 {
    public static void main(String[] args) {
        Solution solution = new _24_两两交换链表中的节点().new Solution();

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
        public ListNode swapPairs(ListNode head) {
            return reverseKGroup(head, 2);
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1, head);
            ListNode g = dummy;
            ListNode cur = g.next;

            int i = 1;
            while(cur != null && i <= k) {
                cur = cur.next;
                if(i == k) {
                    // 这里cur被重置，在下面的while循环中会恢复
                    ListNode pre = null; cur = g.next;
                    while(i >= 1) {
                        ListNode next = cur.next;
                        cur.next = pre;
                        pre = cur;
                        cur = next;
                        i--;
                    }
                    ListNode nextG = g.next;
                    nextG.next = cur;
                    g.next = pre;
                    g = nextG;
                }
                i++;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}