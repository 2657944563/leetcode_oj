// 开始时间：2025-08-18 21:06:47
// 题目标题：24 点游戏
// 题目标记：24-game
// 题目编号：679
// 题目描述：

/**
 * 给定一个长度为4的整数数组 cards 。你有 4 张卡片，每张卡片上都包含一个范围在 [1,9] 的数字。您应该使用运算符 ['+', '-', '*',
 * '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式，以获得值24。
 * <p>
 * 你须遵守以下规则:
 * <p>
 * <p>
 * 除法运算符 '/' 表示实数除法，而不是整数除法。
 * <p>
 * <p>
 * <p>
 * 例如， 4 /(1 - 2 / 3)= 4 /(1 / 3)= 12 。
 * <p>
 * <p>
 * 每个运算都在两个数字之间。特别是，不能使用 “-” 作为一元运算符。
 * <p>
 * 例如，如果 cards =[1,1,1,1] ，则表达式 “-1 -1 -1 -1” 是 不允许 的。
 * <p>
 * <p>
 * 你不能把数字串在一起
 * <p>
 * 例如，如果 cards =[1,2,1,2] ，则表达式 “12 + 12” 无效。
 * <p>
 * <p>
 * <p>
 * <p>
 * 如果可以得到这样的表达式，其计算结果为 24 ，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: cards = [4, 1, 8, 7]
 * 输出: true
 * 解释: (8-4) * (7-1) = 24
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: cards = [1, 2, 1, 2]
 * 输出: false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * cards.length == 4
 * 1 <= cards[i] <= 9
 * <p>
 * <p>
 * Related Topics 数组 数学 回溯 👍 503 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

