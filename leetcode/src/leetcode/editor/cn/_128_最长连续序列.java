package leetcode.editor.cn;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 1069 👎 0

import java.util.HashSet;
import java.util.Set;

public class _128_最长连续序列 {
    public static void main(String[] args) {
        Solution solution = new _128_最长连续序列().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            // 建立一个存储所有数的哈希表，同时起到去重功能
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int ans = 0;
            // 遍历所有数字，已经经过去重
            for (int num : set) {
                int cur = num;
                // 只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3......
                if (!set.contains(cur - 1)) {
                    while (set.contains(cur + 1)) {
                        cur++;
                    }
                }
                // [num, cur]之间是连续的，数字有cur - num + 1个
                ans = Math.max(ans, cur - num + 1);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}