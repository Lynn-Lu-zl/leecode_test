package LinkList;

/**
 * LinkedListTest01：定义一个内部类，代表单链表的结点
 * val：结点数据
 * next：指向下一个结点的引用，指针
 *
 */
public class LinkedListTest01 {
    //结点数据
    int val;

    //指向下一个结点的引用
     LinkedListTest01 next;

     //结点的无参构造
      LinkedListTest01() {}

      //结点的有参构造，给当前结点的数据赋值
      LinkedListTest01(int val) {
          this.val = val;
      }

      //结点的有参构造，普通结点都有结点数据+指向下一个结点的引用
      LinkedListTest01(int val, LinkedListTest01 next) {
          this.val = val;
          this.next = next;
      }
}

/**
 * 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 两个已知链表对象ListNode l1, LinkedListTest01 l2
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 逆序存储--》
 * 链表对象l1真正的数据是342，链表对象l2真正的数据是465，计算得出相加的真正数据是807
 * 又因为是逆序存储
 * 输出的数据是708
 */
// class Solutions.easy.Solution1 {
//     public LinkedListTest01 addTwoNumbers(LinkedListTest01 l1, LinkedListTest01 l2) {
//
//
//     }
//
// }

 //public static void main(String[] args) {

   //  Solutions.easy.Solution1 s = new Solutions.easy.Solution1();
 /*    //链表l1的结点
     LinkedListTest01 l1 = new LinkedListTest01(3);
     l1 = new LinkedListTest01(4,l1);
     l1 = new LinkedListTest01(2,l1);
     System.out.print(l1.val);
     System.out.print(l1.next.val);
     System.out.println(l1.next.next.val);
     System.out.println("-----------------");

     LinkedListTest01 l2 = new LinkedListTest01(4);
     l2 = new LinkedListTest01(6,l2);
     l2 = new LinkedListTest01(5,l2);
     System.out.print(l2.val);
     System.out.print(l2.next.val);
     System.out.println(l2.next.next.val);



     LinkedListTest01 l3 = s.addTwoNumbers(l1,l2);
     System.out.println("-----------------");
     System.out.print(l3.val);
     System.out.print(l3.next.val);
     System.out.println(l3.next.next.val);
 */

     // //法二
     // // 创建两个链表
     // // 第一个链表:  1-> 8 -> 7 -> 6  (在做加法运算代表的是6781)
     // LinkedListTest01 l1 = new LinkedListTest01(1);  // 这是第一个链表的第一个节点(不能用这个节点去往下加数据)
     // // 必须有一个指针去往第一个节点上去加数据
     // LinkedListTest01 p = l1;  // 这个指针节点会从链表的第一个节点一直往下走(直至最后一个节点)
     // p.next = new LinkedListTest01(8);
     // p = p.next;
     //
     // p.next = new LinkedListTest01(7);
     // p = p.next;
     //
     //
     // p.next = new LinkedListTest01(6);
     //
     //
     //
     // // 第二个链表
     // LinkedListTest01 l2 = new LinkedListTest01(9);
     // LinkedListTest01 q = l2;
     // q.next = new LinkedListTest01(9);
     // q = q.next;
     // q.next = new LinkedListTest01(9);
     // q = q.next;
     // q.next = new LinkedListTest01(9);
     //
     // LinkedListTest01 re = s.addTwoNumbers(l1, l2);
     // while(re != null) {
     //     System.out.println(re.val);
     //     re = re.next;
     // }

//  }
// }