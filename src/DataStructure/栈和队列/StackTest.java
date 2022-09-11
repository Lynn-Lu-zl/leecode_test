package DataStructure;

import java.util.Stack;

/**堆栈stack
 * 数据结构：先进后出
 * 方法：
 * 1、empty() 判空
 * 判定此堆栈是否为空
 *
 * 2、push(E item)   压栈
 * 将对象推送到此堆栈的顶部
 *
 * 3、peek()  弹出栈顶元素不删除（相当于查询最顶部的元素，可重复查）
 * 查看此堆栈顶部的对象，而不从堆栈中删除它
 *
 * 4、pop()   弹出栈顶元素并删除（能查只能查一次，下次再查就没了，已经被删除了）
 * 删除此堆栈顶部的对象，并将该对象作为此函数的值返回
 *
 * 5、search(Object o)  查找指定栈元素的位置，从上往下数，栈顶为1，栈底最大，被压的只能当小弟排名靠后
 * 返回一个对象在此堆栈上的基于1的位置
 *
 */
public class StackTest {
     public static void main(String[] args) {
         //基本类型char的包装类:Character
         Stack<Character> stack = new Stack<>();
         //测试此堆栈是否为空
         boolean empty = stack.empty();
         //一开始为true空
         System.out.println("栈顶元素是否为空："+empty);

         //向堆栈压入元素a
         System.out.println("压栈元素："+stack.push('a'));
         //二次判空，为false
         System.out.println("栈顶元素是否为空："+stack.isEmpty());

         //向堆栈弹出栈顶元素，a
         System.out.println("peek弹栈后的栈顶元素："+stack.peek());
         //判空，此时栈顶元素不为空
         System.out.println("栈顶元素是否为空，不为空则未被删除："+stack.empty());

         //向堆栈压入元素b，a被压在b下面
         System.out.println("压栈元素："+stack.push('b'));
         //此时弹出的栈顶元素就变为b
         System.out.println("此时栈顶元素："+stack.peek());

         //弹出栈顶元素并删除（能查只能查一次，下次再查就没了，已经被删除了）
         System.out.println("pop弹栈后返回栈顶元素："+stack.pop());
         //b已经被删除了，a成了栈顶元素
         System.out.println("此时栈顶元素："+stack.peek()+"，说明b已被弹出并删除");

         //向堆栈压入元素b，a被压在c下面
         System.out.println("压栈元素："+stack.push('c'));
         System.out.println("此时栈顶元素："+stack.peek());
         System.out.println("c元素的位置："+stack.search('c'));
         System.out.println("a元素的位置："+stack.search('a'));

         System.out.println("pop弹栈后返回栈顶元素："+stack.pop());
         System.out.println("c已被删除，a元素的位置："+stack.search('a'));



     }
}
