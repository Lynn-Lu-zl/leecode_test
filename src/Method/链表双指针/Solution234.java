package Method.链表双指针;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Solution234 {
    /**
     * 先通过 双指针技巧 中的快慢指针来找到链表的中点
     * 快指针走到末尾，慢指针刚好到中间。其中慢指针将前半部分反转
     *
     * 如果 fast 指针没有指向 null，说明链表长度为奇数，slow 还要再前进一步：
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null && head.next == null){
            return true;
        }

        //慢指针
        ListNode slow = head;
        //快指针
        ListNode fast = head;
        //虚拟指针，反转
        ListNode dummy = new ListNode(-1);
        //反转节点
        ListNode rev = head;

        while (fast  != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //
        }






        return false;
    }

     public static void main(String[] args) {
         Solution234 solution234 = new Solution234();
         //l1 1->2->3->4->5
         ListNode l1 = new ListNode(1);
         l1.next = new ListNode(2);
         l1.next.next = new ListNode(3);
         l1.next.next.next = new ListNode(2);
         l1.next.next.next.next = new ListNode(1);
         // l1.next.next.next.next.next = new ListNode(2);
         System.out.println(solution234.isPalindrome(l1));
     }
}
