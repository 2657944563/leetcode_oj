// 开始时间：2023-10-25 21:26:04
// 题目标题：最小绝对差
// 题目标记：minimum-absolute-difference
// 题目编号：1200
// 题目描述：

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 每对元素对 [a,b] 如下：
 * <p>
 * <p>
 * a , b 均为数组 arr 中的元素
 * a < b
 * b - a 等于 arr 中任意两个元素的最小绝对差
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * <p>
 * <p>
 * Related Topics 数组 排序 👍 146 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int l = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            l = Math.min(l, arr[i] - arr[i - 1]);
        }
        LinkedList<List<Integer>> results = new LinkedList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == l) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                results.add(list);
            }
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

