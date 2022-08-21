/*
检查单词是否为句中其他单词的前缀
1455
2022-08-21 11:06:51
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() >= searchWord.length() && s[i].substring(0, searchWord.length()).equals(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
