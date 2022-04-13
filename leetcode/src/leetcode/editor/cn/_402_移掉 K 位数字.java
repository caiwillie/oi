package leetcode.editor.cn;

//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
// Related Topics 栈 贪心 字符串 单调栈 👍 773 👎 0

import java.util.LinkedList;

class _402_移掉K位数字 {
    public static void main(String[] args) {
        Solution solution = new _402_移掉K位数字().new Solution();
        String ans = solution.removeKdigits("10", 1);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            //特殊情况全部删除
            if(num.length() == k){
                return "0";
            }
            char[] s = num.toCharArray();
            LinkedList<Character> stack = new LinkedList<>();
            //遍历数组
            for(Character i : s){
                //移除元素的情况，k--
                while(!stack.isEmpty() && i < stack.peek() && k > 0){
                    stack.pop();
                    k--;
                }
                stack.push(i);
            }
            while(!stack.isEmpty() && k > 0){
                stack.pop();
                k--;
            }

            boolean zeroFlag = true;
            //反转并返回字符串
            StringBuilder str = new StringBuilder();
            for (int i = stack.size() - 1; i >= 0; i--) {
                Character c = stack.get(i);
                if(zeroFlag && c.equals('0')) {
                    // 去掉前导0
                } else {
                    zeroFlag = false;
                    str.append(c);
                }
            }

            return str.length() > 0 ? str.toString() : "0";
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}