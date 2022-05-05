package leetcode.editor.cn;

//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
// Related Topics 位运算 数组 👍 596 👎 0

class _260_只出现一次的数字III {
    public static void main(String[] args) {
        Solution solution = new _260_只出现一次的数字III().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            int xorsum = 0;
            for (int num : nums) {
                xorsum ^= num;
            }

            // 综上，可以通过获取最低有效位把两个数分开

            // 防止溢出
            // 因为二进制有正负0，负零用于多表示一位负数，这个负数如果取相反数，会产生溢出，所以不能用 a & (-a) 取最低有效位
            // 负0的特点是第一位是1，其余位是0，所以它的最低有效位就是自己
            // MIN_VALUE 的特点就是最高位是1
            int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
            int type1 = 0, type2 = 0;
            for (int num : nums) {
                if ((num & lsb) != 0) {
                    type1 ^= num;
                } else {
                    type2 ^= num;
                }
            }
            return new int[]{type1, type2};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}