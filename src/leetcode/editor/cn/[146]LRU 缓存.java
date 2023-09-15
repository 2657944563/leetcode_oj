import java.util.HashMap;
import java.util.LinkedList;

/*
LRU 缓存
146
2023-09-15 18:05:11
*/
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    int capacity;
    LinkedList<Integer> list;
    HashMap<Integer, Integer> hashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>(capacity * 2);
        list = new LinkedList<>();
    }

    public int get(int key) {
        Integer integer = hashMap.get(key);
        if (integer != null) {
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
            return integer;
        }
        return -1;
    }

    public void put(int key, int value) {
        Integer put = hashMap.put(key, value);
        if (hashMap.size() > capacity) {
            Integer listKey = list.removeLast();
            hashMap.remove(listKey);
        }
        if (put != null) {
            list.remove(Integer.valueOf(key));
        }
        list.addFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
