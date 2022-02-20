package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1188 👎 0

import java.util.LinkedList;

class _79_单词搜索 {
    public static void main(String[] args) {
        Solution solution = new _79_单词搜索().new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean ans = solution.exist(board, word);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int rl = 0, cl = 0;
        boolean[][] used = null;
        char[][] board = null;
        int wl = 0;
        char[] word;

        int r = -1, c = -1, wi = 0;
        LinkedList<int[]> ss = new LinkedList<>();
        LinkedList<int[]> cs = new LinkedList<>();

        public boolean exist(char[][] $board, String $word) {
            rl = $board.length;
            cl = $board[0].length;
            board = $board;
            used = new boolean[rl][cl];
            word = $word.toCharArray();
            wl = word.length;

            push();
            while (!cs.isEmpty()) {
                int[] ca = cs.peek();

                if (ss.peek() != ca) {
                    ss.push(ca);
                    r = ca[0];
                    c = ca[1];
                    used[ca[0]][ca[1]] = true;
                    wi++;
                    push();
                } else {
                    if (wi == wl) {
                        return true;
                    }
                    ss.pop();
                    cs.pop();
                    used[ca[0]][ca[1]] = false;
                    wi--;
                }
            }

            return false;
        }

        void push() {
            if (r == -1 && c == -1) {
                for (int i = 0; i < rl; i++) {
                    for (int j = 0; j < cl; j++) {
                        if (board[i][j] == word[wi]) {
                            cs.push(new int[]{i, j});
                        }
                    }
                }
            } else {
                // 左右剪值
                for (int i = c - 1; i <= c + 1; i++) {
                    if (i >= 0 && i < cl && !used[r][i] && wi < wl && board[r][i] == word[wi]) {
                        cs.push(new int[]{r, i});
                    }
                }
                // 上下剪枝
                for (int i = r - 1; i <= r + 1; i++) {
                    if (i >= 0 && i < rl && !used[i][c] && wi < wl && board[i][c] == word[wi]) {
                        cs.push(new int[]{i, c});
                    }
                }
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}