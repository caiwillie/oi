package leetcode.editor.cn;

//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
// Related Topics 数组 数学 矩阵 👍 1157 👎 0

class _48_旋转图像 {
    public static void main(String[] args) {
        Solution solution = new _48_旋转图像().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length - 1;
            int t = 0, l = 0, r = n, b = n;

            while(true) {

                int[] temp = new int[r - l];

                // 将上面一行移出
                for (int i = l; i < r; i++) {
                    temp[i - l] = matrix[t][i];
                }

                for (int i = b; i > t; i--) {
                    matrix[t][n - i] = matrix[i][l];
                }

                for (int i = r; i > l; i--) {
                    matrix[n -i][l] = matrix[t][i];
                }

                for (int i = t; i < b; i++) {
                    matrix[b][n - i] = matrix[i][r];
                }

                for (int i = l; i < r; i++) {
                    matrix[n - i][r] = temp[i - l];
                }

                t++;
                l++;
                r--;
                b--;

                if(t > b) break;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}