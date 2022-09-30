package Method.链表双指针;

import java.util.HashSet;

/**
 * 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 */
public class Solution142 {
    /**
     通过HashSet来保存链表节点，对链表进行遍历，如果链表不存在环则每个节点都会被存入环中，但是当链表中存在环时，则会发重复存储链表节点的情况，所以当我们发现HashSet中含有某节点时说明该节点为环的入口，返回即可。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        if (head == null){
            return head;
        }
        if (head.next == null){
            return head.next;
        }
        while (head != null){
            if (set.contains(head)){
                return head;
            }else{
                set.add(head);
            }
            head = head.next;
        }

        return head;
    }
}
