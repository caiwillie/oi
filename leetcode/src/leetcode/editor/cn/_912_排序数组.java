package leetcode.editor.cn;

//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 470 👎 0

class _912_排序数组 {
    public static void main(String[] args) {
        Solution solution = new _912_排序数组().new Solution();
        int[] nums = {5, 1, 1, 2, 0, 0};
        solution.sortArray(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int length = 0;
        int[] nums = null;

        public int[] sortArray(int[] $nums) {
            length = $nums.length;
            nums = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);
            quickSort(1, length);
            System.arraycopy(nums, 1, $nums, 0, length);
            return $nums;
        }

        void quickSort(int left, int right) {
            if (left < right) {
                int middle = partition(left, right);
                quickSort(left, middle - 1);
                quickSort(middle + 1, right);
            }
        }

        int partition(int left, int right) {
            int pivot = nums[left];
            while (left < right) {
                while (left < right && nums[right] > pivot) right--;
                if (left < right) {
                    swap(left, right);
                }

                while (left < right && nums[left] <= pivot) left++;
                if (left < right) {
                    swap(left, right);
                }
            }
            return left;
        }

        void swap(int a, int b) {
            nums[0] = nums[a];
            nums[a] = nums[b];
            nums[b] = nums[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}