import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
三数之和
15
2023-07-09 21:27:26
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int n = 1;
        int l = 0, r = 2, temp;
        while (n <= nums.length - 1) {
            while (l >= 0 && r < nums.length) {
                temp = nums[l] + nums[r] + nums[n];
//                System.out.println(temp);
//                System.out.println(String.format("%d,%d,%d", nums[l], nums[r], nums[n]));
                if (temp == 0) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[l]);
                    integers.add(nums[n]);
                    integers.add(nums[r]);
                    res.add(integers);
                    --l;
                    ++r;
                } else if (temp < 0) {
                    while (++r < nums.length && nums[r] == nums[r - 1]) {
                    }
                } else {
                    while (--l >= 0 && nums[l] == nums[l + 1]) {
                    }
                }
            }
//            while (++n < nums.length && nums[n] == nums[n - 1]) {
//            }
            ++n;
            l = n - 1;
            r = n + 1;
        }
        return res.stream().distinct().collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
