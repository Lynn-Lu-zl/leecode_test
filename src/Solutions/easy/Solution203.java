package Solutions.easy;


/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * head不是链表，head只是链表的第一个节点，根据它head.next可以知道整个链表的值
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import LinkList.ListNode;

/**
 * 参数值 头结点head，移除的结点值val
 * 返回值 移除元素后的头结点
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {


        /***
         * 法一：在原链表直接操作，移除节点内容等于val的节点+不设置虚拟头结点
         */

        /**头结点不为空节点，头结点即为目标值
         * 要将头结点的下一结点赋值给头结点，相当于移除目标元素
         * 最坏的情况是链表的节点全部都是目标值，删除值相同的头结点后，可能新的头结点的值相等，用循环解决，移除目标元素后链表为空，所以需要判断链表是否为空
         */

        while (head !=null && head.val == val)
        {
                head = head.next;
        }

        /**
         * 头结点为空节点
         * 即链表为空链表，直接返回null
         * 还有一种特殊情况是链表的节点全部都是目标值，移除目标元素后链表空了
         */

        if (head == null)
        {
            return head;
        }


        /**
         * 头结点不是空节点，开始遍历移动头结点为当前结点，如果遍历到的结点为空则后面都为空，返回当前已遍历过的链表结点
         * 遍历时头结点为目标值
         * 链表的删除操作：2->6->3----2->3
         * 涉及到3个结点的操作，head的前一结点prev，head结点，head的下一结点head.next
         * 当遍历head=6为目标值，将head的前一节点prev=2的下一结点prev.next从原来的head变成连接到head的下一结点head.next=3，
         *
         * 因为头结点没有前结点，遍历时，需要定义当前结点的前一节点prev
         */

        //定义head的前结点
        ListNode prev =  new ListNode();
        //prev的下一个节点为head即prev是head的前结点
        prev.next = head;
        while (prev.next != null)
        {
            //head节点值为目标节点值，删除该节点
            if (prev.next.val == val)
            {
                //head的前一结点连接到head的下一结点
                prev.next = prev.next.next;
            }
            //head节点值不为目标节点值，保留节点，继续右移
            else
            {
                //head节点右移
                prev = prev.next;
            }

        }

        //遍历完成，返回新的链表头结点
        return head;
    }

    /**
     * 法二：在原链表直接操作，移除节点内容等于val的节点+设置虚拟头结点dummyNode
     *虚拟头结点的作用是处理链表的头节点为目标值需要被删除，[7,7,7,7]如果没有虚拟头结点，head遍历移动时只能是head.next从第二个节点7开始判断，会跳过第一个头结点7判断（因为head头结点没有前结点）导致删除元素不完全
     * 在头节点的前面增加虚拟头节点，这样头节点就跟其它节点一样了，不需要单独拎出来考虑头节点为目标值，但是需要注意的是返回的时候，需要返回虚拟头节点的下一节点而不是虚拟头节点
     *时间复杂度：O(n)O(n)，其中 nn 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {

        if (head == null)
        {
            return head;
        }

        //设置虚拟头结点dummyNode
        ListNode dummyNode = new ListNode();
        //定义遍历时头结点的前一节点，性质和dummyNode差不多，但是prevNode是临时值，会随着遍历不断变化，方便最后返回结果链表
        ListNode prevNode = new ListNode();
        //head的前一个结点为虚拟头结点
        dummyNode.next = head;
        //赋值
        prevNode = dummyNode;
        while (prevNode.next !=null)
        {
            if (prevNode.next.val == val)
            {
                prevNode.next = prevNode.next.next;
            }
            else
            {
                prevNode = prevNode.next;
            }
        }
        //遍历完成，返回删除操作后的头节点
        return dummyNode.next;
    }

    /**
     * 法三：双指针
     * 设置两个指针分别指向头节点，pre （记录待删除节点的前一节点）和 cur (记录当前节点)；
     *
     * 遍历整个链表，查找节点值为 val 的节点，找到了就删除该节点，否则继续查找。
     *
     * 找到，将当前节点的前一节点（之前最近一个值不等于 val 的节点）连接到当前节点（cur 节点）的下一个节点（pre->next = cur->next）。
     *
     * 没找到，更新最近一个值不等于 val 的节点（pre = cur），继续遍历（cur = cur->next）

     */
    public ListNode removeElements3(ListNode head, int val) {

        /**头结点不为空节点，头结点即为目标值
         * 要将头结点的下一结点赋值给头结点，相当于移除目标元素
         * 最坏的情况是链表的节点全部都是目标值，删除值相同的头结点后，可能新的头结点的值相等，用循环解决，移除目标元素后链表为空，所以需要判断链表是否为空
         */

        while (head !=null && head.val == val)
        {
            head = head.next;
        }

        /**
         * 头结点为空节点
         * 即链表为空链表，直接返回null
         * 还有一种特殊情况是链表的节点全部都是目标值，移除目标元素后链表空了
         */

        if (head == null)
        {
            return head;
        }

        //记录待删除节点的前一节点
        ListNode pre = new ListNode();
        //记录遍历到的当前节点
        ListNode cur = new ListNode();
        pre.next = head;
        cur = head;

        while (cur != null)
        {
            if (cur.val == val)
            {
                //当前结点为目标值，将当前结点上一节点连接到当前结点的下一个节点，继续遍历
                pre.next = cur.next;
            }
            else
            {
                //当前结点不为目标值，将当前结点更新为上一个结点，继续遍历
                pre = cur;

            }
            //当前结点右移继续遍历
            cur = cur.next;
        }
        return head;
    }

     public static void main(String[] args) {
         Solution203 solution203 = new Solution203();
         //链表 = [1,2,6,3,4,5,6], 目标值val = 6,头结点head = 1, 头结点指针head.next=2

         ListNode listNode7 = new ListNode(6,null);
         ListNode listNode6 = new ListNode(5,listNode7);
         ListNode listNode5 = new ListNode(4,listNode6);
         ListNode listNode4 = new ListNode(3,listNode5);
         ListNode listNode3 = new ListNode(6,listNode4);
         ListNode listNode2 = new ListNode(2,listNode3);
         //特殊
         // ListNode listNode7 = new ListNode(7,null);
         // ListNode listNode6 = new ListNode(7,listNode7);
         // ListNode listNode5 = new ListNode(7,listNode6);
         // ListNode listNode4 = new ListNode(7,listNode5);
         // ListNode listNode3 = new ListNode(7,listNode4);
         // ListNode listNode2 = new ListNode(7,listNode3);
         //头结点head，head不是链表，head只是链表的第一个节点，根据它可以知道整个链表的值
         ListNode head = new ListNode(1,listNode2);
         head.printList();

         int val=6;

         //solution203.removeElements(head,val).printList();
         //solution203.removeElements2(head, val).printList();
         solution203.removeElements3(head, val).printList();



     }
}

