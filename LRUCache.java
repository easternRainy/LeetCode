import java.util.HashMap;

/**
 * LeetCode 146
 * References: https://www.interviewcake.com/concept/java/lru-cache
 */
public class LRUCache {
    private DoubleLinkedList cache;
    private HashMap<Integer, ListNode> table;
    private int capacity;
    private int num; // number of nodes

    public LRUCache(int capacity) {
        this.cache = new DoubleLinkedList();
        this.table = new HashMap<>();
        this.capacity = capacity;
        this.num = 0;
    }

    public int get(int key) {
       ListNode node = this.table.get(key);
       if (node == null) {
           return -1;
       } else {
           node = this.cache.removeNode(node);
           node = this.cache.insertToHead(node);
           return node.val;
       }
    }

    public void put(int key, int value) {


        // if the key exists
        ListNode node = this.table.get(key);
        if (node != null) {
            this.cache.removeNode(node);
            node = new ListNode(value);
            node = this.cache.insertToHead(node);
            this.table.put(key, node);

        } else {
            if(this.num == this.capacity) {
                ListNode tail = this.cache.removeTail();
                this.removeKeyFromTable(tail);
                this.num--;
            }

            ListNode newNode = new ListNode(value);
            this.cache.insertToHead(newNode);
            this.table.put(key, newNode);
            this.num++;
        }





    }

    private void removeKeyFromTable(ListNode node) {
        for(Integer k: this.table.keySet()) {
            if (this.table.get(k) == node) {
                this.table.remove(k);
                return;
            }
        }
    }





    public class ListNode {
        public int val;
        public ListNode pre;
        public ListNode next;


        public ListNode() {}
        public ListNode(int val) { this.val = val;}
    }


    public class DoubleLinkedList {
        public ListNode head;
        public ListNode tail;

        public DoubleLinkedList() {
            this.head = new ListNode(-1); // dummy head;
            this.tail = new ListNode(-2); // dummy tail;
            this.head.next = this.tail;
            this.tail.pre = this.head;
        }

        public ListNode removeNode(ListNode node) {
            // assume this node must be in the double linked list
            ListNode preNode = node.pre;
            ListNode nextNode = node.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
            node.pre = null;
            node.next = null;
            return node;
        }

        public ListNode insertToHead(ListNode node) {
            ListNode realHead = this.head.next;
            this.head.next = node;
            node.next = realHead;
            realHead.pre = node;
            node.pre = this.head;
            return node;
        }

        public ListNode removeTail() {
            ListNode realTail = this.tail.pre;
            if (realTail == this.head) {
                return null;
            } else {
                ListNode preNode = realTail.pre;
                preNode.next = this.tail;
                this.tail.pre = preNode;
                realTail.pre = null;
                realTail.next = null;
                return realTail;
            }
        }

    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2,6);
        System.out.println(lRUCache.get(1));
        lRUCache.put(1,5);
        lRUCache.put(1,2);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }
}
