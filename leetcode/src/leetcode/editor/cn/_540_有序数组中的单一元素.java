package leetcode.editor.cn;

//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。 
//
// 请你找出并返回只出现一次的那个数。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 497 👎 0

class _540_有序数组中的单一元素 {
    public static void main(String[] args) {
        Solution solution = new _540_有序数组中的单一元素().new Solution();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int ans = solution.singleNonDuplicate(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int l = 0;
            int r = nums.length - 1;

            while (l < r) {
                int mid = (l + r) / 2;
                int num = nums[mid];

                if(mid % 2 == 0) {
                    // 中点两侧是偶数
                    if (num == nums[mid - 1]) {
                        r = mid;
                    } else if (num == nums[mid + 1]) {
                        l = mid;
                    } else {
                        l = mid;
                        break;
                    }
                } else {
                    // 中点两侧是奇数
                    if (num == nums[mid - 1]) {
                        l = mid + 1;
                    } else if (num == nums[mid + 1]) {
                        r = mid - 1;
                    } else {
                        l = mid;
                        break;
                    }
                }
            }

            return nums[l];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}