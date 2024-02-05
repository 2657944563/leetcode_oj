// 开始时间：2024-02-05 15:20:47
// 题目标题：能否连接形成数组
// 题目标记：check-array-formation-through-concatenation
// 题目编号：1640
// 题目描述：

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接
 * pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * <p>
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 142 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> hs = new HashMap();
        for (int i = 0; i < pieces.length; i++) {
            hs.put(pieces[i][0], i);
        }
        for (int i = 0; i < arr.length; i++) {
            Integer integer = hs.get(arr[i]);
            if (integer == null) {
                return false;
            }
            for (int j = i; j < i + pieces[integer].length; j++) {
                if (arr[j] != pieces[integer][j - i]) {
                    return false;
                }
            }
            i += pieces[integer].length - 1;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

