// 开始时间：2025-08-18 21:38:23
// 题目标题：去掉最低工资和最高工资后的工资平均值
// 题目标记：average-salary-excluding-the-minimum-and-maximum-salary
// 题目编号：1491
// 题目描述：

/**
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * <p>
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：salary = [1000,2000,3000]
 * 输出：2000.00000
 * 解释：最低工资和最高工资分别是 1000 和 3000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：salary = [6000,5000,4000,3000,2000,1000]
 * 输出：3500.00000
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：salary = [8000,9000,2000,3000,6000,1000]
 * 输出：4750.00000
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= salary.length <= 100
 * 10^3 <= salary[i] <= 10^6
 * salary[i] 是唯一的。
 * 与真实值误差在 10^-5 以内的结果都将视为正确答案。
 * <p>
 * <p>
 * Related Topics 数组 排序 👍 86 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double average(int[] salary) {
        int min = Math.min(salary[0], salary[1]), max = Math.max(salary[0], salary[1]);
        double result = salary[0] + salary[1];
        for (int i = 2; i < salary.length; i++) {
            result += salary[i];
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }
        return (result - min - max) / (salary.length - 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

