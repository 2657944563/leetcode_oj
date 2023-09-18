/*
密钥格式化
482
2023-09-18 16:32:08
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase().replaceAll("-", "");
        int j = s.length() % k;
        StringBuilder result = new StringBuilder(s);
        for (; j < result.length(); j += k) {
            if (j != 0) {
                result.insert(j, '-');
                j++;
            }
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
