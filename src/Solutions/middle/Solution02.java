package Solutions.middle;


/**
 * 两数相加
 *给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 输入：l1 = [2,4,3], l2 = [5,6,4]
 输出：[7,0,8]
 解释：342 + 465 = 807.
 示例 2：

 输入：l1 = [0], l2 = [0]
 输出：[0]
 示例 3：

 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 输出：[8,9,9,9,0,0,0,1]
  

 提示：

 每个链表中的节点数在范围 [1, 100] 内
 0 <= Node.val <= 9
 题目数据保证列表表示的数字不含前导零

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

//链表
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution02 {
    /**步骤：
     * 1、按位求和
     * 2、进位
     * 3、如果两个链表长度不一致，末尾进位
     *
     * 长度一致：
     * l1:    2->4->3
     * l2:    5->6->4
     *        7->10->7--》因为节点只能存储0-9需要进位，题目说了每个节点只能存储 一位 数字
     * dummy: 7->0->8
     *
     *
     * 长度不一致
     * l1:    2->4->9
     * l2:    5->6->4->4
     * dmummy:7->0->4->5
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //使用链表构造器构造了一个首节点值为0的虚拟节点，把节点相加的结果一一放到虚拟节点后面
        ListNode dummy = new ListNode();
        //curr为当前指向的节点，每一次相加后都会移动一次当前指针结点
        ListNode curr = dummy;

        //进位数，两节点满十进1时会记录在carry中
        int carry=0;

        //两个节点不为空则遍历
        while (l1 != null || l2 != null){
            //
            int x=0;
            int y=0;
            if ( l1 != null){
                x = l1.val;
            }
            if (l2 != null){
                y = l2.val;
            }
            // int x = l1 == null ? 0 : l1.val;
            // int y = l2 == null ? 0 : l2.val;


            //2+5+0=7
            //和 = A 的当前位 + B 的当前位 + 进位carry
            int sum = x + y + carry;
            //7%10=7，取余记录指针目前在哪个位置，
            //当前位 = 和 % 10;
            curr.next  = new ListNode(sum % 10);
            //移动当前指针结点到下一个节点，让7->下一结点
            curr = curr.next;

            //进位 = 和 / 10;
            carry = sum / 10;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }
        //判断还有进位吗，最后一组数是否满10，满10要另外加一个节点
        if (carry != 0){
            curr.next = new ListNode(carry);
        }

        //dummy.next--》因为构造链表时首节点值是0的虚拟节点，相加结果的节点在虚拟节点首节点后面一个节点
        //逆序链表，所以不需要反转
        return dummy.next;
    }

     public static void main(String[] args) {

         Solution02 solution02 = new Solution02();
         //l1 = 2->4->3, l2 = 5->6->4

         //l1 2->4->3
         ListNode l1 = new ListNode(3);
         l1.next = new ListNode(4);
         l1.next.next = new ListNode(2);

         //l2 5->6->4
         ListNode l2 = new ListNode(4);
         l2.next = new ListNode(6);
         l2.next.next = new ListNode(5);

         //相加后 7->0->8
         ListNode listNode = solution02.addTwoNumbers(l1, l2);

         ListNode cur = listNode;
         while (cur != null){
             System.out.println(cur.val);
             cur = cur.next;
         }

     }
}




