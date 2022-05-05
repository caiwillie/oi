package leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 967 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _77_组合 {
    public static void main(String[] args) {
        Solution solution = new _77_组合().new Solution();
        List<List<Integer>> ans = solution.combine(4, 2);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int i = 0, count = 0, n = 0, k = 0;
        LinkedList<Integer> cs = new LinkedList<>();
        LinkedList<Integer> ss = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;

            push();
            while(!cs.isEmpty()) {
                Integer c = cs.peek();
                if(c != ss.peek()) {
                    ss.push(c);
                    count++;
                    i = c;
                    push();
                } else {
                    add();
                    cs.pop();
                    ss.pop();
                    count--;
                }
            }

            return ans;

        }

        void push() {
            if(count < k) {
                for (int j = i + 1; j <= n - k + count + 1 ; j++) {
                    // n - k - count - 1 = n - (k - (count + 1))
                    cs.push(j);
                }
            }
        }

        void add() {
            if(count == k) {
                ans.add(new ArrayList<>(ss));
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}