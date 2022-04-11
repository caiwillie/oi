package leetcode.editor.cn;

//给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 294 👎 0

class _400_第N位数字 {
    public static void main(String[] args) {
        Solution solution = new _400_第N位数字().new Solution();
        int ans = solution.findNthDigit(1000000000);
        return;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int $n) {
            int digital = 1;
            long start = 1;
            long n = $n;
            while (n > 9 * digital * start) {
                // 将能减去的位数全部减去
                n = n - 9 * digital * start;
                start = start * 10;
                digital++;
            }

            // 计算出最后一个数字相对start的偏移量
            long i = (long) Math.ceil(1.0 * n / digital);
            long num = start + i - 1;

            // 计算出是在数字内的第几位
            long k = n - (i - 1) * digital;

            // 除以10的digital - k次方后，取余
            return (int) ((num / (long) Math.pow(10, digital - k)) % 10);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}