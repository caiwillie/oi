package leetcode.editor.cn;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1552 👎 0

import java.util.LinkedList;

class _200_岛屿数量 {
    public static void main(String[] args) {
        Solution solution = new _200_岛屿数量().new Solution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int ans = solution.numIslands(grid);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int rl = 0;
        int cl = 0;
        char[][] grid = null;

        int r = -1, c = -1, ans = 0;
        LinkedList<int[]> cs = new LinkedList<>();
        LinkedList<int[]> ss = new LinkedList<>();
        boolean[][] used = null;

        public int numIslands(char[][] $grid) {
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
                        push();
                    }
                } else {
                    ss.pop();
                    cs.pop();
                    if(ss.isEmpty()) {
                        ans++;
                    }
                }
            }

            return ans;
        }

        void push() {
            if (r == -1 && c == -1) {
                for (int i = 0; i < rl; i++) {
                    for (int j = 0; j < cl; j++) {
                        if (grid[i][j] == '1') {
                            // 多个源头
                            cs.push(new int[]{i, j});
                        }
                    }
                }
            } else {
                for (int i = c - 1; i <= c + 1; i++) {
                    if (i >= 0 && i <= cl - 1 && !used[r][i] && grid[r][i] == '1') {
                        cs.push(new int[]{r, i});
                    }
                }

                for (int i = r - 1; i <= r + 1; i++) {
                    if (i >= 0 && i <= rl - 1 && !used[i][c] && grid[i][c] == '1') {
                        cs.push(new int[]{i, c});
                    }
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}