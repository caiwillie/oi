package leetcode.editor.cn;

//给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。 
//
// 插入排序 算法的步骤: 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表
//中。 
//
// 对链表进行插入排序。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [4,2,1,3]
//输出: [1,2,3,4] 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [-1,5,3,4,0]
//输出: [-1,0,3,4,5] 
//
// 
//
// 提示： 
//
// 
//
// 
// 列表中的节点数在 [1, 5000]范围内 
// -5000 <= Node.val <= 5000 
// 
// Related Topics 链表 排序 👍 483 👎 0

class _147_对链表进行插入排序 {
    public static void main(String[] args) {
        Solution solution = new _147_对链表进行插入排序().new Solution();
        // -1,5,3,4,0
        ListNode _0 = new ListNode(0, null);
        ListNode _4 = new ListNode(4, _0);
        ListNode _3 = new ListNode(3, _4);
        ListNode _5 = new ListNode(5, _3);
        ListNode __1 = new ListNode(-1, _5);
        ListNode ans = solution.insertionSortList(__1);
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
        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
            ListNode cur = head, next = null, p = null, q = null;
            while(cur != null) {
                next = cur.next;
                cur.next = null;

                p = dummy;
                q = dummy.next;

                while(q != null && q.val < cur.val) {
                    p = q;
                    q = q.next;
                }

                p.next = cur;
                if(cur != q) cur.next = q;

                cur = next;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}