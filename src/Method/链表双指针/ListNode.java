package Method.链表双指针;

public class ListNode  {
    /**
     * 链表
     */

        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        public static void main(String[] args) {
         Solution21 solution21 = new Solution21();
         //l1 1->2->3->4->5
         ListNode l1 = new ListNode(1);
         l1.next = new ListNode(2);
         l1.next.next = new ListNode(3);
         l1.next.next.next = new ListNode(4);
         l1.next.next.next.next = new ListNode(5);

         ListNode l2 = new ListNode(1);
         l2.next = new ListNode(3);
         l2.next.next = new ListNode(4);
         // l2.next.next.next = new ListNode(4);
         // l2.next.next.next.next = new ListNode(5);

         // Solution21.ListNode listNode = solution21.mergeTwoLists(l1, l2);
         // Solution21.ListNode cur = listNode;
         // while (cur != null){
         //     System.out.println(cur.val);
         //     cur = cur.next;
         // }

     }

}
