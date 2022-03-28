package leetcode.editor.cn;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 976 👎 0

import java.util.ArrayList;
import java.util.List;

class _54_螺旋矩阵 {
    public static void main(String[] args) {
        Solution solution = new _54_螺旋矩阵().new Solution();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ans = solution.spiralOrder(matrix);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int l = 1, r = matrix[0].length, t = 1, d = matrix.length;

            while (true) {
                // 上边界：从左到右扫描
                for (int i = l; i <= r; i++) {
                    ans.add(matrix[t - 1][i - 1]);
                }
                // 上边界向下移动
                t++;
                if (t > d) break;

                // 右边界：从上往下扫描
                for (int i = t; i <= d; i++) {
                    ans.add(matrix[i - 1][r - 1]);
                }
                // 右边界向左移动
                r--;
                if (l > r) break;

                // 下边界：从右往左扫描
                for (int i = r; i >= l; i--) {
                    ans.add(matrix[d - 1][i - 1]);
                }
                // 下边界上移
                d--;
                if (t > d) break;

                // 左边界：从下往上扫描
                for (int i = d; i >= t; i--) {
                    ans.add(matrix[i - 1][l - 1]);
                }
                // 左边界向右移动
                l++;
                if (l > r) break;

            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}