package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 1057 👎 0

class _494_目标和 {
    public static void main(String[] args) {
        Solution solution = new _494_目标和().new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int ans = solution.findTargetSumWays(nums, target);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] nums = null;

        public int findTargetSumWays(int[] $nums, int target) {
            length = $nums.length;
            nums = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);

            // 2001 是用一部分表示负数
            int[][] dp = new int[length + 1][2001];

            // dp[0][1000] 就是0个元素，和为0的情况是1
            dp[0][1000] = 1;


            for (int i = 1; i <= length; i++) {
                for (int j = 0; j < 2001; j++) {
                    // 如果加上这个数能得到j，那么就需要求dp[i - 1][j - nums[i]]
                    int add = j - nums[i] < 0 ? 0 : dp[i - 1][j - nums[i]];

                    // 如果减去这个数能得到j，那么就需要求dp[i - 1][j + nums[i]]
                    int minus = j + nums[i] > 2000 ? 0 : dp[i - 1][j + nums[i]];

                    dp[i][j] = add + minus;
                }
            }
            return dp[length][target + 1000];
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}