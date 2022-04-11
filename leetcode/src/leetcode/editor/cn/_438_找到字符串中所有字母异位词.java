package leetcode.editor.cn;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 776 👎 0

import java.util.ArrayList;
import java.util.List;

class _438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        Solution solution = new _438_找到字符串中所有字母异位词().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();

            int m = s.length();
            int n = p.length();
            if (m < n) {
                return ans;
            }

            int[] cnt = new int[26];
            // diff记录的是差异的字符类别数，不是字符个数
            int diff = 0;

            for (int i = 0; i < n; i++) {
                cnt[p.charAt(i) - 'a']--;
                cnt[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (cnt[i] != 0) {
                    // 统计差异数
                    diff++;
                }
            }
            if (diff == 0) {
                ans.add(0);
            }
            for (int i = 0; i < m - n; i++) {
                cnt[s.charAt(i) - 'a']--;
                if (cnt[s.charAt(i) - 'a'] == 0) {
                    // 移除窗口左边的字符后，这个字符的词频数变成了0，diff减1
                    diff--;
                } else if (cnt[s.charAt(i) - 'a'] == -1) {
                    // 这个字符的词频数变成-1，说明原来是0，diff加1
                    diff++;
                }
                cnt[s.charAt(i + n) - 'a']++;
                if (cnt[s.charAt(i + n) - 'a'] == 1) {
                    // 增加窗口右边的字符后，这个字符的词频数变成了1，diff加1
                    diff++;
                } else if (cnt[s.charAt(i + n) - 'a'] == 0) {
                    // 这个字符的词频数变成0，说明原来是-1，diff减1
                    diff--;
                }
                if (diff == 0) {
                    // 注意，diff统计的是差异的字符类别，等于0说明不存在差异的字符，可以直接加入答案
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}