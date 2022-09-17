package Solutions.剑指offer.easy.包含min函数的栈30;

import java.util.Stack;

public class MinStack {
    /**
     * 定义两个栈
     * 栈1正常出入栈
     * 第一次入栈时两个栈都会同步入栈--》第一次栈2的栈顶元素和栈1的栈顶元素一样--》栈1继续入栈--》比较栈1的入栈元素和栈2的栈顶元素大小--》如果栈1入栈元素比栈2的栈顶元素小则栈2入栈--》意思是栈2后面入栈元素只能比前一个小--》保证调用min函数的栈顶元素都是最小值
     *
     * 因为分出了两个栈存值--》两个栈之间有重复值--》为了保持输入的元素总数一致--》如果栈1出栈元素和栈2栈顶元素相等--》两个要同步出栈
     */

    //定义两个栈，栈1正常出入栈，栈2存比栈底元素小的值
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * 构造函数
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * 入栈
     * @param x
     */
    public void push(int x) {
        stack1.push(x);
        //保证调用min函数的栈顶元素都是最小值
        if (stack2.isEmpty() || stack2.peek() >= x){
            stack2.push(x);
        }

    }

    /**
     * 出栈
     * 如果栈1出栈元素和栈2栈顶元素相等--》两个要同步出栈
     */
    public void pop() {
        if (! stack1.isEmpty()){
            //如果栈1出栈元素和栈2栈顶元素相等--》两个要同步出栈
            if (stack1.peek().equals(stack2.peek())){
                stack2.pop();
            }
            stack1.pop();
        }
    }


    public int top() {
        return stack1.peek();
    }

    public int min() {
        //栈2存的栈顶元素一定是最小值
        return stack2.peek();
    }
}
