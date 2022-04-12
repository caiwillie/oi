package leetcode.editor.cn;

//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
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
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 665 👎 0

import java.util.Arrays;
import java.util.LinkedList;

class _542_01矩阵{
    public static void main(String[] args) {
        Solution solution = new _542_01矩阵().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int rl = 0;
    int cl = 0;
    int[][] matrix = null;
    int[][] ans = null;
    int count = 0;
    int r = -1, c = -1;
    LinkedList<int[]> ss = new LinkedList<>();
    LinkedList<int[]> cs = new LinkedList<>();

    public int[][] updateMatrix(int[][] mat) {
        rl = mat.length;
        cl = mat[0].length;
        matrix = mat;
        ans = new int[rl][cl];
        for (int[] nums : ans) {
            Arrays.fill(nums, Integer.MAX_VALUE);
        }
        push();
        while (!cs.isEmpty()) {
            int[] ca = cs.peek();
            if (ss.peek() != ca) {
                ss.push(ca);
                r = ca[0];
                c = ca[1];
                ans[r][c] = count;
                count++;
                push();
            } else {
                ss.pop();
                cs.pop();
                count--;
            }
        }
        return ans;
    }

    void push() {
        if (r == -1 && c == -1) {
            for (int i = 0; i < rl; i++) {
                for (int j = 0; j < cl; j++) {
                    if (matrix[i][j] == 0) {
                        cs.push(new int[]{i, j});
                    }
                }
            }
        } else {
            // 左右
            for (int i = c - 1; i <= c + 1; i++) {
                if (i >= 0 && i < cl && matrix[r][i] != 0 && ans[r][i] > count) {
                    cs.push(new int[] {r, i});
                }
            }
            // 上下
            for (int i = r - 1; i <= r + 1; i++) {
                if (i >= 0 && i < rl && matrix[i][c] != 0 && ans[i][c] > count) {
                    cs.push(new int[] {i, c});
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}