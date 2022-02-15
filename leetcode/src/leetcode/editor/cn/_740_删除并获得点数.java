package leetcode.editor.cn;

//给你一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 哈希表 动态规划 👍 546 👎 0

import java.util.Arrays;

class _740_删除并获得点数 {
    public static void main(String[] args) {
        Solution solution = new _740_删除并获得点数().new Solution();
        int[] nums = {1};
        solution.deleteAndEarn(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        // 相同大小的元素相加和放入到另外一个数组中
        public int deleteAndEarn(int[] nums) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(num, max);
            }

            int[] dp = new int[max + 1];
            int[] count = new int[max + 1];

            for (int num : nums) {
                count[num] = count[num] + num;
            }

            int i = 1;
            while (i <= max) {
                dp[i] = Math.max(dp[i - 1], (i < 2 ? 0 : dp[i - 2]) + count[i]);
                i++;
            }

            return dp[max];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}