/*
包含min函数的栈
剑指 Offer 30
2022-08-02 10:39:20
*/
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    StackNode top;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        if (top == null) {
            top = new StackNode(x, null);
            top.min = x;
        } else {
            StackNode t = new StackNode(x, top);
            t.min = Math.min(x, top.min);
            top = t;
        }

    }

    public void pop() {
//        if(top.)
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int min() {
        return top.min;
    }

    class StackNode {
        public int min;
        public int val;
        public StackNode next;

        public StackNode(int v, StackNode n) {
            val = v;
            next = n;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)
