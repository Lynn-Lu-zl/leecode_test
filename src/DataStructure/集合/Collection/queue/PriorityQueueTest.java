package DataStructure.集合.Collection.queue;

import java.util.PriorityQueue;

/**
 * 优先级队列（最小堆）
 * 有自动排序功能，最小的元素在队头
 * 二叉堆是一个完全二叉树
 * 二叉堆还分为最大堆和最小堆。
 * 最大堆的性质是：每个节点都大于等于它的两个子节点。
 * 类似的，最小堆的性质是：每个节点都小于等于它的子节点。
 *
 *
 *
 * 优先级队列是基于二叉堆实现的，主要操作是插入和删除。
 * 插入是先插到最后，然后上浮到正确位置；
 * 删除是调换位置后再删除，然后下沉到正确位置。
 *
 * 插入和删除元素的时间复杂度为 O(logK)，K 为当前二叉堆（优先级队列）中的元素总数。
 * 因为我们时间复杂度主要花费在 sink 或者 swim 上，而不管上浮还是下沉，最多也就树（堆）的高度，也就是 log 级别。
 */
public class PriorityQueueTest {
     public static void main(String[] args) {
         // 利用优先级队列自动排序，队头的元素就是最小的
         PriorityQueue<Integer> queue = new PriorityQueue<>();

         //添加，在添加的过程中会自动排序
         queue.offer(20);
         queue.offer(10);
         queue.add(5);
         //查询队头元素（最小）
         System.out.println(queue.peek());
         System.out.println(queue.contains(20));
         // 拿出队头元素（最小）,出队
         queue.poll();
         //删除指定元素
         queue.remove(10);
         System.out.println(queue.peek());
         //清除所有
         queue.clear();
     }
}
