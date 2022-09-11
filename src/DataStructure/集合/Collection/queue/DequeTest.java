package DataStructure.集合.Collection.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列Queue的子接口
 * Deque的含义是“double ended queue”，即双端队列，
 * 它既可以当作栈使用，也可以当作队列使用
 *
 * Java堆栈Stack类已经过时，
 * Java官方推荐使用Deque替代Stack使用
 * Deque堆栈操作方法：push()、pop()、peek()
 */
public class DequeTest {
     public static void main(String[] args) {
         //接口不能创建对象，只能创建它对应的实现类
         //Deque<Character> deque = new Deque<>();
         Deque<Character> deque = new LinkedList<>();

         /**
          * Deque有三种用途：一次只能用一种！
          * 普通队列(一端进另一端出):
          * Queue queue = new LinkedList()
          * 双端队列(两端都可进出)
          * Deque deque = new LinkedList()
          * 堆栈
          * Deque deque = new LinkedList()
          */


     }
}
