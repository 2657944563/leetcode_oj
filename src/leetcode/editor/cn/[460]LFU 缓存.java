// 开始时间：2023-09-25 11:00:07
// 题目标题：LFU 缓存
// 题目标记：lfu-cache
// 题目编号：460
// 题目描述：

/**
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>
 * 实现 LFUCache 类：
 * <p>
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量
 * capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * <p>
 * <p>
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * <p>
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get",
 * "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * <p>
 * 解释：
 * // cnt(x) = 键 x 的使用计数
 * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // 返回 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 * // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // 返回 4
 * // cache=[3,4], cnt(4)=2, cnt(3)=3
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= capacity <= 10⁴
 * 0 <= key <= 10⁵
 * 0 <= value <= 10⁹
 * 最多调用 2 * 10⁵ 次 get 和 put 方法
 * <p>
 * <p>
 * Related Topics 设计 哈希表 链表 双向链表 👍 711 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {

    Map<Integer, Node> cache;  // 存储缓存的内容，Node中除了value值外，还有key、freq、所在doublyLinkedList、所在doublyLinkedList中的postNode、所在doublyLinkedList中的preNode，具体定义在下方。

    DoublyLinkedList firstLinkedList; // firstLinkedList.post 是频次最大的双向链表

    DoublyLinkedList lastLinkedList;  // lastLinkedList.pre 是频次最小的双向链表，满了之后删除 lastLinkedList.pre.tail.pre 这个Node即为频次最小且访问最早的Node

    int size;

    int capacity;


    public LFUCache(int capacity) {

        cache = new HashMap<>(capacity);

        firstLinkedList = new DoublyLinkedList();

        lastLinkedList = new DoublyLinkedList();

        firstLinkedList.post = lastLinkedList;

        lastLinkedList.pre = firstLinkedList;

        this.capacity = capacity;

    }


    public int get(int key) {

        Node node = cache.get(key);

        if (node == null) {

            return -1;

        }

        // 该key访问频次+1

        freqInc(node);

        return node.value;

    }


    public void put(int key, int value) {

        if (capacity == 0) {

            return;

        }

        Node node = cache.get(key);

        // 若key存在，则更新value，访问频次+1

        if (node != null) {

            node.value = value;

            freqInc(node);

        } else {

            // 若key不存在

            if (size == capacity) {

                // 如果缓存满了，删除lastLinkedList.pre这个链表（即表示最小频次的链表）中的tail.pre这个Node（即最小频次链表中最先访问的Node），如果该链表中的元素删空了，则删掉该链表。

                cache.remove(lastLinkedList.pre.tail.pre.key);

                lastLinkedList.removeNode(lastLinkedList.pre.tail.pre);

                size--;

                if (lastLinkedList.pre.head.post == lastLinkedList.pre.tail) {

                    removeDoublyLinkedList(lastLinkedList.pre);

                }

            }

            // cache中put新Key-Node对儿，并将新node加入表示freq为1的DoublyLinkedList中，若不存在freq为1的DoublyLinkedList则新建。

            Node newNode = new Node(key, value);

            cache.put(key, newNode);

            if (lastLinkedList.pre.freq != 1) {

                DoublyLinkedList newDoublyLinedList = new DoublyLinkedList(1);

                addDoublyLinkedList(newDoublyLinedList, lastLinkedList.pre);

                newDoublyLinedList.addNode(newNode);

            } else {

                lastLinkedList.pre.addNode(newNode);

            }

            size++;

        }

    }


    /**
     * node的访问频次 + 1
     */
    void freqInc(Node node) {

        // 将node从原freq对应的双向链表里移除, 如果链表空了则删除链表。

        DoublyLinkedList linkedList = node.doublyLinkedList;

        DoublyLinkedList preLinkedList = linkedList.pre;

        linkedList.removeNode(node);

        if (linkedList.head.post == linkedList.tail) {

            removeDoublyLinkedList(linkedList);

        }


        // 将node加入新freq对应的双向链表，若该链表不存在，则先创建该链表。

        node.freq++;

        if (preLinkedList.freq != node.freq) {

            DoublyLinkedList newDoublyLinedList = new DoublyLinkedList(node.freq);

            addDoublyLinkedList(newDoublyLinedList, preLinkedList);

            newDoublyLinedList.addNode(node);

        } else {

            preLinkedList.addNode(node);

        }

    }


    /**
     * 增加代表某1频次的双向链表
     */
    void addDoublyLinkedList(DoublyLinkedList newDoublyLinedList, DoublyLinkedList preLinkedList) {

        newDoublyLinedList.post = preLinkedList.post;

        newDoublyLinedList.post.pre = newDoublyLinedList;

        newDoublyLinedList.pre = preLinkedList;

        preLinkedList.post = newDoublyLinedList;

    }


    /**
     * 删除代表某1频次的双向链表
     */
    void removeDoublyLinkedList(DoublyLinkedList doublyLinkedList) {

        doublyLinkedList.pre.post = doublyLinkedList.post;

        doublyLinkedList.post.pre = doublyLinkedList.pre;

    }

}


class Node {

    int key;

    int value;

    int freq = 1;

    Node pre; // Node所在频次的双向链表的前继Node

    Node post; // Node所在频次的双向链表的后继Node

    DoublyLinkedList doublyLinkedList;  // Node所在频次的双向链表


    public Node() {
    }


    public Node(int key, int value) {

        this.key = key;

        this.value = value;

    }

}


class DoublyLinkedList {

    int freq; // 该双向链表表示的频次

    DoublyLinkedList pre;  // 该双向链表的前继链表（pre.freq < this.freq）

    DoublyLinkedList post; // 该双向链表的后继链表 (post.freq > this.freq)

    Node head; // 该双向链表的头节点，新节点从头部加入，表示最近访问

    Node tail; // 该双向链表的尾节点，删除节点从尾部删除，表示最久访问


    public DoublyLinkedList() {

        head = new Node();

        tail = new Node();

        head.post = tail;

        tail.pre = head;

    }


    public DoublyLinkedList(int freq) {

        head = new Node();

        tail = new Node();

        head.post = tail;

        tail.pre = head;

        this.freq = freq;

    }


    void removeNode(Node node) {

        node.pre.post = node.post;

        node.post.pre = node.pre;

    }


    void addNode(Node node) {

        node.post = head.post;

        head.post.pre = node;

        head.post = node;

        node.pre = head;

        node.doublyLinkedList = this;

    }


}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

