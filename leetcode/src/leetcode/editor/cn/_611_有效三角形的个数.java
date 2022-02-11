package leetcode.editor.cn;

//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 341 👎 0

import java.util.Arrays;

class _611_有效三角形的个数 {
    public static void main(String[] args) {
        Solution solution = new _611_有效三角形的个数().new Solution();
        int[] nums = {7,0,0,0};
        int ans = solution.triangleNumber(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] nums = null;


        public int triangleNumber(int[] $nums) {
            int ans = 0;
            Arrays.sort($nums);
            length = $nums.length;
            nums = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);

            int i = 1;
            while (i <= length - 2) {
                int j = i + 1;
                while(j <= length - 1) {
                    int target = nums[i] + nums[j];

                    int l = j + 1;
                    int r = length;
                    while (l < r) {
                        int mid = (r + l) / 2;
                        if (target <= nums[mid]) {
                            r = mid;
                        } else {
                            l = mid + 1;
                        }
                    }

                    ans += nums[l] < target ? l - j : l - j - 1;
                    j++;
                }
                i++;
            }


            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}