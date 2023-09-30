// 开始时间：2023-09-29 14:56:37
// 题目标题：数据流中的第 K 大元素
// 题目标记：kth-largest-element-in-a-stream
// 题目编号：703
// 题目描述：

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * <p>
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= k <= 10⁴
 * 0 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * -10⁴ <= val <= 10⁴
 * 最多调用 add 方法 10⁴ 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 * <p>
 * <p>
 * Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列） 👍 451 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {
    ArrayList<Integer> result;
    int n;

    public KthLargest(int k, int[] nums) {
        n = k;
        result = new ArrayList<>(n);
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(nums[i]);
            if (result.size() == k) {
                break;
            }
        }
    }

    public int add(int val) {
        int left = 0, right = result.size() - 1;
        int mid, target;
        if (result.size() == 0) {
            result.add(val);
            return result.get(0);
        } else if (n > result.size() || val > result.get(result.size() - 1)) {
            while (left <= right) {
                mid = left + (right - left) / 2;
                target = result.get(mid);
                if (target < val) {
                    right = mid - 1;
                } else if (target > val) {
                    left = mid + 1;
                } else {
                    result.add(mid, val);
                    if (result.size() > n) {
                        result.remove(result.size() - 1);
                    }
                    return result.get(result.size() - 1);
                }
            }
            result.add(left, val);
            if (result.size() > n) {
                result.remove(result.size() - 1);
            }
        }
        return result.get(result.size() - 1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

