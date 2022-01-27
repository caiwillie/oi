package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6817 👎 0

/*
abcabcbb
abcabcbb

* */

import java.util.HashMap;
import java.util.HashSet;

public class _3_无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution solution = new _3_无重复字符的最长子串().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            HashSet<Character> set = new HashSet<>();
            int max = 0;
            int left = 0, right = 0; // 左右指针
            char[] chars = s.toCharArray();
            for (; right < chars.length; right++) {
                char c = chars[right];
                while (left < right && set.contains(c)) {
                    // 如果发现当前字符已经存在，从left开始逐个往前删除
                    set.remove(chars[left++]);
                }
                set.add(c);
                max = Math.max(max, right - left + 1);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}