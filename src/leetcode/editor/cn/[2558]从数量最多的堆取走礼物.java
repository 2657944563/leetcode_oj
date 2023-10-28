// 开始时间：2023-10-28 11:41:52
// 题目标题：从数量最多的堆取走礼物
// 题目标记：take-gifts-from-the-richest-pile
// 题目编号：2558
// 题目描述：

import java.util.PriorityQueue;

/**
 * 给你一个整数数组 gifts ，表示各堆礼物的数量。每一秒，你需要执行以下操作：
 * <p>
 * <p>
 * 选择礼物数量最多的那一堆。
 * 如果不止一堆都符合礼物数量最多，从中选择任一堆即可。
 * 选中的那一堆留下平方根数量的礼物（向下取整），取走其他的礼物。
 * <p>
 * <p>
 * 返回在 k 秒后剩下的礼物数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：gifts = [25,64,9,4,100], k = 4
 * 输出：29
 * 解释：
 * 按下述方式取走礼物：
 * - 在第一秒，选中最后一堆，剩下 10 个礼物。
 * - 接着第二秒选中第二堆礼物，剩下 8 个礼物。
 * - 然后选中第一堆礼物，剩下 5 个礼物。
 * - 最后，再次选中最后一堆礼物，剩下 3 个礼物。
 * 最后剩下的礼物数量分别是 [5,8,9,4,3] ，所以，剩下礼物的总数量是 29 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：gifts = [1,1,1,1], k = 4
 * 输出：4
 * 解释：
 * 在本例中，不管选中哪一堆礼物，都必须剩下 1 个礼物。
 * 也就是说，你无法获取任一堆中的礼物。
 * 所以，剩下礼物的总数量是 4 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= gifts.length <= 10³
 * 1 <= gifts[i] <= 10⁹
 * 1 <= k <= 10³
 * <p>
 * <p>
 * Related Topics 数组 模拟 堆（优先队列） 👍 24 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(gifts.length, (o1, o2) -> o2 - o1);
        for (int gift : gifts) {
            queue.add(gift);
        }
        while (k > 0) {
            if (queue.peek() == 1) {
                break;
            } else {
                queue.add((int) Math.sqrt(queue.poll() * 1.0));
            }
            k--;
        }
        return queue.stream().mapToLong(Integer::intValue).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

