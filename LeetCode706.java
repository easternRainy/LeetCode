public class LeetCode706 {
    class MyHashMap {

        Node[] bucket;
        int size = 97;

        /** Initialize your data structure here. */
        public MyHashMap() {
            this.bucket = new Node[this.size];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = key % this.size;

            if (this.bucket[index] == null) {
                this.bucket[index] = new Node(key, value);
            } else {
                Node p = this.bucket[index];

                while (p != null) {
                    if (p.key == key) {

                        p.val = value;
                        return;
                    }
                    p = p.next;
                }

                Node newNode = new Node(key, value);
                newNode.next = this.bucket[index];
                this.bucket[index] = newNode;
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = key % this.size;

            if (this.bucket[index] == null) {
                return -1;
            } else {
                Node p = this.bucket[index];
                while (p != null) {
                    if (p.key == key) {
                        return p.val;
                    }
                    p = p.next;
                }

                return -1;
            }

        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = key % this.size;

            if (this.bucket[index] == null) {
                System.out.println("Null");
                return;
            }

            Node p = this.bucket[index];
            Node pre = p;

            if (p.key == key) {
                System.out.println("head");
                this.bucket[index] = p.next;
                p.next = null;
                return;
            }

            while (p != null) {
                if (p.key == key) {
                    System.out.println("inner");
                    pre.next = p.next;
                    p.next = null;
                    return;
                }

                pre = p;
                p = p.next;
            }
        }


        class Node {
            int key;
            int val;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
