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
import java.util.LinkedList;
import java.util.List;

class _47_全排列II {
    public static void main(String[] args) {
        Solution solution = new _47_全排列II().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] nums = null;


        int i = 0;
        LinkedList<Integer> cs = new LinkedList<>();
        LinkedList<Integer> ss = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            this.length = nums.length;
            this.nums = nums;

            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}