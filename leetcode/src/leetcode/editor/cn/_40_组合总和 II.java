package leetcode.editor.cn;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 829 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class _40_组合总和II {
    public static void main(String[] args) {
        Solution solution = new _40_组合总和II().new Solution();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ans = solution.combinationSum2(nums, target);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] nums = null;

        int target = 0;
        int sum = 0;
        int i = 0;
        LinkedList<Integer> ss = new LinkedList<>();
        LinkedList<Integer> cs = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            this.length = candidates.length;
            this.nums = candidates;
            this.target = target;

            Arrays.sort(candidates);

            push();
            while (!cs.isEmpty()) {
                Integer c = cs.peek();
                if (ss.peek() != c) {
                    ss.push(c);
                    sum = sum + nums[c];
                    i = c + 1;
                    push();
                } else {
                    if (sum == target) {
                        add();
                    }
                    cs.pop();
                    ss.pop();
                    sum = sum - nums[c];
                }
            }
            return ans;
        }

        void push() {
            int j = i;
            int last = 0;
            while (j < length) {
                if (sum + nums[j] <= target && nums[j] != last) {
                    cs.push(j);
                    last = nums[j];
                }
                j++;
            }
        }

        void add() {
            List<Integer> tl = new ArrayList<>();
            for (int j = ss.size() - 1; j >= 0; j--) {
                tl.add(nums[ss.get(j)]);
            }
            ans.add(tl);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}