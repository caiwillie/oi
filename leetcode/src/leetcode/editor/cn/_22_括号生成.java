package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2327 👎 0

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {
    public static void main(String[] args) {
        Solution solution = new _22_括号生成().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            backtrack(new StringBuilder(), 0, 0, n);
            return ans;
        }

        public void backtrack(StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrack(cur, open + 1, close, max);
                // 删除指定位置的字符
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}