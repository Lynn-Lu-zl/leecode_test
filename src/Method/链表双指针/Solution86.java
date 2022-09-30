package Method.链表双指针;

/**
 * 单链表的分解
 *
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 4在3的前面是因为链表2先遍历的节点值4，4已经在链表中了，后遍历的3只能跟在4后面，现在不是要求排序，只要保证x小的值在x前面即可
 *
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class Solution86 {

    /**
     * 我们可以把原链表分成两个小链表，
     * 一个链表中的元素大小都小于 x，
     * 另一个链表中的元素都大于等于 x，
     * 最后再把这两条链表接到一起
     *
     * [1,4,3,2,5,2]
     * 3
     *合并
     * 处理链表有相同的元素成环一直循环
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        //虚拟链表
        ListNode dummy = head;
        // p1, p2 指针负责生成结果链表
        // 存放小于 x 的链表的虚拟头结点
        ListNode listNode1 = new ListNode(), p1 = listNode1;

        // 存放大于等于 x 的链表的虚拟头结点
        ListNode listNode2 = new ListNode(), p2 = listNode2;

        while ( dummy != null){
            //节点的值比x小放到链表1
            if (dummy.val < x){
                //将dummy节点加到p1中
                p1.next = dummy;
                //p1向前
                p1 = p1.next;
                //x分界问题：当节点值等于x要放在大于等于即链表2后，不然可能会出现1->3->2->2->4->5，因为遍历时节点值3在2前面导致先连接3再连2
            }else if ((dummy.val >= x)){
                p2.next = dummy;
                p2 = p2.next;
            }
            //虚拟节点向前
            // dummy = dummy.next;

            // 断开原链表中的每个节点的 next 指针，不让它看到有重复元素然后成环的机会
            ListNode temp = dummy.next;
            dummy.next =null;
            dummy  = temp;
        }

        //合并链表,因为链表2头结点是0，将链表2头结点的下一个节点给链表1尾节点连上
        p1.next = listNode2.next;

        //因为链表1头结点是0，所以从下一结点开始
        return listNode1.next;
    }



     public static void main(String[] args) {
         Solution86 solution86 = new Solution86();
         //l1 1->2->3->4->5
         ListNode l1 = new ListNode(1);
         l1.next = new ListNode(4);
         l1.next.next = new ListNode(3);
         l1.next.next.next = new ListNode(2);
         l1.next.next.next.next = new ListNode(5);
         l1.next.next.next.next.next = new ListNode(2);
         int x=3;
         ListNode listNode = solution86.partition(l1, x);

         ListNode cur = listNode;
         while (cur != null){
             System.out.println(cur.val);
             cur = cur.next;
         }
     }

}
