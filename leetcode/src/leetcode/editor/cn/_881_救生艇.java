package leetcode.editor.cn;

//给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。 
//
// 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。 
//
// 返回 承载所有人所需的最小船数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：people = [1,2], limit = 3
//输出：1
//解释：1 艘船载 (1, 2)
// 
//
// 示例 2： 
//
// 
//输入：people = [3,2,2,1], limit = 3
//输出：3
//解释：3 艘船分别载 (1, 2), (2) 和 (3)
// 
//
// 示例 3： 
//
// 
//输入：people = [3,5,3,4], limit = 5
//输出：4
//解释：4 艘船分别载 (3), (3), (4), (5) 
//
// 
//
// 提示： 
//
// 
// 1 <= people.length <= 5 * 10⁴ 
// 1 <= people[i] <= limit <= 3 * 10⁴ 
// 
// Related Topics 贪心 数组 双指针 排序 👍 208 👎 0

import java.util.Arrays;

class _881_救生艇 {
    public static void main(String[] args) {
        Solution solution = new _881_救生艇().new Solution();
        int[] people = {1, 2};
        int limit = 3;
        int ans = solution.numRescueBoats(people, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 0;
        int[] people = null;

        public int numRescueBoats(int[] $people, int limit) {
            Arrays.sort($people);
            length = $people.length;
            people = new int[length + 1];
            System.arraycopy($people, 0, people, 1, length);

            int left = 1, right = length, ans = 0;

            while(left <= right) {
                int weight = people[right] + people[left];
                if(weight > limit) {
                    // 仅仅右指针左移
                    right--;
                } else {
                    left++;
                    right--;
                }
                ans++;
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}