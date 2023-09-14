import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/*
O(1) 时间插入、删除和获取随机元素
380
2023-09-14 16:50:13
*/
//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {
    HashSet<Integer> hashSet = new HashSet<>();
    ArrayList<Integer> list = new ArrayList<>();
    Random random = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        boolean add = hashSet.add(val);
        if (add) {
            list.add(val);
        }
        return add;
    }

    public boolean remove(int val) {
        boolean remove = hashSet.remove(val);
        if (remove) {
            list.remove(list.indexOf(val));
        }
        return remove;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
