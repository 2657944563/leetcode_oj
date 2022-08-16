import java.util.ArrayList;
import java.util.List;

/*
设计有序流
1656
2022-08-16 21:39:56
*/
//leetcode submit region begin(Prohibit modification and deletion)
class OrderedStream {
    String[] res;
    int i = 1;

    public OrderedStream(int n) {
        res = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        res[idKey] = value;
        List<String> arrayList = new ArrayList<String>();
        while (i < res.length && res[i] != null) {
            arrayList.add(res[i++]);
        }
        return arrayList;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
