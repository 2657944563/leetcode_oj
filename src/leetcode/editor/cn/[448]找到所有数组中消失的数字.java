import java.util.LinkedList;
import java.util.List;

/*
找到所有数组中消失的数字
448
2023-09-12 11:07:58
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] < 0 ?
                    nums[Math.abs(nums[i]) - 1] : nums[Math.abs(nums[i]) - 1] * -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
