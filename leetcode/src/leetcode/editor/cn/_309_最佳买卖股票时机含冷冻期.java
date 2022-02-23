package leetcode.editor.cn;

//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1050 👎 0

class _309_最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {
        Solution solution = new _309_最佳买卖股票时机含冷冻期().new Solution();
        int[] prices = {1, 2, 3, 0, 2};
        int ans = solution.maxProfit(prices);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] prices = null;

        public int maxProfit(int[] $prices) {
            length = $prices.length;
            prices = new int[length + 1];
            System.arraycopy($prices, 0, prices, 1, length);

            if(length == 1) return 0;

            int[][] dp = new int[2][length + 1];

            dp[0][1] = 0;
            dp[1][1] = -prices[1];
            dp[0][2] = Math.max(dp[0][1], dp[1][1] + prices[2]);
            dp[1][2] = Math.max(dp[1][1], -prices[2]);

            int i = 3;
            while (i <= length) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i]);
                dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 2] - prices[i]);
                i++;
            }

            return Math.max(dp[0][length], dp[1][length]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}