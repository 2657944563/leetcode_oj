package content;

import lombok.Data;
import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class casQueue {
    public static void main(String[] args) {

        String filePath = "D:/1.txt";
        String outputFilePath = "D:/1_modified.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line += ",";
                writer.write(line);
                writer.newLine();
            }

            System.out.println("文件内容修改完成。");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        final NoLockQueue noLockQueue = new NoLockQueue();
//        noLockQueue.enQueue(1);
//        noLockQueue.enQueue(1);
//        noLockQueue.enQueue(1);
//        noLockQueue.enQueue(1);
//        noLockQueue.dequeue();
    }
}
class NoLockQueue {
    private static final Unsafe unsafe;
    //头节点
    volatile Node head;
    //尾节点
    volatile Node tail;

    //头节点偏移量
    private static final Long headOffset;
    //尾节点偏移量
    private static final Long tailOffset;
    //当前队列的长度
    private AtomicInteger length = new AtomicInteger(0);
    //队列允许的最大长度
    private int maxSize = 0;
    static {
        try {
            //获取成员变量
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可访问
            field.setAccessible(true);
            //是静态字段,用null来获取Unsafe实例
            unsafe = (Unsafe) field.get(null);
            //设置头节点变量在类中的偏移值
            headOffset = unsafe.objectFieldOffset(NoLockQueue.class.getDeclaredField("head"));
            //设置尾节点变量在类中的偏移值
            tailOffset = unsafe.objectFieldOffset(NoLockQueue.class.getDeclaredField("tail"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public NoLockQueue() {
        this.maxSize = Integer.MAX_VALUE;
        //初始化节点
        head = tail = new Node();
    }

    public NoLockQueue(int maxSize) {
        this.maxSize = maxSize;
        //初始化节点
        head = tail = new Node();
    }

    /**
     * 入队
     */
    public void enQueue(int value) {

        //创建新节点
        Node newNode = new Node();
        newNode.setValue(value);
        while (true) {
            //获取尾节点
            Node oldTail = this.tail;
            if (length.get() < maxSize && oldTail.casNext(null, newNode)) {
                System.out.println(Thread.currentThread().getName() + "进队列：" + value);
                unsafe.compareAndSwapObject(this, tailOffset, oldTail, newNode);
                length.incrementAndGet();
                break;
            }
        }
    }

    /**
     * 出队
     */
    public void dequeue() {

        while (true) {
            //如果没有数据
            if (length.get() <= 0) {
                continue;
            }
            //获取头节点
            Node oldHead = this.head;
            Node oldNext = oldHead.getNext();

            if (unsafe.compareAndSwapObject(this, headOffset, head, oldNext)) {
                System.out.println(Thread.currentThread().getName() + "出队列：" + head.getValue());
                length.decrementAndGet();
                break;
            }
        }
    }
}

@Data
class Node {

    //Unsafe类
    private static final Unsafe unsafe;

    //next变量的偏移量
    private static final Long nextOffset;


    //值
    private volatile int value;

    //next节点
    private volatile Node next;

    static {
        try {
            //获取成员变量
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            //设置为可访问
            field.setAccessible(true);
            //是静态字段,用null来获取Unsafe实例
            unsafe = (Unsafe) field.get(null);
            //获取state变量在类中的偏移值
            nextOffset = unsafe.objectFieldOffset(Node.class.getDeclaredField("next"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    /**
     * cas的方式设置next的值
     *
     * @param before 期望的值
     * @param after  修改的值
     * @return
     */
    public boolean casNext(Node before, Node after) {
        return unsafe.compareAndSwapObject(this, nextOffset, before, after);
    }


}


