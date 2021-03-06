package leetcode.editor.cn;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3369 👎 0

class _7_整数反转 {
    public static void main(String[] args) {
        Solution solution = new _7_整数反转().new Solution();
        int reverse = solution.reverse(-123);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int reverse(int x) {
            int sum = 0, mod = 0;
            while (x != 0) {
                mod = x % 10;
                if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && mod > 7))
                    // 判断上边界是否会溢出
                    return 0;
                if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && mod < -8))
                    // 判断下边界是否会溢出
                    return 0;
                sum = sum * 10 + mod;
                x = x / 10;
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}