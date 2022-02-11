package leetcode.editor.cn;

//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
// Related Topics 树状数组 线段树 数组 动态规划 👍 545 👎 0

class _673_最长递增子序列的个数 {
    public static void main(String[] args) {
        Solution solution = new _673_最长递增子序列的个数().new Solution();
        int[] nums = {2, 2, 2, 2, 2};
        int ans = solution.findNumberOfLIS(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] nums = null;

        public int findNumberOfLIS(int[] $nums) {
            int ans = 0;
            int max = 0;

            length = $nums.length;
            nums = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);

            nums[0] = Integer.MIN_VALUE;
            int[] dp = new int[length + 1];
            int[] counts = new int[length + 1];

            counts[0] = 1;

            int i = 1;
            while (i <= length) {
                int j = 0;
                int curCount = 0;
                int curMax = 0;
                while (j < i) {
                    if (nums[j] < nums[i]) {
                        if (dp[j] + 1 > curMax) curCount = counts[j];
                        else if (dp[j] + 1 == curMax) curCount += counts[j];
                        curMax = Math.max(curMax, dp[j] + 1);
                    }
                    j++;
                }
                dp[i] = curMax;
                counts[i] = curCount;
                if (dp[i] > max) ans = counts[i];
                else if (dp[i] == max) ans += counts[i];
                max = Math.max(max, dp[i]);
                i++;
            }

            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}