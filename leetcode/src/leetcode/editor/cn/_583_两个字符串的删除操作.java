package leetcode.editor.cn;

//给定两个单词 word1 和 word2 ，返回使得 word1 和 word2 相同所需的最小步数。 
//
// 每步 可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例 1： 
//
// 
//输入: word1 = "sea", word2 = "eat"
//输出: 2
//解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
// 
//
// 示例 2: 
//
// 
//输入：word1 = "leetcode", word2 = "etco"
//输出：4
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 和 word2 只包含小写英文字母 
// 
// Related Topics 字符串 动态规划 👍 402 👎 0

class _583_两个字符串的删除操作 {
    public static void main(String[] args) {
        Solution solution = new _583_两个字符串的删除操作().new Solution();
        int ans = solution.minDistance("a", "b");
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int length1 = 0;
        char[] chars1 = null;
        int length2 = 0;
        char[] chars2 = null;

        public int minDistance(String word1, String word2) {
            length1 = word1.length();
            chars1 = new char[length1 + 1];
            System.arraycopy(word1.toCharArray(), 0, chars1, 1, length1);

            length2 = word2.length();
            chars2 = new char[length2 + 1];
            System.arraycopy(word2.toCharArray(), 0, chars2, 1, length2);

            int dp[][] = new int[length1 + 1][length2 + 1];

            // 初始化
            for (int i = 1; i <= length1; i++) {
                dp[i][0] = i;
            }

            for (int j = 1; j <= length2; j++) {
                dp[0][j] = j;
            }

            int i = 1;
            while(i <= length1) {
                int j = 1;
                while(j <= length2) {
                    if(chars1[i] == chars2[j]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                    }
                    j++;
                }
                i++;
            }
            return dp[length1][length2];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}