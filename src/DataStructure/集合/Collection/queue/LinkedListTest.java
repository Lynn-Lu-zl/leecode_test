package DataStructure.栈和队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**双向队列接口
 * Deque接口与Stack对应的方法
 *Deque父接口：Queue
 * 接口实现类：LinkedList
 *
 * 第一个元素 (头部)	最后一个元素 (尾部)
 * 抛出异常	特殊值	抛出异常	特殊值
 * 插入	addFirst(e)	offerFirst(e)	addLast(e)	offerLast(e)
 * 删除	removeFirst()	pollFirst()	removeLast()	pollLast()
 * 查看	getFirst()	peekFirst()	getLast()	peekLast()
 *
 */
public class LinkedListTest {
     public static void main(String[] args) {

         /**
          * 队列当堆栈使用
          */
         Deque<Character> deque = new LinkedList<>();
         Queue<Character> queue = new LinkedList<>();
         Stack<Character> stack = new Stack<>();
         //栈顶添加元素
         //失败抛出异常
         deque.addLast('a');
         //失败返回false
         deque.offer('a');

         stack.push('a');

         //获取并删除栈顶元素
         //失败抛出异常
         deque.removeFirst();
         //失败返回null
         deque.poll();
         deque.pollFirst();
         stack.pop();

         //获取不删除栈顶元素
         deque.peek();
         deque.peekFirst();
         stack.peek();


         /**
          * 队列使用
          */
         //获取队列首元素
         queue.element();
         deque.getFirst();


     }
}
