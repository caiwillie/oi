package leetcode.editor.cn;

//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 栈 数组 单调栈 👍 586 👎 0

import java.util.Arrays;
import java.util.LinkedList;

class _503_下一个更大元素II {
    public static void main(String[] args) {
        Solution solution = new _503_下一个更大元素II().new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int[] ans = solution.nextGreaterElements(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int peekIndex = 0;
        int index = 1;
        int length = 0;
        int[] nums = null;
        LinkedList<Integer> s = new LinkedList<>();
        int[] ans = null;

        public int[] nextGreaterElements(int[] $nums) {
            length = $nums.length;
            nums = new int[length + 1];
            ans = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);
            // 确保比所有的值大
            nums[0] = Integer.MAX_VALUE;

            while (true) {
                while (nums[index] > nums[peekIndex = s.peek() == null ? 0 : s.peek()]) {
                    // 如果大于
                    Integer temp = s.pop();
                    ans[temp] = nums[index];
                }

                int last = s.peekLast() == null ? 0 : s.peekLast();
                if(index == last) {
                    while(!s.isEmpty()) {
                        ans[s.pop()] = -1;
                    }
                    break;
                } else {
                    s.push(index);
                    if (index == length) {
                        index = 1;
                    } else {
                        index++;
                    }
                }
            }

            return Arrays.copyOfRange(ans, 1, ans.length);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}