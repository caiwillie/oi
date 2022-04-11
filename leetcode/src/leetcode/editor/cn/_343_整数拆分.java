package leetcode.editor.cn;

//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics 数学 动态规划 👍 703 👎 0

class _343_整数拆分 {
    public static void main(String[] args) {
        Solution solution = new _343_整数拆分().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            int i = 2;
            while(i <= n) {
                int curMax = 0;
                int j = 1;
                while(j < i) {
                    // i -j 和 dp[i - j] 需要表，比如 3 > 1 * 2， 5 < 3 * 2
                    curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
                    j++;
                }
                dp[i] = curMax;
                i++;
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}