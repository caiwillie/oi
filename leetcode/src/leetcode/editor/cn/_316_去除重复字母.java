package leetcode.editor.cn;

//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
// Related Topics 栈 贪心 字符串 单调栈 👍 702 👎 0

import java.util.LinkedList;

class _316_去除重复字母 {
    public static void main(String[] args) {
        Solution solution = new _316_去除重复字母().new Solution();
        String ans = solution.removeDuplicateLetters("bcabc");
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            boolean[] vis = new boolean[26];
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            LinkedList<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!vis[ch - 'a']) {
                    // 如果没被选中
                    while (!stack.isEmpty() && stack.peek() > ch) {
                        if (count[stack.peek() - 'a'] > 0) {
                            vis[stack.peek() - 'a'] = false;
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                    vis[ch - 'a'] = true;
                    stack.push(ch);
                }
                // 不管用没用，使用计数减1
                count[ch - 'a'] -= 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = stack.size() - 1; i >= 0; i--) {
                sb.append(stack.get(i));
            }

            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}