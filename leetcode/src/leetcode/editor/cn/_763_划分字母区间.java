package leetcode.editor.cn;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心 哈希表 双指针 字符串 👍 660 👎 0

import java.util.ArrayList;
import java.util.List;

class _763_划分字母区间 {
    public static void main(String[] args) {
        Solution solution = new _763_划分字母区间().new Solution();
        List<Integer> ans = solution.partitionLabels("ababcbacadefegdehijhklij");
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        char[] chars = null;

        public List<Integer> partitionLabels(String s) {
            List<Integer> ans = new ArrayList<>();

            length = s.length();
            chars = new char[length + 1];
            System.arraycopy(s.toCharArray(), 0, chars, 1, length);

            int i = 1, max = 1, pre = 0;
            while (i <= length) {
                int j = length;

                while (j > max) {
                    if (chars[j] == chars[i]) {
                        max = j;
                        break;
                    }
                    j--;
                }

                if(i == max) {
                    ans.add(i - pre);
                    pre = i;
                    max++;
                }

                i++;
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}