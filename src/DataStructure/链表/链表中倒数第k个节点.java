package DataStructure.链表;

/**
 * 题目：输入一个链表，输出该链表中倒数第k个节点。
 *
 * 解题思路：快慢指针，先让快指针走k步，然后两个指针同时走，当快指针到头时，慢指针就是链表倒数第k个节点。
 * 使用双指针可以不用统计链表长度。
 *
 * 初始化：前指针，后指针，双指针都指向头节点head
 * 构建双指针距离：前指针先向前走k步
 * 双指针同时移动：循环，直到前指针到尾节点跳出，后指针指向倒数第k个节点
 * 返回值：返回后指针即可
 * ————————————————
 * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/114690505
 */
public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null||k<=0)
        {
            return null;
        }
        //定义两个指针节点
        ListNode pre=head;
        ListNode last=head;
        //先将一个节点往后移动k-1个距离
        while(pre!=null && k>0){
            pre=pre.next;
            k--;
        }
        //一起移动，第一个节点移动到末尾，第二个结点移动到倒数第k个节点
        while(pre!=null)
        {
            pre=pre.next;
            last=last.next;
        }
        return last;
    }

     public static void main(String[] args) {
         链表中倒数第k个节点 链表中倒数第k个节点 = new 链表中倒数第k个节点();
         ListNode listNode = new ListNode(2);
         listNode.val=10;
         ListNode node = 链表中倒数第k个节点.getKthFromEnd(listNode, 5);
         System.out.println(node);
     }

}
