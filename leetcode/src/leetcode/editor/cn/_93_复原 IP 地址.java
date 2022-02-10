package leetcode.editor.cn;

//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序
//或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 👍 789 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _93_复原IP地址 {
    public static void main(String[] args) {
        Solution solution = new _93_复原IP地址().new Solution();
        List<String> ans = solution.restoreIpAddresses("101023");
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int length = 0;
        char[] chars = null;
        LinkedList<Integer> c = new LinkedList<>();
        LinkedList<Integer> s = new LinkedList<>();

        public List<String> restoreIpAddresses(String str) {
            List<String> ans = new ArrayList<>();
            char[] $chars = str.toCharArray();
            length = $chars.length;
            chars = new char[length + 1];
            System.arraycopy($chars, 0, chars, 1, length);

            push(1);
            while (!c.isEmpty()) {
                Integer index = c.peek();
                if (s.isEmpty() || index.compareTo(s.peek()) != 0) {
                    // 不相等说明是第一次
                    s.push(index);
                    push(index + 1);
                } else {
                    if (s.size() == 4) {
                        List<String> temp = new ArrayList<>();
                        int last = 0;
                        for (int i = s.size() - 1; i >= 0; i--) {
                            temp.add(String.copyValueOf(chars, last + 1, s.get(i) - last));
                            last = s.get(i);
                        }

                        ans.add(String.join(".", temp));
                    }
                    c.pop();
                    s.pop();
                }
            }

            return ans;
        }

        void push(int pre) {
            int size = s.size();
            if (size <= 3) {
                int remainSize = 3 - size;
                int cur = pre;
                while (cur <= pre + 2 && cur <= length) {
                    int remain = length - cur;
                    boolean trim = false;
                    if (!(remainSize <= remain && remain <= 3 * remainSize)) {
                        // 不满足剩余条件就剪枝
                        trim = true;
                    } else if (chars[pre] == '0' && cur > pre) {
                        trim = true;
                    } else if (cur == pre + 2) {
                        int num = Integer.parseInt(String.copyValueOf(chars, pre, 3));
                        if (num > 255) {
                            //不满足就跳过
                            trim = true;
                        }
                    }
                    // 放入
                    if (!trim) {
                        c.push(cur);
                    }
                    cur++;
                }
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}