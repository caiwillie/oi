package leetcode.editor.cn;

//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
// Related Topics 数组 矩阵 模拟 👍 269 👎 0

class _498_对角线遍历 {
    public static void main(String[] args) {
        Solution solution = new _498_对角线遍历().new Solution();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ans = solution.findDiagonalOrder(mat);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int m = 0;
        int n = 0;


        public int[] findDiagonalOrder(int[][] mat) {

            m = mat.length;
            n = mat[0].length;
            int length = m * n; // 元素个数
            int r = 0; //当前行
            int c = 0; //当前列

            int[] ans = new int[m * n];
            for (int i = 0; i < length; ++i) {
                ans[i] = mat[r][c];
                if ((r + c) % 2 == 0) { // 右上
                    if (c == n - 1) r++; // 如果是最后一列，不能再修改列数y了，会越界
                    else if (r == 0) c++; // 如果是第一行，向右即可;
                    else {
                        r--;
                        c++;
                    } // 正常右上
                } else { // 左下
                    if (r == m - 1) ++c; //如果是最后一行，不能再修改行数x了，会越界
                    else if (c == 0) ++r; //如果是第一列，向下即可;
                    else {
                        ++r;
                        --c;
                    } //正常左下
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}