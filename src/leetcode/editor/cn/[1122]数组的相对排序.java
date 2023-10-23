// 开始时间：2023-10-22 12:34:27
// 题目标题：数组的相对排序
// 题目标记：relative-sort-array
// 题目编号：1122
// 题目描述：

import java.util.*;

/**
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 * <p>
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * 输出：[22,28,8,6,17,44]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * <p>
 * Related Topics 数组 哈希表 计数排序 排序 👍 277 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        LinkedList<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr1) {
            hm.merge(i, 1, Integer::sum);
        }

        for (int i : arr2) {
            Integer integer = hm.get(i);
            if (integer != null) {
                for (int l = 0; l < integer; l++) {
                    list.add(i);
                }
            }
            hm.remove(i);
        }
        hm.entrySet().stream()
                .sorted((Comparator.comparingInt(Map.Entry::getKey)))
                .forEach(o -> {
                    for (int l = 0; l < o.getValue(); l++) {
                        list.add(o.getKey());
                    }
                });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

