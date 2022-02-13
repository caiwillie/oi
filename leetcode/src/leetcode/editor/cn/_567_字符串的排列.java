package leetcode.editor.cn;

//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 567 👎 0

class _567_字符串的排列 {
    public static void main(String[] args) {
        Solution solution = new _567_字符串的排列().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }
            int[] cnt = new int[26];
            for (int i = 0; i < n; ++i) {
                --cnt[s1.charAt(i) - 'a'];
                ++cnt[s2.charAt(i) - 'a'];
            }
            int diff = 0;
            for (int c : cnt) {
                if (c != 0) {
                    ++diff;
                }
            }
            if (diff == 0) {
                return true;
            }
            for (int i = n; i < m; ++i) {
                int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
                if (x == y) {
                    continue;
                }
                if (cnt[x] == 0) {
                    ++diff;
                }
                ++cnt[x];
                if (cnt[x] == 0) {
                    --diff;
                }
                if (cnt[y] == 0) {
                    ++diff;
                }
                --cnt[y];
                if (cnt[y] == 0) {
                    --diff;
                }
                if (diff == 0) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}