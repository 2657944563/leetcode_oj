/*
复杂链表的复制
剑指 Offer 35
2022-08-03 22:58:14
*/
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node t = head;
        Node dummy = new Node(-10010), cur = dummy;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node node = new Node(head.val);
            map.put(head, node);
            cur.next = node;
            cur = cur.next;
            head = head.next;
        }
        cur = dummy.next;
        head = t;
        while (head != null) {
            cur.random = map.get(head.random);
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }
}

//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)
