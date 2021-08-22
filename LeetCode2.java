/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1); // dummy head

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode p3 = result;

        int carry = 0;
        while(true) {
            System.out.println("new loop");
            int tmp = 0;
            if (p1 != null && p2 != null) {

                tmp = p1.val + p2.val + carry;
                p3.next = new ListNode(tmp % 10);
                carry = tmp / 10;
                p3 = p3.next;
                p1 = p1.next;
                p2 = p2.next;

            } else if (p1 != null && p2 == null) {

                tmp = p1.val + carry;
                p3.next = new ListNode(tmp % 10);
                carry = tmp / 10;
                p3 = p3.next;
                p1 = p1.next;

            } else if (p1 == null && p2 != null){

                tmp = p2.val + carry;
                p3.next = new ListNode(tmp % 10);
                carry = tmp / 10;
                p3 = p3.next;
                p2 = p2.next;

            } else {
                tmp = carry;
                if (tmp != 0) {
                    p3.next = new ListNode(tmp % 10);
                }

                break;
            }
        }

        return result.next;
    }

    public int toInt(ListNode l) {
        // convert list node to integer
        if (l == null) { return 0; }
        int result = 0;
        ListNode p = l;
        while ( p != null) {
            result = result * 10 + p.val;
            p = p.next;
        }

        return result;
    }

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}