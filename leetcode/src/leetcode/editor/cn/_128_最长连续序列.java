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

public class _128_最长连续序列 {
    public static void main(String[] args) {
        Solution solution = new _128_最长连续序列().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int length = 0;
        int[] nums = null;


        public int longestConsecutive(int[] $nums) {
            length = $nums.length;
            nums = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);
            // 初始话第一个节点为极大值
            nums[0] = Integer.MAX_VALUE;
            int i = 1;
            while(i <= length) {
                if(i > nums[i - 1]) {

                }
            }
            return 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}