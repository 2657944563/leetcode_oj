// 开始时间：2023-09-28 13:57:08
// 题目标题：按序打印
// 题目标记：print-in-order
// 题目编号：1114
// 题目描述：

import java.util.concurrent.locks.LockSupport;

/**
 * 给你一个类：
 * <p>
 * <p>
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * <p>
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 * <p>
 * <p>
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * <p>
 * <p>
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>
 * 提示：
 * <p>
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出："firstsecondthird"
 * 解释：
 * 有三个线程会被异步启动。输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用
 * third() 方法。正确的输出是 "firstsecondthird"。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,3,2]
 * 输出："firstsecondthird"
 * 解释：
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。正确的
 * 输出是 "firstsecondthird"。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * nums 是 [1, 2, 3] 的一组排列
 * <p>
 * <p>
 * Related Topics 多线程 👍 484 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Foo {
    volatile Thread thread2 = null;
    volatile Thread thread3 = null;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        while (thread2 == null) {
        }
        LockSupport.unpark(thread2);
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        thread2 = Thread.currentThread();
        LockSupport.park();
        printSecond.run();
        while (thread3 == null) {
        }
        LockSupport.unpark(thread3);

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        thread3 = Thread.currentThread();
        LockSupport.park();
        printThird.run();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

