package leetcode.editor.cn;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 981 👎 0

import java.util.*;

class _131_分割回文串 {
    public static void main(String[] args) {
        Solution solution = new _131_分割回文串().new Solution();
        List<List<String>> ans = solution.partition("aab");
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String str = null;
        boolean[][] f;
        List<List<String>> ans = new ArrayList<>();

        int i = 0;
        LinkedList<String> ss = new LinkedList<>();
        LinkedList<String> cs = new LinkedList<>();
        int n;

        public List<List<String>> partition(String str) {
            this.str = str;
            n = str.length();
            f = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(f[i], true);
            }
            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    f[i][j] = (str.charAt(i) == str.charAt(j)) && f[i + 1][j - 1];
                }
            }

            push();
            while (!cs.isEmpty()) {
                String c = cs.peek();
                if (ss.peek() != c) {
                    ss.push(c);
                    // 向下搜索
                    i = i + c.length();
                    push();
                } else {
                    if (i == n) {
                        ArrayList<String> temp = new ArrayList<>(ss);
                        Collections.reverse(temp);
                        ans.add(temp);
                    }
                    cs.pop();
                    ss.pop();
                    // 回溯
                    i = i - c.length();
                }
            }

            return ans;
        }

        void push() {
            int j = i;
            while (j < n) {
                if (f[i][j]) {
                    cs.push(str.substring(i, j + 1));
                }
                j++;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}