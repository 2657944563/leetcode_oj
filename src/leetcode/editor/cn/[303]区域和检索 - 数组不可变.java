/*
区域和检索 - 数组不可变
303
2023-09-07 18:18:16
*/
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    static int[] num;

    public NumArray(int[] nums) {
        num = nums;
    }

    public int sumRange(int left, int right) {
        int result = 0;
        while (left <= right) {
            result += num[left];
            left++;
        }
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
