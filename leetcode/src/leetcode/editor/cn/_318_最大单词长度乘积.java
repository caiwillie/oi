package leetcode.editor.cn;

//给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母
//。如果不存在这样的两个单词，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出：16 
//解释：这两个单词为 "abcw", "xtfn"。 
//
// 示例 2： 
//
// 
//输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
//输出：4 
//解释：这两个单词为 "ab", "cd"。 
//
// 示例 3： 
//
// 
//输入：words = ["a","aa","aaa","aaaa"]
//输出：0 
//解释：不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
// Related Topics 位运算 数组 字符串 👍 341 👎 0

class _318_最大单词长度乘积 {
    public static void main(String[] args) {
        Solution solution = new _318_最大单词长度乘积().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(String[] words) {
            int length = words.length;

            // 掩码，每一个位代表一个字母
            int[] masks = new int[length];
            for (int i = 0; i < length; i++) {
                String word = words[i];
                int wordLength = word.length();
                for (int j = 0; j < wordLength; j++) {
                    // 或
                    masks[i] |= 1 << (word.charAt(j) - 'a');
                }
            }
            int maxProd = 0;
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if ((masks[i] & masks[j]) == 0) {
                        // 如果没有重复的单词，位与运算 == 0
                        maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                    }
                }
            }
            return maxProd;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}