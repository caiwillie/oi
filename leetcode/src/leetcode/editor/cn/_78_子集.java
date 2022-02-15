package leetcode.editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1480 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class _78_子集 {
    public static void main(String[] args) {
        Solution solution = new _78_子集().new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = solution.subsets(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] nums = null;

        int i = 0;
        LinkedList<Integer> cs = new LinkedList<>();
        LinkedList<Integer> ss = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {

            this.length = nums.length;
            this.nums = nums;

            push();
            ans.add(Collections.emptyList());
            while (!cs.isEmpty()) {
                Integer c = cs.peek();
                if (ss.peek() != c) {
                    ss.push(c);
                    addAns();
                    i = c;
                    push();
                } else {
                    ss.pop();
                    cs.pop();
                }
            }

            return ans;
        }

        void push() {
            int j = i;
            while (j++ < length) {
                cs.push(j);
            }
        }

        void addAns() {
            List<Integer> tempList = new ArrayList<>();
            for (int j = ss.size() - 1; j >= 0; j--) {
                tempList.add(nums[ss.get(j) - 1]);
            }
            ans.add(tempList);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}