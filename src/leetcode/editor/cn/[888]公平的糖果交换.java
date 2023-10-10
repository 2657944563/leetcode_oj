// 开始时间：2023-10-10 19:13:53
// 题目标题：公平的糖果交换
// 题目标记：fair-candy-swap
// 题目编号：888
// 题目描述：

import java.util.Arrays;

/**
 * 爱丽丝和鲍勃拥有不同总数量的糖果。给你两个数组 aliceSizes 和 bobSizes ，aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数
 * 量，bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
 * <p>
 * 两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。一个人拥有的糖果总数量是他们每盒糖果数量的总和。
 * <p>
 * 返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。如
 * 果存在多个答案，你可以返回其中 任何一个 。题目测试用例保证存在与输入对应的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：aliceSizes = [1,1], bobSizes = [2,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：aliceSizes = [1,2], bobSizes = [2,3]
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：aliceSizes = [2], bobSizes = [1,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：aliceSizes = [1,2,5], bobSizes = [2,4]
 * 输出：[5,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= aliceSizes.length, bobSizes.length <= 10⁴
 * 1 <= aliceSizes[i], bobSizes[j] <= 10⁵
 * 爱丽丝和鲍勃的糖果总数量不同。
 * 题目数据保证对于给定的输入至少存在一个有效答案。
 * <p>
 * <p>
 * Related Topics 数组 哈希表 二分查找 排序 👍 235 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceCount = Arrays.stream(aliceSizes).sum();
        int bobCount = Arrays.stream(bobSizes).sum();
        for (int aliceSize : aliceSizes) {
            for (int bobSize : bobSizes) {
                if (bobCount - bobSize + aliceSize == aliceCount + bobSize - aliceSize) {
                    return new int[]{aliceSize, bobSize};
                }
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

