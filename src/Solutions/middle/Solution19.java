package Solutions.middle;

/**
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
 *
 */
public class Solution19 {
    /**
     * 链表
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 定义虚拟节点目的：单链表中移除头结点 和 移除其他节点的操作方式是不一样，其实在写代码的时候也会发现，需要单独写一段逻辑来处理移除头结点的情况--》可以设置一个虚拟头结点，这样原链表的所有节点就都可以按照统一的方式进行移除了，不需要再额外处理头结点被移除后的情况
     *
     * 最后return 头结点的时候，别忘了 return dummyNode->next;， 这才是新的头结点
     *
     * 双指针法
     * 定义一个虚拟节点指向头结点
     * 定义两个快慢指针
     * 先让快指针移动n步
     * 然后快慢指针一起移动，直到慢指针的下一个节点为空即链表的尾结点--》
     * 这时的慢指针正好在要删除节点的前一节点
     * --》只需要将慢指针的下一个节点指向下下节点即可完成删除倒数第n个节点操作
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义一个虚拟节点，便于删除头结点不用做额外处理
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;
        //定义一个快指针,指向虚拟节点，用于遍历链表
        ListNode fast = dumpy;
        //定一个慢指针，
        ListNode slow = dumpy;
        //让快指针先移动 n 步
        while(n > 0){
            fast = fast.next;
            n--;
        }
        //快指针和慢指针同时移动--》直到快指针移动到最后一个节点--》这时快指针的下一个节点就是空节点了--》只要快指针不指向空，就继续循环，
        while(fast.next != null){
            //让快慢指针同时移动
            slow = slow.next;
            fast = fast.next;
        }
        //删除倒数第n个节点
        //当快指针移动到最后一个节点的时候--》这时慢指针移动到的位置就是，要删除节点的前一个节点--》所以只要删除当前节点的下一个节点
        slow.next = slow.next.next;

        //返回为指针指向的头节点，因为定义了虚拟节点作为头结点，但是题目最后返回的是原链表的头结点--》返回虚拟节点的下一结点才是真正原链表的头结点
        return dumpy.next;
    }

     public static void main(String[] args) {

         Solution19 solution19 = new Solution19();
         //l1 1->2->3->4->5
         ListNode l1 = new ListNode(1);
         l1.next = new ListNode(2);
         l1.next.next = new ListNode(3);
         l1.next.next.next = new ListNode(4);
         l1.next.next.next.next = new ListNode(5);
         
         //删除倒数第N个节点
         ListNode listNode = solution19.removeNthFromEnd(l1, 2);
         ListNode cur = listNode;
         while (cur != null){
             System.out.println(cur.val);
             cur = cur.next;
         }
        
     }
}
