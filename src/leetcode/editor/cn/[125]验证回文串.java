/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 2 * 10⁵
 * 字符串 s 由 ASCII 字符组成
 * <p>
 * Related Topics 双指针 字符串 👍 539 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean p(byte c1) {
        return (c1 >= '0' && c1 <= '9') || (c1 >= 'A' && c1 <= 'Z');
    }

    boolean pan(byte c1, byte c2) {
        return p(c1) && p(c2);
    }

    public boolean isPalindrome(String s) {
        final byte[] bytes = s.toUpperCase().getBytes();
        int l = 0, r = bytes.length - 1;

        while (l <= r) {
            if (pan(bytes[l], bytes[r])) {
                if (bytes[l++] != bytes[r--]) {
                    return false;
                }
            }
            while (l <= r && !p(bytes[l])) {
                l++;
            }
            while (l <= r && !p(bytes[r])) {
                r--;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
