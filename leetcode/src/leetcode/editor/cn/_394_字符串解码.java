package leetcode.editor.cn;

//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// s 由小写英文字母、数字和方括号 '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为 [1, 300] 
// 
// Related Topics 栈 递归 字符串 👍 1022 👎 0

import java.util.LinkedList;

class _394_字符串解码 {
    public static void main(String[] args) {
        Solution solution = new _394_字符串解码().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            StringBuilder content = new StringBuilder();
            int multi = 0;
            LinkedList<Integer> stackMulti = new LinkedList<>();
            LinkedList<String> stackContent = new LinkedList<>();
            for(Character c : s.toCharArray()) {
                if(c == '[') {
                    stackMulti.push(multi);
                    stackContent.push(content.toString());
                    multi = 0;
                    content = new StringBuilder();
                }
                else if(c == ']') {
                    StringBuilder tmp = new StringBuilder();
                    int lastMulti = stackMulti.pop();
                    // 当前文本内容累乘
                    for(int i = 0; i < lastMulti; i++) tmp.append(content);
                    // 累乘内容 加上 上一个数组前，在'['后的内容
                    String lastContent = stackContent.pop();
                    content = new StringBuilder(lastContent + tmp);
                }
                else if(c >= '0' && c <= '9') {
                    // 乘数
                    multi = multi * 10 + c - '0';
                } else {
                    // 字符串
                    content.append(c);
                }
            }
            return content.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}