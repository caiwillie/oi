package leetcode.editor.cn;

//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
// Related Topics 数组 哈希表 矩阵 👍 778 👎 0

import java.util.HashMap;
import java.util.Map;

class _36_有效的数独 {
    public static void main(String[] args) {
        Solution solution = new _36_有效的数独().new Solution();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.isValidSudoku(board);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int length = 9;
        Map<Character, Boolean> map = new HashMap<>();

        public boolean isValidSudoku(char[][] board) {
            // 校验每行
            for (int i = 0; i < length; i++) {
                map.clear();
                for (int j = 0; j < length; j++) {
                    if (board[i][j] == '.') continue;
                    if (map.containsKey(board[i][j])) {
                        return false;
                    } else {
                        map.put(board[i][j], true);
                    }
                }
            }

            // 校验每列
            for (int i = 0; i < length; i++) {
                map.clear();
                for (int j = 0; j < length; j++) {
                    if (board[j][i] == '.') continue;
                    if (map.containsKey(board[j][i])) {
                        return false;
                    } else {
                        map.put(board[j][i], true);
                    }
                }
            }

            // 九宫格
            for (int i = 0; i < length; i+=3) {
                for (int j = 0; j < length; j+=3) {
                    map.clear();
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            if (board[k][l] == '.') continue;
                            if (map.containsKey(board[k][l])) {
                                return false;
                            } else {
                                map.put(board[k][l], true);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}