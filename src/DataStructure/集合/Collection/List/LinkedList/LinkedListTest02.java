package DataStructure.List.LinkList;

import java.util.LinkedList;

public class LinkedListTest02 {
     public static void main(String[] args) {
         /**
          * 创建链表
          * 链表≠链表结点LinkNode,一个链表可以有很多个结点
          */
         LinkedList<Integer> linkedList = new LinkedList<>();

         /**
          * 添加元素
          * add(元素)
          * 时间复杂度O(1)，每次在尾部添加元素
          */
         linkedList.add(1);
         linkedList.add(2);
         linkedList.add(3);
         System.out.println("添加元素后的链表："+linkedList.toString());

         /**
          * 插入元素
          * add(插入元素索引, 插入元素)
          * 时间复杂度O(N)，在指定位置插入，多了找到索引这一步，相当于遍历N个元素
          */
         linkedList.add(2, 99);
         System.out.println("插入元素后的链表："+linkedList.toString());

         /**
          * 访问元素
          *get(元素索引)，根据索引访问元素
          * 时间复杂度O(N)
          */
         System.out.println("链表根据索引访问对应的元素："+linkedList.get(0));
         //头元素
         System.out.println("链表头元素："+linkedList.getFirst());
         //尾元素
         System.out.println("链表尾元素："+linkedList.getLast());

         /**
          *搜索元素
          *indexOf(元素)，根据元素搜索索引
          * 时间复杂度O(N)，因为不知道元素位置要遍历N个元素
          */
         System.out.println("链表根据元素搜索对应的索引："+linkedList.indexOf(99));

         /**
          * 更新元素
          * set(元素索引,更新的元素)
          * 时间复杂度O(N)，因为不知道元素位置要遍历N个元素
          */
         linkedList.set(2,88);
         System.out.println("更新元素后的链表："+linkedList.toString());

         /**
          * 删除元素
          * remove(元素索引)，根据索引删除元素，不能根据元素删除，如果有重复元素无法辨别要删除哪个
          * 时间复杂度O(N)
          */
         //linkedList.remove(2);
         System.out.println("根据索引删除元素后的链表"+linkedList.toString());

         /**
          * 链表长度
          * size()
          * 时间复杂度O(1)
          */
         System.out.println("链表长度："+linkedList.size());
     }
}
