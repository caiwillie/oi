package leetcode.editor.cn;

//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 722 👎 0

class _516_最长回文子序列 {
    public static void main(String[] args) {
        Solution solution = new _516_最长回文子序列().new Solution();
        int ans = solution.longestPalindromeSubseq("bbbab");
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        char[] chars = null;

        public int longestPalindromeSubseq(String s) {
            length = s.length();
            chars = new char[length + 1];
            System.arraycopy(s.toCharArray(), 0, chars, 1, length);

            int[][] dp = new int[length + 1][length + 1];

            int i = length;
            while(i >= 1) {
                int j = i;
                while(j <= length) {
                    if(chars[i] == chars[j]) {
                        // i + 1 > j - 1，就说明1个和2个的序列，直接进行计算，否则可能会下标越界
                        dp[i][j] = i + 1 > j - 1 ? j - i + 1 : dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                    j++;
                }
                i--;
            }

            return dp[1][length];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}