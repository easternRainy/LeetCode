import java.util.ArrayList;
import java.util.HashMap;

/**
 * LeetCode 138
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * Tags: #LinkedList #HashTable
 */

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

public class LeetCode138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
             return null;
        }

        ArrayList<Node>  listNodes = new ArrayList<>();

        // Movable pointer
        Node p = head;
        HashMap<Node, Integer> index = new HashMap<>();
        int i = 0;
        // First traversal, add each node with value to a list
        // and create a hashtable, indicating node and index
        while(p != null) {
            Node newNode = new Node(p.val);
            listNodes.add(newNode);

            index.put(p, i);
            p = p.next;
            i++;
        }


        p = head;
        i = 0;
        int n = listNodes.size(); // number of nodes

        // Second traversal, add next and random for each node in listNodes
        while(p != null) {
            Node currNewNode = listNodes.get(i);

            if (p.next != null) {
                currNewNode.next = listNodes.get(i + 1);
            } else {
                currNewNode.next = null;
            }

            Node pRandom = p.random;

            if (pRandom == null) {
                currNewNode.random = null;
            } else {
                int randomIndex = index.get(pRandom);
                currNewNode.random = listNodes.get(randomIndex);
            }

            p = p.next;
            i++;
        }

        return listNodes.get(0);
    }
}
