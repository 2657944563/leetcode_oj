package content;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//标准的KMP算法，代码堆里面已经手写实现了
class SubstringSearch {


    public boolean hasSubstring(char[] text, char[] pattern) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
        }
        if (j == pattern.length) {
            return true;
        }
        return false;
    }

    private int[] computeTemporaryArray(char pattern[]) {
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        Arrays.stream(lps).forEach(System.out::print);
        return lps;
    }

    public boolean KMP(char[] text, char[] pattern) {

        int lps[] = computeTemporaryArray(pattern);
        int i = 0;
        int j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == pattern.length) {
            return true;
        }
        return false;
    }
}

@Slf4j
@SpringBootApplication
public class shejimos {
    //    static int l = 0;
//    static int wei(int a) {
//        a = (a << 1) + 1;
//        return a < 0 ? a >>> 1 : wei(a);
//    }
    public static void main(String[] args) {
        Integer i = 1;
        Integer l = 2;
        ThreadLocal t = new ThreadLocal();
        t.set(i);
        t.set(l);
        System.out.println(t.get());

//        UUID uid = UUID.randomUUID();
//        UUID uid1 = UUID.nameUUIDFromBytes("https://www.baidu.com/seacher".getBytes());
//        System.out.println(uid.toString());
//        System.out.println(uid.toString());
//        System.out.println(uid1.toString());
//        System.out.println(uid1.toString().substring(0, 8));
//        System.out.println("https://www.baidu.com/seacher);
//
//        System.out.println(-1 >>> 1 >> 8 * 3 + 7);
//
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        int a1 = 1 << 31;
//        int a2 = (1 << 31) + 1;
//        System.out.println(1 << 31);
//        System.out.println(wei(1));
//        String a = "aabaaabaaac";
//        String flag = "aabaaac";
//
//        int n = '9' - '0';
//        System.out.println(n);
//        final int kmp = kmp(a, flag);
//        System.out.println(kmp);


//        final SubstringSearch sub = new SubstringSearch();
//        sub.KMP(a.toCharArray(), flag.toCharArray());

//        System.out.println(a.substring(kmp,kmp + flag.length()));
//        System.out.println("123".substring(0,0));
//        CompletableFuture<String> s = new CompletableFuture<>();
//        String str = "abc";
//        ArrayList<String> strings = new ArrayList<>();
//        strings.stream().forEach((o) -> {
//            strings.add(Integer.toString(new Random().nextInt(100)));
//        });
//        strings.add(str);

//        for (int i = 0; i < strings.size(); i++) {
//            if (strings.get(i).equals(str)) {
//                System.out.println("存在");
//                return;
//            }
//        }
//        for (String s : strings) {
//            if (s.equals(str)) {
//                System.out.println("存在");
//                return;
//            }
//        }
//        System.out.println("不存在");
//
//        if (strings.contains(str)) {
//            System.out.println("存在");
//        } else {
//            System.out.println("不存在");
//        }

//
//        ThreadPoolExecutor th = new ThreadPoolExecutor(3, 6, 1000,
//                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000),
//                (o) -> {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread thread = new Thread(o, o.toString());
//                    thread.setDaemon(false);
//                    return thread;
//                },
//                new ThreadPoolExecutor.AbortPolicy()
//        );
//        final Future<Integer> submit = th.submit(() -> 1);
//        th.execute(() -> System.out.println(Thread.currentThread().getName()));
//        th.setMaximumPoolSize(th.getMaximumPoolSize()+100);
//        th.setCorePoolSize(th.getCorePoolSize()+100);
//        System.out.println(th.getCorePoolSize());
//        System.out.println(submit.get());
//        th.allowCoreThreadTimeOut(true);
//        th.shutdown();
//        ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap();
//        map.put("123", "123");
//        CyclicBarrier c = new CyclicBarrier(100, true);
//        ReentrantLock lock = new ReentrantLock();
//        lock.lock();
//        c.await();


//        FutureTask f = new FutureTask(()->{
//            System.out.println(1);
//            System.out.println(Thread.currentThread().getName());
//            Thread.sleep(1000);
//            return "1";
//        });
//        new Thread(f).start();
//        System.out.println(f.get());
//        log.debug("123");

        //获取线程
//        ThreadMXBean t = ManagementFactory.getThreadMXBean();
//        final ThreadInfo[] threadInfos = t.dumpAllThreads(false, false);
//        Arrays.stream(threadInfos).forEach(System.out::println);

//        AtomicStampedReference<String> name = new AtomicStampedReference<>("zs",1);
//        int stamp = name.getStamp();
//        name.compareAndSet("zs", "lis", stamp, stamp + 1);
//        name.compareAndSet("lis", "zs", stamp, stamp + 1);
//        System.out.println(name.getReference());


        //哲学家进餐问题
//        Lock l = new ReentrantLock();
//        Lock[] lock = new ReentrantLock[5];
//        for (int i = 0; i < lock.length; i++) {
//            lock[i] = new ReentrantLock();
//        }
//        ArrayList<Zhexuejia> zhe = new ArrayList<>(5);
//        Zhexuejia zhexuejia1 = new Zhexuejia("1", lock[0], lock[1]);
//        zhe.add(zhexuejia1);
//        Zhexuejia zhexuejia2 = new Zhexuejia("2", lock[1], lock[2]);
//        zhe.add(zhexuejia2);
//        Zhexuejia zhexuejia3 = new Zhexuejia("3", lock[2], lock[3]);
//        zhe.add(zhexuejia3);
//        Zhexuejia zhexuejia4 = new Zhexuejia("4", lock[3], lock[4]);
//        zhe.add(zhexuejia4);
//        Zhexuejia zhexuejia5 = new Zhexuejia("5", lock[4], lock[0]);
//        zhe.add(zhexuejia5);
//        zhe.forEach(Thread::start);

//        ZonedDateTime time = ZonedDateTime.now();
//        System.out.println(time);
//        System.out.println(time.format(DateTimeFormatter.ofPattern("y-M-d")));
//        System.out.println(time.getYear());
//        System.out.println(time.plusSeconds(123028130));
//
//        new fanxingfangfa().f(1);
//        ByteBuffer
//        new Thread(() -> {
//            new suo().s1();
//        }).start();
//        new Thread(() -> {
//            new suo().s();
//        }).start();
//
//        new suo().s1();

//        Collections.synchronizedList()
//        ArrayList<Integer> ar = new ArrayList<>();
//
//        try {
//            final Class<?> aClass = Class.forName("jdk.internal.misc.Unsafe");
//            final Field theUnsafe = aClass.getDeclaredField("theUnsafe");
//            System.out.println(theUnsafe);
//            System.out.println(aClass.getClassLoader());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }


//        try {
//            final Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//            theUnsafe.setAccessible(true);
//            System.out.println(theUnsafe);
//            System.out.println(Unsafe.class.getClassLoader());
//        } catch (NoSuchFieldException e) {
//        }


//        float e = 1e-4f;
//        float e1 = 0.001f;
//        float a = 2.0f - 1.9f;
//        float b = 0.9f - 0.8f;
//        double db = 123.3;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(a - b);
//        System.out.println(e1);
//        System.out.println(a-b<e);
//        BigDecimal bd = new BigDecimal("213.123213");
//        System.out.println(bd.pow(12));
//        System.out.println();
//Object.class.
//        String s = new String("123");

//        SpringApplication.run(shejimos.class, args);

//        System.out.println(new singleT.initSingle());
//        System.out.println(singleT.getD());
//        System.out.println(singleT.initSingle.getDanli());
//        new x().p();
//        new Thread(() -> {
//            System.out.println(1);
//        }).resume();
//        "123".intern();
//        new StringBuilder();
//
//        System.out.println("abc".intern() == new String("abc"));
//        final Scanner scanner = new Scanner(System.in);
//        final String s = scanner.nextLine();
//        scanner.close();
//
//        new BufferedReader(new InputStreamReader(System.in));
//        final BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
//        byte[] temp = new byte[1024];
//        int i = 0;
//        try {
//            while ((i = bufferedInputStream.read(temp)) != 1) {
//                System.out.println(new String(temp, 0, i - 1));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    //kmp
    public static int kmp(String haystack, String needle) {
        //用于存储性能，每种不同的计算前缀需要的次数和比较次数
        int bijiaocishu = 0, jisuancishu = 0, jisuancishu2 = 0;
        //用于存储对应的前缀数量，这里不单单是前缀数量，主要是一个比较失败后的下一个用于比较的索引
        int[] bytes3 = new int[needle.length()];
        int[] bytes4 = new int[needle.length()];
        Arrays.fill(bytes3, 0);

        //（性能不好O(N^2)级别）循环遍历，从0-1的小范围一直遍历到0-needle.length()的大范围,每次遍历都会给遍历的最大范围那个索引赋值前缀数，（同样不是简单的前缀数）
        for (int i = 1; i < needle.length(); i++) {
            for (int i1 = 0; i1 < i; i1++) {
                //每个小范围内，前面n个数和最后n个数进行一个比较
                if (needle.substring(0, i1 + 1).equals(needle.substring(i - i1, i + 1))) {
                    jisuancishu++;
                    bytes3[i] = i1 + 1;
                }
            }
        }
        for (int i : bytes3) {
            System.out.print(i + " ");
        }
        System.out.println();

        //（性能好O(N)级别）从第一二个字符开始比较，
        for (int i = 0, l = 1; i < needle.length() && l < needle.length(); ) {
            if (needle.charAt(i) == needle.charAt(l)) {
                bytes4[l] = i + 1;
                l++;
                i++;
            } else {
                if (bytes4[i - 1] != 0) {
//                if (i != 0) {
                    i = bytes4[i - 1];
                } else {
                    l++;
                }
//                i = 0;
            }
            jisuancishu2++;
        }
        for (int i : bytes4) {
            System.out.print(i + " ");
        }
        System.out.println();

        int i = 0, l = 0;
        while (i < haystack.length() && l < needle.length()) {
            bijiaocishu++;
            if (haystack.charAt(i) == needle.charAt(l)) {
                i++;
                l++;
            } else {
//                i++;
//                l = bytes4[l];
                if (l == 0) {
                    i++;
                } else {
                    l = bytes4[l - 1];
                }
            }
        }
        System.out.printf("比较次数：%s 计算次数：%s 第二种计算次数：%s \n", bijiaocishu, jisuancishu, jisuancishu2);
        return (i == haystack.length() ? (l == needle.length() ? i - l : -1) : i - l);
    }
}


//哲学家进餐类
class Zhexuejia extends Thread {

    String name;
    Lock L;
    Lock R;

    Zhexuejia(String name, Lock l, Lock r) {
        System.out.println("哲学家构造");
        this.name = name;
        this.L = l;
        this.R = r;
        super.setName(name);
    }

    @SneakyThrows
    private void jincan() {
        boolean ok = false;
        System.out.println(name + "开始获取筷子");

        while (!ok) {
            if (L.tryLock()) {
                try {
                    System.out.println(name + "获取" + L + "筷子");
                    if (R.tryLock(100, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println(name + "获取" + R + "筷子");
                            System.out.println(name + "开始进餐");
                            ok = true;
                        } finally {
                            R.unlock();
                        }
                    }
                } finally {
                    L.unlock();
                }
            }
        }
    }

    @Override
    public void run() {
        jincan();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jincan();
    }
}


class fanxingfangfa {
    public <T> void f(T t) {
        System.out.println(t.getClass().getName());
    }
}

class F<T> implements fan<T>, Serializable {

    private static final Long serialVersionUID = 1L;
    transient int anInt;

    @Override
    public void pr() {

    }

    public static <T> void aVoid(T[] array) {

    }
}

interface fan<T> {
    public void pr();
}

class suo {

    static {
        System.out.println("静态方法块");
    }

    {
        System.out.println("方法块");
    }

    public synchronized void s() {
        try {
            System.out.println("对象锁");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("对象锁");
    }


    public void s1() {
        synchronized (suo.class) {
            try {
                System.out.println("Class锁");
                Thread.sleep(1000);
                System.out.println("Class锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class queueCas<T extends Comparable> {
    private LinkedList<T> q = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    T max = null;

    public T getMax() {
        return max;
    }

    public boolean add(T i) {
        lock.lock();
        try {
            if (q.size() == 0) {
                max = i;
            } else {
                max = (max.compareTo(i) > 0 ? max : i);
            }
            q.push(i);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            lock.unlock();
        }
        return true;
    }

    public T get() {
        lock.lock();
        try {
            return q.getLast();
        } catch (Exception e) {
            return null;
        } finally {
            lock.unlock();
        }
    }
}


class ex extends Exception {
    public ex(String message) {
        super(message);
    }
}

class x implements a, b {

    @Override
    public void p() {

    }
}

interface a {
    default void p() {
        System.out.println("a");
    }

    ;
}

interface b {
    default void p() {
        System.out.println("b");
    }
}

