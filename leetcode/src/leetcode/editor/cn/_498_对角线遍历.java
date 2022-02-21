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
        int[][] mat = {{3}, {2}};
        int[] ans = solution.findDiagonalOrder(mat);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int m = 0;
        int n = 0;


        public int[] findDiagonalOrder(int[][] mat) {
            m = mat.length; // r
            n = mat[0].length; // c

            int[] ans = new int[m * n];

            int r = 0, c = 0;
            int i = 0;
            boolean flag = true;
            while (i < m * n) {
                ans[i] = mat[r][c];
                if (r == 0 && c == 0) {
                    if(c != n - 1) {
                        c++;
                    } else if (r != m - 1) {
                        r++;
                    }
                } else if (r == m - 1 && c == n - 2) {
                    c++;
                } else {
                    if (flag) {
                        if (c > 0) {
                            c--;
                            r++;
                        } else {
                            r++;
                            flag = false;
                        }
                    } else {
                        if (r > 0) {
                            r--;
                            c++;
                        } else {
                            r++;
                            flag = true;
                        }
                    }
                }
                i++;
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}