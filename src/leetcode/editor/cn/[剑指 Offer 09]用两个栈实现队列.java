import java.util.Stack;

/*
用两个栈实现队列
剑指 Offer 09
2022-07-31 18:35:27
*/
//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    boolean flag = false; //false == 没有同步

    public CQueue() {
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (flag) {
            if (stack2.size() == 0) {
                //补充原素
                flag = false;
                return deleteHead();
            }
            return stack2.pop();
        } else {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
            if (stack2.size() != 0) {
                flag = true;
                return stack2.pop();
            } else {
                return -1;
            }
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)
