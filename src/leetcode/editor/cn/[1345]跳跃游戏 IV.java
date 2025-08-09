// 开始时间：2024-02-05 09:24:00
// 题目标题：跳跃游戏 IV
// 题目标记：jump-game-iv
// 题目编号：1345
// 题目描述：

/**
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * <p>
 * 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：
 * <p>
 * <p>
 * i + 1 需满足：i + 1 < arr.length
 * i - 1 需满足：i - 1 >= 0
 * j 需满足：arr[i] == arr[j] 且 i != j
 * <p>
 * <p>
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * <p>
 * 注意：任何时候你都不能跳到数组外面。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * <p>
 * 1 <= arr.length <= 5 * 10⁴
 * -10⁸ <= arr[i] <= 10⁸
 * <p>
 * <p>
 * Related Topics 广度优先搜索 数组 哈希表 👍 251 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minJumps(int[] arr) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

