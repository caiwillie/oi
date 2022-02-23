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

import java.util.Arrays;
import java.util.LinkedList;

class _912_排序数组 {
    public static void main(String[] args) {
        Solution solution = new _912_排序数组().new Solution();
        int[] nums = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        int[] ans = solution.sortArray(nums);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int length = 0;
        int[] nums = null;

        int left = 0, right = 0, mid = 0;
        LinkedList<int[]> cs = new LinkedList<>();
        LinkedList<int[]> ss = new LinkedList<>();

        public int[] sortArray(int[] $nums) {
            length = $nums.length;
            left = 1;
            right = length;
            nums = new int[length + 1];
            System.arraycopy($nums, 0, nums, 1, length);

            push();
            while (!cs.isEmpty()) {
                int[] c = cs.peek();
                if (ss.peek() != c) {
                    ss.push(c);
                    left = c[0];
                    right = c[1];
                    mid = c[2];
                    push();
                } else {
                    ss.pop();
                    cs.pop();
                }
            }

            System.arraycopy(nums, 1, $nums, 0, length);
            return $nums;
        }

        void push() {
            if (left > right) return;
            int l = left, r = right, pivot = nums[left];
            while (l <= r) {
                while (l <= r && nums[l] <= pivot) l++;
                while (l <= r && nums[r] > pivot) r--;
                if (l <= r) {
                    swap(l, r);
                }
            }
            mid = l - 1;
            swap(mid, left);
            cs.push(new int[]{left, mid - 1, mid});
            cs.push(new int[]{mid + 1, right, mid});
        }

        void swap(int a, int b) {
            nums[0] = nums[a];
            nums[a] = nums[b];
            nums[b] = nums[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}