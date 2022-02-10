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
            int left = 1, right = matrix[0].length;
            int top = 1, down = matrix.length;

            while (true) {
                // 上边界：从左到右扫描
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top - 1][i - 1]);
                }
                // 上边界向下移动
                top++;
                if (top > down) break;

                // 右边界：从上往下扫描
                for (int i = top; i <= down; i++) {
                    ans.add(matrix[i - 1][right - 1]);
                }
                // 右边界向左移动
                right--;
                if (left > right) break;

                // 下边界：从右往左扫描
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down - 1][i - 1]);
                }
                // 下边界上移
                down--;
                if (top > down) break;

                // 左边界：从下往上扫描
                for (int i = down; i >= top; i--) {
                    ans.add(matrix[i - 1][left - 1]);
                }
                // 左边界向右移动
                left++;
                if (left > right) break;

            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}