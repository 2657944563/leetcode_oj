import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
数组的度
697
2023-09-18 22:03:30
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.merge(num, 1, Integer::sum);
        }
        Integer integer = hashMap.keySet().stream().map(o -> hashMap.get(o)).max(Integer::compare).get();
        for (Integer n : hashMap.entrySet().stream().filter(o -> o.getValue().equals(integer)).map(Map.Entry::getKey).collect(Collectors.toList())) {
            int left, right;
            for (left = 0; left < nums.length; left++) {
                if (nums[left] == n) {
                    break;
                }
            }
            for (right = nums.length - 1; right > 0; right--) {
                if (nums[right] == n) {
                    break;
                }
            }
            max = Math.min(max, right - left + 1);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
