package leetcode.editor.cn;

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1536 👎 0

class _96_不同的二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new _96_不同的二叉搜索树().new Solution();
        int ans = solution.numTrees(3);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                int count = 0;
                for (int j = 1; j <= i ; j++) {
                    count += dp[j - 1] * dp[i - j];
                }
                dp[i] = count;
            }
            return dp[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}