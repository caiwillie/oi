package leetcode.editor.cn;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1463 👎 0

import java.util.LinkedList;

class _215_数组中的第K个最大元素 {
    public static void main(String[] args) {
        Solution solution = new _215_数组中的第K个最大元素().new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int ans = solution.findKthLargest(nums, 2);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int k = 0;
        int length = 0;
        int[] nums = null;

        int left = 0, right = 0, mid = -1;
        LinkedList<int[]> cs = new LinkedList<>();
        LinkedList<int[]> ss = new LinkedList<>();

        public int findKthLargest(int[] $nums, int $k) {
            length = $nums.length;
            k = $k;
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
                    if (c[2] == length - (k - 1)) {
                        return nums[c[2]];
                    }
                    ss.pop();
                    cs.pop();
                }
            }

            return 0;
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
            if (mid <= length - (k - 1)) {
                cs.push(new int[]{mid + 1, right, mid});
            } else {
                cs.push(new int[]{left, mid - 1, mid});
            }
        }

        void swap(int a, int b) {
            nums[0] = nums[a];
            nums[a] = nums[b];
            nums[b] = nums[0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}