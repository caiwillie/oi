package leetcode.editor.cn;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1742 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class _46_全排列 {
    public static void main(String[] args) {
        Solution solution = new _46_全排列().new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = solution.permute(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] nums = null;

        int count = 0;
        boolean[] used = null;
        LinkedList<Integer> cs = new LinkedList<>();
        LinkedList<Integer> ss = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            Arrays.sort(nums);
            this.length = nums.length;
            this.nums = nums;
            used = new boolean[length];

            push();
            while(!cs.isEmpty()) {
                Integer c = cs.peek();
                if(ss.peek() != c) {
                    // 方法进入
                    ss.push(c);
                    used[c] = true;
                    count++;
                    push();
                } else {
                    // 方法退出
                    if(count == length) {
                        add();
                    }
                    ss.pop();
                    cs.pop();
                    used[c] = false;
                    count--;
                }
            }
            return ans;
        }

        void push() {
            int i = 0;
            while(i < length) {
                if(!used[i]) {
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