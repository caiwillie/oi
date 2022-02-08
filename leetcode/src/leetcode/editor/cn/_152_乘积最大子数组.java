package leetcode.editor.cn;

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 👍 1478 👎 0

class _152_乘积最大子数组 {
    public static void main(String[] args) {
        Solution solution = new _152_乘积最大子数组().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int length = 0;
        int[] nums = null;
        public int maxProduct(int[] $nums) {
            int ans = Integer.MIN_VALUE;

            length = $nums.length;
            nums = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);

            int[] dpMax = new int[length + 1];
            int[] dpMin = new int[length + 1];
            // 相乘不改变大小
            dpMax[0] = 1;
            dpMin[0] = 1;

            for (int i = 1; i <= length ; i++) {
                int max = 0;
                int min = 0;
                if(nums[i] > 0) {
                    // 比0大，就正数乘以正数
                    max = Math.max(dpMax[i - 1] * nums[i], nums[i]);
                    min = Math.min(dpMin[i - 1] * nums[i], nums[i]);
                } else if (nums[i] < 0) {
                    max = Math.max(dpMin[i - 1] * nums[i], nums[i]);
                    min = Math.min(dpMax[i - 1] * nums[i], nums[i]);
                }
                dpMax[i] = max;
                dpMin[i] = min;
                ans = Math.max(dpMax[i], ans);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}