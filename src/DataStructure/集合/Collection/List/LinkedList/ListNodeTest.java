package DataStructure.List.LinkList;


/**
 * 定义一个内部类，链表结点
 * 链表结点结构
 * 每个结点都有两个值
 * val结点值
 * next 结点指针
 */
public class ListNodeTest {

    public static void main(String[] args) {

        //报错，null不能重写
        ListNode pre = null;
        //System.out.println(pre.toString());

        //空构造器，默认 val=0, next=null
        ListNode pre2 = new ListNode();
        System.out.println(pre2.toString());

        //有参构造，完整链表
        ListNode listNode7 = new ListNode(7,null);
        ListNode listNode6 = new ListNode(6,listNode7);
        ListNode listNode5 = new ListNode(5,listNode6);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode = new ListNode(1,listNode2);
        System.out.println(listNode.toString());

        //
        System.out.println("----------head---------------");
        ListNode head = new ListNode(10,listNode);
        //System.out.println("head的val和指针结点："+head.toString());
        System.out.println("head的val:"+head.val);
        head.next.printList();
        head.printList();
        System.out.println("----------head---------------");
        //初始化+赋值，初始化多余
        //ListNode cur = new ListNode();
        //cur = head;
        //初始化+赋值直接一步到位，赋值的是val+next
        ListNode cur = head;
        //System.out.println("cur的val和指针结点："+cur.toString());

        //
        System.out.println("----------pre3---------------");
        ListNode pre3 = new ListNode(100,listNode6);
         System.out.println("pre3的val："+pre3.val);
         pre3.next.printList();
         pre3.printList();
        System.out.println("----------pre3---------------");
        // System.out.println("pre3的指针结点："+pre3.next.toString());
        // System.out.println("pre3的val和指针结点："+pre3.toString());
        //pre3的指针结点赋值给head的指针结点，head的val不变

        // System.out.println("pre3指针结点赋值给head的指针结点后head的val和指针结点："+head.toString());

        //pre3的指针结点赋值给head后，head的val变成pre3指针结点的val，head的指针结点变成pre3指针结点的指针结点
        // head = pre3.next;
        // System.out.println("pre3的指针结点赋值给head后的val+指针结点"+head.toString());

        //把pre3的val+next赋值head的指针结点，head的val不变，head的next=pre3的val+next
        // System.out.println("----------head.next = pre3---------------");
        // head.next = pre3;
        // System.out.println(head.val);
        // head.next.printList();
        // head.printList();
        // System.out.println("----------head.next = pre3---------------");

        //pre3的next赋值给head的next，head的val不变，head的next=pre3的next
        // System.out.println("----------head.next = pre3.next---------------");
        // head.next = pre3.next;
        // System.out.println(head.val);
        // head.next.printList();
        // head.printList();
        // System.out.println("----------head.next = pre3.next---------------");

        //pre3的next赋值给head,head的val+next=pre3指针结点的val+next
        System.out.println("----------head = pre3.next---------------");
        head = pre3.next;
        System.out.println(head.val);
        head.next.printList();
        head.printList();
        System.out.println("----------head = pre3.next---------------");
    }
}





