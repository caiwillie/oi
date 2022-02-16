package leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 940 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class _47_全排列II {
    public static void main(String[] args) {
        Solution solution = new _47_全排列II().new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> ans = solution.permuteUnique(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] nums = null;

        int count = 0;
        boolean used[] = null;
        LinkedList<Integer> cs = new LinkedList<>();
        LinkedList<Integer> ss = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] $nums) {
            Arrays.sort($nums);
            length = $nums.length;
            nums = new int[length + 1];
            used = new boolean[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);
            nums[0] = Integer.MIN_VALUE;

            push();
            while (!cs.isEmpty()) {
                Integer c = cs.peek();
                if (ss.peek() != c) {
                    ss.push(c);
                    // 连续的都设置为used
                    used[c] = true;
                    count++;
                    push();
                } else {
                    if (count == length) {
                        add();
                    }
                    cs.pop();
                    ss.pop();
                    // 连续的都设置为used
                    used[c] = false;
                    count--;
                }
            }

            return ans;
        }

        void push() {
            int i = 1;
            while (i <= length) {
                if (!used[i] && !(!used[i - 1] && nums[i] == nums[i - 1])) {
                    cs.push(i);
                }
                i++;
            }
        }

        void add() {
            List<Integer> tl = new ArrayList<>();
            for (int i = ss.size() - 1; i >= 0; i--) {
                tl.add(nums[ss.get(i)]);
            }
            ans.add(tl);
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}