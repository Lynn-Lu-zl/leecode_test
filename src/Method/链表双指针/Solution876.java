package Method.链表双指针;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class Solution876 {


    /**
     * 我们让两个指针 slow 和 fast 分别指向链表头结点 head。
     *
     * 每当慢指针 slow 前进一步，快指针 fast 就前进两步，这样，当 fast 走到链表末尾时，slow 就指向了链表中点。
     *
     * 让快指针是慢指针的2倍
     *
     * 时间复杂度 O(N) ： 其中 N 为链表长度。
     * 空间复杂度 O(1) ： 节点指针 fast , slow 使用常数大小空间。
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        //这个不需要虚拟节点，因为返回的直接就是慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            //快指针走2步
           fast =  fast.next.next;
           //慢指针走1步，两个相差一半，当快指针走完时恰好慢指针在中间
           slow = slow.next;
        }
        //慢指针就在中间节点
        return slow;

    }

     public static void main(String[] args) {
         Solution876 solution876 = new Solution876();
          //l1 1->2->3->4->5
         ListNode l1 = new ListNode(1);
         l1.next = new ListNode(2);
         l1.next.next = new ListNode(3);
         l1.next.next.next = new ListNode(4);
         l1.next.next.next.next = new ListNode(5);
         l1.next.next.next.next.next = new ListNode(6);

         ListNode listNode = solution876.middleNode(l1);
         ListNode cur = listNode;
         while (cur != null){
             System.out.println(cur.val);
             cur = cur.next;
         }
     }
}
