package leetcode.editor.cn;

//列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法： 
//
// 
// 
// 
// 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。 
// 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。 
// 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。 
// 
//
// 给你整数 n ，返回 arr 最后剩下的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 9
//输出：6
//解释：
//arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//arr = [2, 4, 6, 8]
//arr = [2, 6]
//arr = [6]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
// 
// 
// Related Topics 数学 👍 269 👎 0

class _390_消除游戏 {
    public static void main(String[] args) {
        Solution solution = new _390_消除游戏().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n) {
            int num = n;//当前数组元素个数
            boolean leftToRight = true;//判断此时是从左到右还是从右到左删除
            int head = 1;//首项
            int d = 1;//公差
            while (num != 1) {
                if (num % 2 == 1) {//num为奇数
                    head = head + d;//无论从左到右还是从右到左第一位都会被删，首项都会改变
                } else if (num % 2 == 0) {
                    if (leftToRight)
                        head = head + d;//从左到右删首项会改变
                    else
                        head = head;//从右到左删首项不变
                }
                leftToRight = !leftToRight;//每一轮改变删除方向
                d *= 2;//公差变大
                num /= 2;//个数向下取1/2
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}