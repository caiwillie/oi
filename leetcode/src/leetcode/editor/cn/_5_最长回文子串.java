package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4624 👎 0

class _5_最长回文子串 {
    public static void main(String[] args) {
        Solution solution = new _5_最长回文子串().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] chars = null;

        public String longestPalindrome(String s) {
            chars = s.toCharArray();
            int start = 0, end = 0;
            for (int i = 0; i < chars.length; i++) {
                int len1 = expandAroundCenter(i, i); // 以一个字符为中心向两边扩散，最终的长度是奇数
                int len2 = expandAroundCenter(i, i + 1); // 以二个字符为中心向两边扩散，最终的长度是偶数
                // 算出最长的长度
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(int left, int right) {
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left--;
                right++;
            }
            return right - left - 1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}