import javax.script.ScriptEngine;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 2020-08-12
 * LeetCode Problem 23
 * Tags: #Linked_List
 */

public class LeetCode23 {

    public ListNode mergeKList(ListNode[] lists) {
        // use priority queue to get the smallest value easily
        PriorityQueue<QueElem> priorityQueue = new PriorityQueue<>();

        // put the first elements in the lists in priority queue
        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null) {
                priorityQueue.add(new QueElem(lists[i]));
            }
        }

        // final result: the merged list
        ListNode result = null;
        ListNode p = result;
        QueElem curr;
        while((curr=priorityQueue.peek()) != null) {
            if (result == null) {
                result = curr.listNode;
                p = result;
            } else {
                p.next = curr.listNode;
                p = p.next;
            }

            priorityQueue.remove(curr);
            if (curr.listNode.next != null) {
                priorityQueue.add(new QueElem(curr.listNode.next));
            }
        }

        return result;
    }

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         public String toString() {
             ListNode p = this;
             String result = "";

             while(p != null) {
                 result += p.val + "->";
                 p = p.next;
             }
             return result;
         }
     }

     public class QueElem implements Comparable{
        ListNode listNode;

        public QueElem(ListNode listNode) {
            this.listNode = listNode;
        }

         @Override
         public int compareTo(Object o) {
             int cmp = this.listNode.val - ((QueElem) o).listNode.val;
             if(cmp > 0) {
                 return 1;
             } else if (cmp == 0) {
                 return 0;
             } else {
                 return -1;
             }
         }
     }

     public ListNode createNode(int[] array) {
        ListNode head = new ListNode();
        ListNode p = head;
        for(int i=0; i<array.length; i++) {
            if(i == 0) {
                head.val = array[0];
            } else {
                ListNode tmp = new ListNode(array[i]);
                p.next = tmp;
                p = p.next;
            }
        }

        return head;
     }


    public static void main(String[] args) {
        ListNode[] test = new ListNode[3];

        int[] array0 = {1, 4, 5};
        int[] array1 = {1, 3, 4};
        int[] array2 = {2, 6};

        LeetCode23 solution = new LeetCode23();
        test[0] = solution.createNode(array0);
        test[1] = solution.createNode(array1);
        test[2] = solution.createNode(array2);

        ListNode result = solution.mergeKList(test);
        System.out.println(result.toString());
    }

}
