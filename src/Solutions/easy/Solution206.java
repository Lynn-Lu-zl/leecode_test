package Solutions.easy;

import LinkList.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 *
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 *
 * 示例 3：
 *
 *
 * 输入：head = []
 * 输出：[]

 * 提示：

 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000

 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 *
 * Related Topics 递归 链表
 */



public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
        {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null)
        {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

     public static void main(String[] args) {
         Solution206 solution206 = new Solution206();
         ListNode listNode7 = new ListNode(7,null);
         ListNode listNode6 = new ListNode(6,listNode7);
         ListNode listNode5 = new ListNode(5,listNode6);
         ListNode listNode4 = new ListNode(4,listNode5);
         ListNode listNode3 = new ListNode(3,listNode4);
         ListNode listNode2 = new ListNode(2,listNode3);
         ListNode head = new ListNode(1,listNode2);
         head.printList();
         solution206.reverseList(head).printList();
     }
}
