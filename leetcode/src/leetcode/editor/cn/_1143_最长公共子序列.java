package leetcode.editor.cn;

//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
// Related Topics 字符串 动态规划 👍 834 👎 0

class _1143_最长公共子序列 {
    public static void main(String[] args) {
        Solution solution = new _1143_最长公共子序列().new Solution();
        int ans = solution.longestCommonSubsequence("abcde", "ace");
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length1 = 0;
        char[] chars1 = null;
        int length2 = 0;
        char[] chars2 = null;
        public int longestCommonSubsequence(String text1, String text2) {
            length1 = text1.length();
            chars1 = new char[length1 + 1];
            System.arraycopy(text1.toCharArray(), 0, chars1, 1, length1);

            length2 = text2.length();
            chars2 = new char[length2 + 1];
            System.arraycopy(text2.toCharArray(), 0, chars2, 1, length2);

            int dp[][] = new int[length1 + 1][length2 + 1];

            int i = 1;
            while(i <= length1) {
                int j = 1;
                while(j <= length2) {
                    if(chars1[i] == chars2[j]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
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