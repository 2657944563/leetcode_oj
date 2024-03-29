import java.util.Stack;

/*
接雨水
42
2023-09-04 22:12:32
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, left = 0, right = height.length - 1, sum = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                sum += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                sum += rightMax - height[right--];
            }
        }
        return sum;
    }

    // 栈解
    int stackF(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
