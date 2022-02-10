package leetcode.editor.cn;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1127 👎 0

class _416_分割等和子集 {
    public static void main(String[] args) {
        Solution solution = new _416_分割等和子集().new Solution();
        int[] nums = {1, 2, 5};
        boolean ans = solution.canPartition(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int length = 0;
        int[] nums = null;

        public boolean canPartition(int[] $nums) {
            length = $nums.length;
            nums = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);

            // 题目已经说非空数组，可以不做非空判断
            int sum = 0;
            for (int num : $nums) {
                sum += num;
            }
            // 特判：如果是奇数，就不符合要求
            if ((sum & 1) == 1) {
                return false;
            }
            int target = sum / 2;
            // 创建二维状态数组，行：物品索引，列：容量（包括 0）
            boolean[][] dp = new boolean[length + 1][target + 1];

            // 初始化, 其实dp[1][0], dp[2][0], ..., dp[length][0] 都应该初始化为true, 不过可以延迟在flag = dp[i - 1][j]中初始化
            dp[0][0] = true;

            int i = 1;
            while (i <= length) {
                // 空就代表能装下
                int j = 0;
                while (j <= target) {
                    boolean flag = false;
                    if (nums[i] > j) {
                        // 装不下, 只能选择上面dp[i-1][j]的结果
                        flag = dp[i - 1][j];
                    } else {
                        // 能装下，可以不装选择上面dp[i-1][j]的结果，或者选择装dp[i - 1][target - j]
                        flag = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    }
                    dp[i][j] = flag;
                    j++;
                }
                i++;
            }
            return dp[length][target];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}