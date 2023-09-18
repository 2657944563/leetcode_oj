import java.util.Arrays;

/*
开始时间：2023-09-18 22:46:58
题目标题：三个数的最大乘积
题目标记：maximum-product-of-three-numbers
题目编号：628
题目描述：
/**
给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 

 

 示例 1： 

 
输入：nums = [1,2,3]
输出：6
 

 示例 2： 

 
输入：nums = [1,2,3,4]
输出：24
 

 示例 3： 

 
输入：nums = [-1,-2,-3]
输出：-6
 

 

 提示： 

 
 3 <= nums.length <= 10⁴ 
 -1000 <= nums[i] <= 1000 
 
 Related Topics 数组 数学 排序 👍 461 👎 0

*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[0] * nums[1] * nums[nums.length - 1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

