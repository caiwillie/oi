package leetcode.editor.cn;

//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 686 👎 0

import java.util.LinkedList;

class _695_岛屿的最大面积 {
    public static void main(String[] args) {
        Solution solution = new _695_岛屿的最大面积().new Solution();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int ans = solution.maxAreaOfIsland(grid);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int rl = 0;
        int cl = 0;
        int[][] grid = null;

        int r = -1, c = -1, ans = 0, count = 0;
        LinkedList<int[]> cs = new LinkedList<>();
        LinkedList<int[]> ss = new LinkedList<>();
        boolean[][] used = null;

        public int maxAreaOfIsland(int[][] $grid) {
            rl = $grid.length;
            cl = $grid[0].length;
            grid = $grid;
            used = new boolean[rl][cl];


            push();
            while (!cs.isEmpty()) {
                int[] ca = cs.peek();
                if (ss.peek() != ca) {
                    r = ca[0];
                    c = ca[1];
                    if (used[r][c]) {
                        // 源头可能重复使用过了
                        cs.pop();
                    } else {
                        used[r][c] = true;
                        ss.push(ca);
                        count++;
                        push();
                    }
                } else {
                    ss.pop();
                    cs.pop();
                    if(ss.isEmpty()) {
                        // 只有ss.isEmpty() 代表一次遍历完成
                        ans = Math.max(count, ans);
                        count = 0;
                    }
                }
            }

            return ans;
        }

        void push() {
            if (r == -1 && c == -1) {
                for (int i = 0; i < rl; i++) {
                    for (int j = 0; j < cl; j++) {
                        if (grid[i][j] == 1) {
                            // 多个源头
                            cs.push(new int[]{i, j});
                        }
                    }
                }
            } else {
                for (int i = c - 1; i <= c + 1; i++) {
                    if (i >= 0 && i <= cl - 1 && !used[r][i] && grid[r][i] == 1) {
                        cs.push(new int[]{r, i});
                    }
                }

                for (int i = r - 1; i <= r + 1; i++) {
                    if (i >= 0 && i <= rl - 1 && !used[i][c] && grid[i][c] == 1) {
                        cs.push(new int[]{i, c});
                    }
                }
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}