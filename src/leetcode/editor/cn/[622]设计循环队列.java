/*
设计循环队列
622
2022-08-02 12:54:51
*/
//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularQueue {
    int[] res;
    int startIndex = 0, endIndex = 0;

    public MyCircularQueue(int k) {
        res = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if ((endIndex + 1) % res.length != startIndex) {
            res[endIndex] = value;
            endIndex = (endIndex + 1) % res.length;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        startIndex = (startIndex + 1) % res.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return res[startIndex];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        if (endIndex - 1 < 0) {
            return res[res.length - 1];
        }
        return res[endIndex - 1];
    }

    public boolean isEmpty() {
        return endIndex == startIndex;
    }

    public boolean isFull() {
        return (endIndex + 1) % res.length == startIndex;

    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
