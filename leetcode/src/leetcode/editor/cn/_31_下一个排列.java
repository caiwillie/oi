package leetcode.editor.cn;

//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1519 👎 0

import java.util.Arrays;

class _31_下一个排列 {
    public static void main(String[] args) {
        Solution solution = new _31_下一个排列().new Solution();
        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length  = 0;
        int[] nums = null;

        public void nextPermutation(int[] $nums) {
            length = $nums.length;
            nums = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);

            boolean find = false;
            // 从后往前找到第一个不是升序的位置
            for (int i = length; i >= 2; i--) {
                if (nums[i] > nums[i - 1]) {
                    // 找到比这个位置大的最小值， 然后交换
                    for (int j = length; j >= i; j--) {
                        if (nums[j] > nums[i - 1]) {    //找到最右边大于nums[i-1]的数，并交换
                            int tmp = nums[i - 1];
                            nums[i - 1] = nums[j];
                            nums[j] = tmp;
                            break;
                        }
                    }
                    // 将这个位置后面的数组倒序
                    Arrays.sort(nums, i, length + 1);      //将后面降序变为升序
                    find = true;
                    break;
                }
            }

            if(!find) {
                // 如果前面没找到，说明已经是最大值

                Arrays.sort(nums);
            }

            System.arraycopy(nums, 1, $nums, 0, length);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}