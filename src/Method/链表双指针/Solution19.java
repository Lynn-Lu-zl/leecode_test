package Method.链表双指针;

/**
 *
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class Solution19 {

    /**
     * 无论遍历一次链表和遍历两次链表的时间复杂度都是 O(N)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //虚拟节点
        ListNode dummy = new ListNode(-1);
        //将链表当成虚拟节点的下一结点
        dummy.next = head;
        //快指针
        ListNode fast = dummy;
        //慢指针
        ListNode slow = dummy;

        //fast先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //快慢指针同时移动
        while (fast.next != null){
            fast = fast.next;
            slow =slow.next;

        }
        //删除节点，此时慢指针正是第n-1个节点
        slow.next = slow.next.next;
        //返回链表头结点
        return dummy.next;
    }

     public static void main(String[] args) {


         Solution19 solution19 = new Solution19();
          //l1 1->2->3->4->5
         ListNode l1 = new ListNode(1);
         l1.next = new ListNode(2);
         l1.next.next = new ListNode(3);
         l1.next.next.next = new ListNode(4);
         l1.next.next.next.next = new ListNode(5);
         int n=2;
         ListNode listNode = solution19.removeNthFromEnd(l1, n);
         ListNode cur = listNode;
         while (cur != null){
             System.out.println(cur.val);
             cur = cur.next;
         }
     }
}
