// 开始时间：2023-09-23 23:08:23
// 题目标题：种花问题
// 题目标记：can-place-flowers
// 题目编号：605
// 题目描述：

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情
 * 况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= flowerbed.length <= 2 * 10⁴
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * <p>
 * Related Topics 贪心 数组 👍 634 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int userful = 0, right = 0, len = flowerbed.length; //变量分别为可用位置数、右边界、数组长度
        while (right < len) {
            int left = right;       //左边界，结合第二个滚筒，始终都会定在连续的0的左边界上
            while (right < len && flowerbed[right] == 0) {  //第一个滚筒，找出连续的0的右边界
                right++;
            }
            if (left == 0 && right == len) {            //贯穿始末
                userful += (right - left + 1) / 2;
            } else if (left == 0 || right == len) {     //两端
                userful += (right - left) / 2;
            } else {                                    //中间
                userful += (right - left - 1) / 2;
            }
            while (right < len && flowerbed[right] == 1) {      //第二个滚筒，跳过连续的1，找到下一个0
                right++;
            }
        }
        return !(userful < n);      //比较可种花位置数和需求数
    }
}

//leetcode submit region end(Prohibit modification and deletion)

