import java.nio.charset.StandardCharsets;

/*
替换空格
剑指 Offer 05
2022-07-31 12:33:59
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        byte[] bytes = s.getBytes();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != ' ') {
                str.append((char) (bytes[i]));
            } else {
                str.append("%20");
            }
        }
        return str.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
