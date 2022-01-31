package leetcode.editor.cn;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1284 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class _56_合并区间 {
    public static void main(String[] args) {
        Solution solution = new _56_合并区间().new Solution();
        int[][] intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] ans = solution.merge(intervals);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] merge(int[][] intervals) {
            List<int[]> list = new ArrayList<>();
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int i = 0;
            int length = intervals.length;
            while (i < length) {
                int[] t = new int[2];
                int start = intervals[i][0];
                int end = intervals[i][1];
                while (i < length - 1 && end >= intervals[i + 1][0]) {
                    // 在这里控制条件
                    end = Math.max(end, intervals[i + 1][1]);
                    i++;
                }
                t[0] = start;
                t[1] = end;
                list.add(t);
                i++;
            }

            int[][] ans = new int[list.size()][];
            for (int j = 0; j < list.size(); j++) {
                ans[j] = list.get(j);
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}