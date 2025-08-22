// 开始时间：2025-08-22 21:08:24
// 题目标题：转变日期格式
// 题目标记：reformat-date
// 题目编号：1507
// 题目描述：

/**
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 * <p>
 * <p>
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
 * "Oct", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 [1900, 2100] 之间。
 * <p>
 * <p>
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 * <p>
 * <p>
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：date = "6th Jun 1933"
 * 输出："1933-06-06"
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：date = "26th May 1960"
 * 输出："1960-05-26"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 给定日期保证是合法的，所以不需要处理异常输入。
 * <p>
 * <p>
 * Related Topics 字符串 👍 25 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reformatDate(String date) {
        String[] s = date.split(" ");
        String day = s[0].substring(0, s[0].length() - 2);
        day = day.length() <= 1 ? "0" + day : day;
        String[] month = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int monthI = 0;
        for (int i = 0; i < month.length; i++) {
            if (month[i].equals(s[1])) {
                monthI = i + 1;
            }
        }

        return s[2] + "-" + (monthI < 10 ? "0" + monthI : monthI) + "-" + day;


    }

    enum month {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

