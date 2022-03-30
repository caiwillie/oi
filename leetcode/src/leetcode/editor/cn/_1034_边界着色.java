package leetcode.editor.cn;

//给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
//。 
//
// 两个网格块属于同一 连通分量 需满足下述全部条件： 
//
// 
// 两个网格块颜色相同 
// 在上、下、左、右任意一个方向上相邻 
// 
//
// 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块： 
//
// 
// 在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻 
// 在网格的边界上（第一行/列或最后一行/列） 
// 
//
// 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//输出：[[3,3],[3,2]] 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//输出：[[1,3,3],[2,3,3]] 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//输出：[[2,2,2],[2,1,2],[2,2,2]] 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 145 👎 0

import java.util.LinkedList;

class _1034_边界着色 {
    public static void main(String[] args) {
        Solution solution = new _1034_边界着色().new Solution();
        int[][] grid = {{1, 2, 2}, {2, 3, 2}};
        int[][] ans = solution.colorBorder(grid, 0, 1, 3);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int rl = 0;
        int cl = 0;
        int[][] grid = null;

        int r = -1, c = -1, ans = 0, count = 0, num = 0;
        LinkedList<int[]> cs = new LinkedList<>();
        LinkedList<int[]> ss = new LinkedList<>();
        int[][] used = null;

        public int[][] colorBorder(int[][] $grid, int row, int col, int color) {
            rl = $grid.length;
            cl = $grid[0].length;
            grid = $grid;
            used = new int[rl][cl];
            num = grid[row][col];

            cs.push(new int[]{row, col});


            while (!cs.isEmpty()) {
                int[] ca = cs.peek();
                if (ca != ss.peek()) {
                    r = ca[0];
                    c = ca[1];
                    if (used[r][c] != 0) {
                        // 源头可能重复使用过了
                        cs.pop();
                    } else {
                        // 表示是连通分量
                        used[r][c] = 1;
                        ss.push(ca);
                        push();
                    }
                } else {
                    cs.pop();
                    ss.pop();
                }
            }

            for (int i = 0; i < rl; i++) {
                for (int j = 0; j < cl; j++) {
                    if (used[i][j] == 2) grid[i][j] = color;
                }
            }

            return grid;
        }

        void push() {
            boolean board = false;

            for (int i = c - 1; i <= c + 1; i++) {
                if (!board && (i < 0 || i > cl - 1 || grid[r][i] != num)) {
                    board = true;
                }

                if (i >= 0 && i <= cl - 1 && used[r][i] == 0 && grid[r][i] == num) {
                    cs.push(new int[]{r, i});
                }
            }

            for (int i = r - 1; i <= r + 1; i++) {
                if (!board && (i < 0 || i > rl - 1 || grid[i][c] != num)) {
                    board = true;
                }

                if (i >= 0 && i <= rl - 1 && used[i][c] == 0 && grid[i][c] == num) {
                    cs.push(new int[]{i, c});
                }
            }

            if (board) {
                // 表示是连通分量边界
                used[r][c] = 2;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}