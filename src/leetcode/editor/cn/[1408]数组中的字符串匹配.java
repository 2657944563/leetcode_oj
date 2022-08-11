import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
数组中的字符串匹配
1408
2022-08-06 10:40:19
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> hashMap = new HashSet<>(words.length);
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (hashMap.contains(words[j])) {
                    continue;
                } else if (words[i].contains(words[j])) {
                    hashMap.add(words[j]);
                    list.add(words[j]);
                }
            }
        }
        return list;
    }
}

interface text {
    int a = 0;

    private void a() {
        System.out.println("1");
    }

    ;

    default void b() {
        System.out.println(2);
    }
}

abstract class abst {
    private static final int a = 1;

    public void ab() {
        System.out.println(1);

    }

    void bc() {
        System.out.println(1);

    }

    abstract void te();

};

class A {
    public void t() {
        ArrayList<Integer> integers = new ArrayList<>();
        final Iterator<Integer> iterator = integers.iterator();
        iterator.
    }
}

class B extends A {

    @Override
    public void t() {

    }
}

//leetcode submit region end(Prohibit modification and deletion)
