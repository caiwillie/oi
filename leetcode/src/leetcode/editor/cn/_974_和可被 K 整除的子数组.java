package leetcode.editor.cn;

//给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。 
//
// 子数组 是数组的 连续 部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,0,-2,-3,1], k = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 k = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 示例 2: 
//
// 
//输入: nums = [5], k = 9
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 2 <= k <= 10⁴ 
// 
// Related Topics 数组 哈希表 前缀和 👍 343 👎 0

import java.util.HashMap;
import java.util.Map;

class _974_和可被K整除的子数组 {
    public static void main(String[] args) {
        Solution solution = new _974_和可被K整除的子数组().new Solution();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int ans = solution.subarraysDivByK(nums, k);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            int count = 0;
            int pre = 0;

            for (int num : nums) {
                pre = pre + num;

                // 如果 pre % k 小于 0, 就加上k 再取余数
                int mod = (pre % k + k) % k;

                if(map.containsKey(mod)) {
                    count += map.get(mod);
                }

                map.put(mod, map.getOrDefault(mod, 0) + 1);
            }

            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}