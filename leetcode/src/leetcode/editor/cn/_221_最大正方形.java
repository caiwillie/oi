package leetcode.editor.cn;

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 👍 1029 👎 0

class _221_最大正方形 {
    public static void main(String[] args) {
        Solution solution = new _221_最大正方形().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int n = 0;
        int m = 0;

        public int maximalSquare(char[][] matrix) {

            int maxSide = 0;
            n = matrix.length;
            m = matrix[0].length;

            int[][] dp = new int[n + 1][m + 1];

            int i = 1;

            while (i <= n) {
                int j = 1;
                while (j <= m) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                    j++;
                }
                i++;
            }

            return maxSide * maxSide;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}