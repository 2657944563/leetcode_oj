import java.util.Stack;

/*
用栈实现队列
232
2023-09-07 17:40:47
*/
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    Stack<Integer> read = new Stack<>();
    Stack<Integer> write = new Stack<>();


    public MyQueue() {

    }

    public void push(int x) {
        if (write.isEmpty()) {
            readToWrite();
        }
        write.push(x);
    }

    public int pop() {
        if (read.isEmpty()) {
            writeToRead();
        }
        return read.pop();
    }

    public int peek() {
        if (read.isEmpty()) {
            writeToRead();
        }
        return read.peek();
    }

    public boolean empty() {
        return read.empty() && write.empty();
    }

    void readToWrite() {
        while (!read.isEmpty()) {
            write.push(read.pop());
        }
    }

    void writeToRead() {
        while (!write.isEmpty()) {
            read.push(write.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
