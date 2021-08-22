public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null && l2 != null) {
            return l2;
        }

        if (l1 != null && l2 == null) {
            return l1;
        }

        ListNode preHead = new ListNode(-1);
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode pre = preHead;

        while(ptr1 != null && ptr2 != null) {
            if(ptr1.val <= ptr2.val) {
                pre.next = ptr1;
                ptr1 = ptr1.next;
                pre = pre.next;
            } else {
                pre.next = ptr2;
                ptr2 = ptr2.next;
                pre = pre.next;
            }
        }

        if(ptr1 == null && ptr2 != null) {
            pre.next = ptr2;
        }

        if(ptr1 != null && ptr2 == null) {
            pre.next = ptr1;
        }

        return preHead.next;

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
