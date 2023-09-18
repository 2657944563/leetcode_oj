// 开始时间：2023-09-18 22:50:49
// 题目标题：计数二进制子串
// 题目标记：count-binary-substrings
// 题目编号：696
// 题目描述：

/**
 * 给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * <p>
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "00110011"
 * 输出：6
 * 解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
 * 注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
 * 另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "10101"
 * 输出：4
 * 解释：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s[i] 为 '0' 或 '1'
 * <p>
 * Related Topics 双指针 字符串 👍 539 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        char[] arr = s.toCharArray();
        int l;//左边界
        int r;//右边界
        for (int i = 0; i < arr.length - 1; i++) {//因为0和1数量相等，因此字符串长度一定为偶数，只有n-1种情况
            l = i;
            r = i + 1;
            char c1 = arr[l];//开始扩展前左边字符
            char c2 = arr[r];//开始扩展前右边字符
            if (c1 == c2) {//比如:00,11,不符合条件，直接进入下一次循环
                continue;
            }
            //比如:01,c1=0,c2=1
            //arr[l] == c1,判断c1左边的值是不是都是0
            //arr[r] == c2,判断c2右边的值是不是都是1
            while (r < arr.length && l >= 0 && arr[l] == c1 && arr[r] == c2) {
                l--;
                r++;
                res++;
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

