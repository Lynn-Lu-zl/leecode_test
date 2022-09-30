package Method.链表双指针;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */
public class Solution141 {

    /**
     * 每当慢指针 slow 前进一步，快指针 fast 就前进两步。
     *
     * 如果 fast 最终遇到空指针，说明链表中没有环；
     * 如果 fast 最终和 slow 相遇，那肯定是 fast 超过了 slow 一圈，说明链表中含有环
     *
     *
     * 大家初高中时候，学校操场的环形跑道上举行万米长跑，跑的快的学生经常会追上跑的慢的学生，也就是跑的快的学生第一次追上跑的慢的学生的时候，实际跑的快的学生比跑的慢的学生多跑了一圈。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            // 慢指针走一步，快指针走两步
            fast = fast.next.next;
            slow = slow.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
     public static void main(String[] args) {

         Solution141 solution141 = new Solution141();
         //l1 1->2->3->4->5
         ListNode l1 = new ListNode(3);
         l1.next = new ListNode(2);
         l1.next.next = new ListNode(0);
         l1.next.next.next = new ListNode(-4);
         // l1.next.next.next.next = new ListNode(5);
         // l1.next.next.next.next.next = new ListNode(6);

         System.out.println(solution141.hasCycle(l1));

     }
}
