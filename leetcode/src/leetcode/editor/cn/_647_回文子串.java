package leetcode.editor.cn;

//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 776 👎 0

class _647_回文子串 {
    public static void main(String[] args) {
        Solution solution = new _647_回文子串().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        char[] chars = null;

        public int countSubstrings(String s) {
            int ans = 0;
            length = s.length();
            chars = new char[length + 1];
            System.arraycopy(s.toCharArray(), 0, chars, 1, length);
            boolean[][] dp = new boolean[length + 1][length + 1];

            // 遍历顺序不一样
            for (int i = length; i >= 1; --i) {
                for (int j = i; j <= length; ++j) {
                    // i + 1 > j - 1, 说明个数是1个或者2个
                    dp[i][j] = (chars[i] == chars[j]) && (i + 1 > j - 1 || dp[i + 1][j - 1]);

                    if(dp[i][j]) ans++;
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}