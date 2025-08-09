// 开始时间：2025-08-09 18:08:04
// 题目标题：至少在两个数组中出现的值
// 题目标记：two-out-of-three
// 题目编号：2032
// 题目描述：

import org.springframework.cglib.transform.impl.AddDelegateTransformer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素
 * 可以按 任意 顺序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * 输出：[2,3,1]
 * 解释：至少在两个数组中出现的所有值为：
 * - 2 ，在数组 nums2 和 nums3 中出现过。
 * - 3 ，在数组 nums1 和 nums2 中出现过。
 * - 1 ，在数组 nums1 和 nums3 中出现过。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * 输出：[]
 * 解释：不存在至少在两个数组中出现的值。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums1.length, nums2.length, nums3.length <= 100
 * 1 <= nums1[i], nums2[j], nums3[k] <= 100
 * <p>
 * <p>
 * Related Topics 位运算 数组 哈希表 👍 91 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> hashSet1 = new HashSet(nums1.length);
        HashSet<Integer> hashSet2 = new HashSet(nums2.length);
        HashSet<Integer> hashSet3 = new HashSet(nums3.length);
        HashSet<Integer> hashSet4 = new HashSet(nums3.length);
        List<Integer> result = new ArrayList<>();
        for (int i : nums1) {
            hashSet1.add(i);
            hashSet4.add(i);
        }
        for (int i : nums2) {
            hashSet2.add(i);
            hashSet4.add(i);
        }
        for (int i : nums3) {
            hashSet3.add(i);
            hashSet4.add(i);
        }
        for (Integer i : hashSet4) {
            if ((hashSet1.contains(i) && hashSet2.contains(i))
                    || (hashSet2.contains(i) && hashSet3.contains(i))
                    || (hashSet1.contains(i) && hashSet3.contains(i))) {
                result.add(i);
            }
        }
        return result;
    }
/*
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> hashSet1 = new HashSet(nums1.length);
        HashSet<Integer> hashSet2 = new HashSet(nums2.length);
        HashSet<Integer> hashSet3 = new HashSet(nums3.length);
        HashSet<Integer> hashSet4 = new HashSet(nums3.length);
        List<Integer> result = new ArrayList<>();
        for (int i : nums1) {
            hashSet1.add(i);
            hashSet4.add(i);
        }
        for (int i : nums2) {
            hashSet2.add(i);
            hashSet4.add(i);
        }
        for (int i : nums3) {
            hashSet3.add(i);
            hashSet4.add(i);
        }
        for (Integer i : hashSet4) {
            if ((hashSet1.contains(i) && hashSet2.contains(i))
                    || (hashSet2.contains(i) && hashSet3.contains(i))
                    || (hashSet1.contains(i) && hashSet3.contains(i))) {
                result.add(i);
            }
        }
        return result;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

