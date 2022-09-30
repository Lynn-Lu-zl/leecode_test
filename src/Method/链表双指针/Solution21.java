package Method.链表双指针;


/**单链表合并
 *
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class Solution21 {



    /**
     * 链表
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
    }


    /**
     * while 循环每次比较 p1 和 p2 的大小，把较小的节点接到结果链表上
     *
     * 这个算法的逻辑类似于拉拉链，l1, l2 类似于拉链两侧的锯齿，指针 p 就好像拉链的拉索，将两个有序链表合并；或者说这个过程像蛋白酶合成蛋白质，l1, l2 就好比两条氨基酸，而指针 p 就好像蛋白酶，将氨基酸组合成蛋白质。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //新的链表头结点
        ListNode dummy = new ListNode(-1);
        //链表节点
        ListNode p = dummy;
        //链表1的左指针
        ListNode p1 = list1;
        //链表2的左指针
        ListNode p2 = list2;

        //只要链表没有到尽头就循环
        //&&与，只要有一个不符合条件就退出循环
        while (p1 != null && p2 != null){
            //一开始就是升序链表，只要比较哪个链表的节点谁小就把该原链表的节点加入到新链表中
            //链表1比链表2的值小
            if (p1.val < p2.val){
                //p1的节点放到新链表
                p.next = p1;
                //p1向前
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            //节点连接完成，p向前
            p = p.next;
        }
        //处理两个链表长度不一致
        //如果链表1空了但是2还有值，直接将链表2剩下的值都加到新链表中
            if (p1 == null){
                p.next = p2;
            }else {
                p.next = p1;
            }

        return dummy.next;
    }



     public static void main(String[] args) {
         Solution21 solution21 = new Solution21();
         //l1 1->2->3->4->5
         ListNode l1 = new ListNode(1);
         l1.next = new ListNode(2);
         l1.next.next = new ListNode(3);
         l1.next.next.next = new ListNode(4);
         l1.next.next.next.next = new ListNode(5);

         ListNode l2 = new ListNode(1);
         l2.next = new ListNode(3);
         l2.next.next = new ListNode(4);
         // l2.next.next.next = new ListNode(4);
         // l2.next.next.next.next = new ListNode(5);


         ListNode listNode = solution21.mergeTwoLists(l1, l2);
         ListNode cur = listNode;
         while (cur != null){
             System.out.println(cur.val);
             cur = cur.next;
         }

     }


}
