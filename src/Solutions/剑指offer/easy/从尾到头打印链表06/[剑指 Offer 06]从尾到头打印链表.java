package Solutions.剑指offer.easy.从尾到头打印链表06;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 334 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.Arrays;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    /**
     * 反转链表
     * 将数组返回来遍历赋值即可
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        //如果链表为空--》返回空数组
        if (head == null){
            return new int[0];
        }
        //定义一个链表节点数量
        int headCount =0;
        
        //遍历链表节点-->计算链表节点数量--》给创建的数组长度赋值
        //一定要定义临时链表temp，不能直接用head，因为在遍历的过程中要把下一个节点重新赋值给原来的节点，只有到最后的节点了没有节点遍历了才退出循环，如果用head，遍历完head经过几次赋值后就是空的链表，不能再进行下面的数组反向遍历了
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            headCount++;
        }
        //新建数组
        int[] ints = new int[headCount];
        //从右到左反向遍历数组，i初始值是数组的最后一位，i--，i<0时退出循环
        for (int i = headCount-1; i >= 0; i--) {
            if (head != null){
                ints[i] = head.val;
                head =head.next;
            }
        }

        // int k=headCount-1;
        // while (head != null){
        //     ints[k--] = head.val;
        //     head = head.next;
        // }
        return ints;
    }


     public static void main(String[] args) {
         Solution solution = new Solution();
         ListNode listNode1 = new ListNode(1);
         ListNode listNode2 = new ListNode(3);
         ListNode listNode3 = new ListNode(2);
         //链表节点连线
         listNode1.next = listNode2;
         listNode2.next = listNode3;

         //两个地址相同--》值为1的节点1后面是值为3的链表节点2
         // System.out.println(listNode1.next);
         // System.out.println(listNode2);
         // System.out.println(listNode1.next.val);
         // System.out.println(listNode2.val);

         int[] ints = solution.reversePrint(listNode1);
         System.out.println(Arrays.toString(ints));
     }

}
//leetcode submit region end(Prohibit modification and deletion)
