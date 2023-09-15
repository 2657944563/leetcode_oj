import java.util.LinkedList;
import java.util.List;

/*
子集
78
2023-09-15 16:50:57
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        dfs(result, nums, 0, tempList);
        return result;
    }

    void dfs(List<List<Integer>> results, int[] nums, int i, LinkedList<Integer> tempList) {
        if (i >= nums.length) {
            results.add(tempList);
            return;
        }
        dfs(results, nums, i + 1, tempList);
        LinkedList<Integer> tempList2 = new LinkedList<>(tempList);
        tempList2.add(nums[i]);
        dfs(results, nums, i + 1, tempList2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
