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
        List<List<Integer>> lists = solution.permute(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int length = nums.length;
            int[] used = new int[length];
            LinkedList<Integer> s = new LinkedList<>();
            LinkedList<Integer> c = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                c.push(i);
            }

            while(!c.isEmpty()) {
                Integer index = c.peek();
                if(used[index] == 0) {
                    // 方法进入
                    used[index] = 1;
                    s.push(nums[index]);
                    for (int i = 0; i < length; i++) {
                        if(used[i] == 0) {
                            c.push(i);
                        }
                    }
                } else {
                    // 方法退出
                    c.pop();
                    used[index] = 0;
                    if(s.size() == length) {
                        ans.add(new ArrayList<>(s));
                    }
                    s.pop();
                }
            }
            return ans;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}