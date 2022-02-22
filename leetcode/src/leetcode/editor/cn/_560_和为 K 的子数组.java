package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1299 👎 0

import java.util.HashMap;

class _560_和为K的子数组 {
    public static void main(String[] args) {
        Solution solution = new _560_和为K的子数组().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            //细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
            //例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
            //输入：[3,1,1,0] k = 2时则不会漏掉
            //因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
            map.put(0, 1);
            int count = 0;
            int presum = 0;
            for (int x : nums) {
                presum += x;
                //当前前缀和已知，判断是否含有 presum - k的前缀和，那么我们就知道某一区间的和为 k 了。
                if (map.containsKey(presum - k)) {
                    count += map.get(presum - k);//获取次数
                }
                //更新
                map.put(presum, map.getOrDefault(presum, 0) + 1);
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}