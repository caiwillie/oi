package leetcode.editor.cn;

//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 844 👎 0

import java.util.LinkedList;

class _581_最短无序连续子数组 {
    public static void main(String[] args) {
        Solution solution = new _581_最短无序连续子数组().new Solution();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int ans = solution.findUnsortedSubarray(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> tempStack = new LinkedList<>();

        public int findUnsortedSubarray(int[] nums) {

            // 单调栈从前往后遍历一遍可得到左边界
            // 单调栈从后往前遍历一遍可得到右边界
            LinkedList<Integer> stack = new LinkedList<>();
            int left = nums.length;
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                    left = Math.min(left, stack.pop());
                }
                stack.push(i);
            }
            stack.clear();
            int right = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    right = Math.max(right, stack.pop());
                }
                stack.push(i);
            }
            return right - left > 0 ? right - left + 1 : 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}