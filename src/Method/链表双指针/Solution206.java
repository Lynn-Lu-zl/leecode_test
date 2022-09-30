package Method.链表双指针;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;


        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }

     public static void main(String[] args) {
              Solution206 solution206 = new Solution206();
               //l1 1->2->3->4->5
         ListNode l1 = new ListNode(1);
         l1.next = new ListNode(2);
         l1.next.next = new ListNode(3);
         l1.next.next.next = new ListNode(4);
         l1.next.next.next.next = new ListNode(5);
         ListNode listNode = solution206.reverseList(l1);

         ListNode cur = listNode;
         while (cur != null){
             System.out.println(cur.val);
             cur = cur.next;
         }

     }
}
