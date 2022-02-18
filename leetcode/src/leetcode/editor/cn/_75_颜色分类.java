package leetcode.editor.cn;

//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库的sort函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 👍 1162 👎 0

class _75_颜色分类 {
    public static void main(String[] args) {
        Solution solution = new _75_颜色分类().new Solution();
        int[] nums = {0, 0};
        solution.sortColors(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void sortColors(int[] nums) {
            int length = nums.length;
            int l = 0, r = length - 1;

            int count0 = 0;
            int count1 = 0;

            int temp = 0;

            while (l < r) {
                while (l <= length - 1 && nums[l] != 2) {
                    if (nums[l] == 0) {
                        count0++;
                    } else {
                        count1++;
                    }
                    nums[l] = 0;
                    l++;
                }

                while (r >= 0 && nums[r] == 2) {
                    r--;
                }

                // 交换
                if(l < r) {
                    temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                }
            }

            for (int i = count0; i < count0 + count1; i++) {
                nums[i] = 1;
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}