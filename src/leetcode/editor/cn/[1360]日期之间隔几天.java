// 开始时间：2023-11-02 17:27:07
// 题目标题：日期之间隔几天
// 题目标记：number-of-days-between-two-dates
// 题目编号：1360
// 题目描述：

/**
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * <p>
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 * <p>
 * <p>
 * Related Topics 数学 字符串 👍 57 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int toDay(String dateStr) {
        String[] temp = dateStr.split("-");
        int year = Integer.valueOf(temp[0]);
        int month = Integer.valueOf(temp[1]);
        int day = Integer.valueOf(temp[2]);

        if (month <= 2) {
            year--;
            month += 10;
        } else month -= 2;
        return 365 * year + year / 4 - year / 100 + year / 400 + 30 * month + (3 * month - 1) / 5 + day /*- 584418*/;
    }

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDay(date1) - toDay(date2));
    }
}

//leetcode submit region end(Prohibit modification and deletion)

