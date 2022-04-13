package leetcode.editor.cn;

//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 613 👎 0

class _718_最长重复子数组 {
    public static void main(String[] args) {
        Solution solution = new _718_最长重复子数组().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 动态规划方法

        int length1 = 0;
        int[] nums1 = null;
        int length2 = 0;
        int[] nums2 = null;

        public int findLength(int[] $nums1, int[] $nums2) {
            int ans = 0;

            length1 = $nums1.length;
            nums1 = new int[length1 + 1];
            System.arraycopy($nums1, 0, nums1, 1, length1);

            length2 = $nums2.length;
            nums2 = new int[length2 + 1];
            System.arraycopy($nums2, 0, nums2, 1, length2);

            int dp[][] = new int[length1 + 1][length2 + 2];

            int i = 1;
            while(i <= length1) {
                int j = 1;
                while(j <= length2) {
                    if(nums1[i] == nums2[j]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        ans = Math.max(ans, dp[i][j]);
                    } else {
                        dp[i][j] = 0;
                    }
                    j++;
                }
                i++;
            }
            return ans;
        }

        // 可以考虑滑动窗口
    }
    //leetcode submit region end(Prohibit modification and deletion)

}