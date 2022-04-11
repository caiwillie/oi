package leetcode.editor.cn;

//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 10⁴ 
// 1 <= houses[i], heaters[i] <= 10⁹ 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 371 👎 0

import java.util.Arrays;

class _475_供暖器 {
    public static void main(String[] args) {
        Solution solution = new _475_供暖器().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int ans = 0;
            int i = 0, j = 0;
            while (i < houses.length) {
                int curDistance = Math.abs(houses[i] - heaters[j]);

                while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                    // 如果没到最后一个，并且当前加热器到当前房屋的距离 比 下个加热器到当前房屋的距离远，就移动到下一个加热器
                    j++;
                }

                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
                ans = Math.max(ans, curDistance);
                i++;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}