package Solutions.剑指offer.easy.用两个栈实现队列09;

import java.util.Stack;

public class CQueue {
    //定义两个栈
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * 栈：先进后出
     * 队列：先进先出
     * 两个顺序是反的--》所以借助2个栈的压入栈作顺序调换
     *
     * 1 2 3
     * 1、定义两个栈
     * 2、先将元素都压入栈1（从上到下 3 2 1）-->相当于入队appendTail
     * 3、判断栈2是否为空--》栈2为空则将栈1全部元素弹出（从栈顶开始弹出，栈顶3-1）--》接着压入栈2（从上到下 1 2 3）
     * 4、栈2全部元素弹出（先弹栈顶1到3）--》相当于出队deleteHead
     *
     *
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [ 入队[],      出队  [],     入队 [5],   入队 [2],    出队 [],     出队 []]
     *
     *
     * [null,-1,null,null,5,2]
     *
     * 输出值解析：
     * CQueue 返回值空--》null
     * deleteHead：若队列中没有元素，deleteHead 操作返回 -1--》-1
     * appendTail 方法返回值空--》null
     * appendTail 方法返回值空--》null
     * deleteHead：按入队顺序出队--》返回值5
     * deleteHead：按入队顺序出队--》返回值2
     */
    public CQueue() {
        //构造函数，两个栈实现队列--》两个栈
        stack1= new Stack<>();
        stack2= new Stack<>();
    }

    /**栈1入栈
     * 队列尾部插入整数--入队
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);

    }


    /**队列头部删除整数---出队
     *
     * 判断栈2是否为空--》
     * 1、不为空：弹出栈2元素
     * 2、为空：栈1遍历出栈直到为空--》压入栈2--》栈2弹出栈元素
     *
     * 如果栈1、栈2都为空--》返回-1
     *
     * @return
     */
    public int deleteHead() {

        if ( ! stack2.isEmpty()){
            return stack2.pop();
        }
        //为空
        if ( ! stack1.isEmpty() ){
            while ( ! stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            //出队
            return stack2.pop();
        }
        return -1;
    }

     public static void main(String[] args) {
         /**
          *      * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
          *      * [ 入队[],      出队  [],     入队 [5],   入队 [2],    出队 [],     出队 []]
          *      *
          *      *
          *      * [null,-1,null,null,5,2]
          */
         CQueue cQueue = new CQueue();
         cQueue.deleteHead();
         cQueue.appendTail(5);
         cQueue.appendTail(2);
         cQueue.deleteHead();
         cQueue.deleteHead();


     }
}
