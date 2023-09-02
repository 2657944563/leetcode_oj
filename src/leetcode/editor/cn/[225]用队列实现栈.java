import java.util.LinkedList;

/*
用队列实现栈
225
2023-09-02 13:20:48
*/
//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    LinkedList<Integer> read = new LinkedList<>();
    LinkedList<Integer> write = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        readToWrite();
        write.push(x);
    }

    public int pop() {
        writeToRead();
        return read.pop();
    }

    public int top() {
        writeToRead();
        return read.peek();
    }

    public boolean empty() {
        return write.isEmpty() && read.isEmpty();
    }

    public LinkedList<Integer> readToWrite() {
        if (!read.isEmpty()) {
            Integer pop = read.pop();
            readToWrite().push(pop);
        }
        return write;
    }

    public LinkedList<Integer> writeToRead() {
        if (!write.isEmpty()) {
            Integer pop = write.pop();
            writeToRead().push(pop);
        }
        return read;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
