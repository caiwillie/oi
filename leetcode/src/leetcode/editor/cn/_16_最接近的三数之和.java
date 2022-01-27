package leetcode.editor.cn;

//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 1025 👎 0

import java.util.Arrays;

public class _16_最接近的三数之和 {

    public static void main(String[] args) {
        Solution solution = new _16_最接近的三数之和().new Solution();
        int[] nums = {1,1,-1,-1,3};
        int target = -1;
        int ans = solution.threeSumClosest(nums, target);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int abs = Integer.MAX_VALUE;
            int ans = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int left = i + 1, right = nums.length - 1;
                int sum = 0;
                while(left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if(sum > target) {
                        if((sum - target) < abs) {
                            abs = sum - target;
                            ans = sum;
                        }
                        right--;
                    } else {
                        if(target - sum < abs) {
                            abs = target - sum;
                            ans = sum;
                        }
                        left++;
                    }
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}