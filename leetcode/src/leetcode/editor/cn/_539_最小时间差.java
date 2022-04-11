package leetcode.editor.cn;

//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 👍 189 👎 0

import java.util.Arrays;
import java.util.List;

class _539_最小时间差 {
    public static void main(String[] args) {
        Solution solution = new _539_最小时间差().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int length = 0;

        public int findMinDifference(List<String> $timePoints) {
            length = $timePoints.size();
            int[] timePoints = new int[length];

            for (int i = 0; i < $timePoints.size(); i++) {
                String $timePoint = $timePoints.get(i);
                int hour = Integer.parseInt($timePoint.substring(0, 2));
                int min = Integer.parseInt($timePoint.substring(3, 5));
                timePoints[i] = hour * 60 + min;
            }


            Arrays.sort(timePoints);

            int min = Integer.MAX_VALUE;
            for (int i = 1; i < length; i++) {
                min = Math.min(min, timePoints[i] - timePoints[i - 1]);
            }

            int last = timePoints[length - 1] - timePoints[0];
            min = Math.min(min, 24 * 60 - last);
            return min;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}