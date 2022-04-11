package leetcode.editor.cn;

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 👍 1583 👎 0

import java.util.ArrayList;
import java.util.List;

class _287_寻找重复数 {
    public static void main(String[] args) {
        Solution solution = new _287_寻找重复数().new Solution();
        int[] nums = {2, 2, 2, 2, 2};
        int ans = solution.findDuplicate(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 利用循环链表
        public int findDuplicate2(int[] nums) {
            int slow = 0;
            int fast = 0;
            slow = nums[slow];
            fast = nums[nums[fast]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            int pre = 0;
            while (pre != slow) {
                pre = nums[pre];
                slow = nums[slow];
            }
            return pre;
        }

        // 利用取余
        public int findDuplicate(int[] nums) {
            int n = nums.length;
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int j = nums[i];
                nums[(j - 1) % n] = nums[(j - 1) % n] + n;
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] > 2 * n) {
                    ans.add(i + 1);
                }
            }
            return ans.get(0);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}