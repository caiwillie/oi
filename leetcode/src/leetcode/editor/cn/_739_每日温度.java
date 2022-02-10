package leetcode.editor.cn;

//请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 👍 1011 👎 0

import java.util.LinkedList;

class _739_每日温度 {
    public static void main(String[] args) {
        Solution solution = new _739_每日温度().new Solution();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        solution.dailyTemperatures(temperatures);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        LinkedList<Integer> stack = new LinkedList<>();

        public int[] dailyTemperatures(int[] temperatures) {
            int length = temperatures.length;

            int[] ans = new int[length];
            int i = 0;
            while(i < length) {
                int temperature = temperatures[i];
                while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                    Integer pre = stack.pop();
                    ans[pre] = i - pre;
                }
                stack.push(i);
                i++;
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}