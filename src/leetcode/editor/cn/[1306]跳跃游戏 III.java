// 开始时间：2024-02-05 09:16:00
// 题目标题：跳跃游戏 III
// 题目标记：jump-game-iii
// 题目编号：1306
// 题目描述：

import java.util.HashSet;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[
 * i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 * <p>
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 * <p>
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 数组 👍 167 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canReach(int[] arr, int start) {
        HashSet<Integer> f = new HashSet<>();
        return check(f, arr, start);
    }

    boolean check(HashSet<Integer> f, int[] arr, int index) {
        if (f.contains(index) || index < 0 || index >= arr.length) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }
        f.add(index);
        return check(f, arr, index - arr[index]) || check(f, arr, index + arr[index]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

