package huawei.real.score100;

import java.util.Scanner;
import java.util.Stack;

/**
 * 消消乐  栈
 *
 * 题目
 * 删除字符串中所有相邻的重复字符/消消乐
 * 请编写函数，对给定的字符串，按相邻的两个相同字符可以消去的原则，在原字符串中反复消去相邻相同的字符，最后输出剩余字符数。
 * 若要求得到的字符串仍保存在原字符数组中，直接在main编写程序即可，或通过返回值对str赋值。
 * 输入样例1：
 * 输入一个字符串（换行表示结束）
 * ceefggabcc
 * 输出样例：
 * cfab，两个相同字符消去；
 *
 * 分析
 * 类似leetcode的20题有效括号，
 * 通过堆栈将无重复的字符写入堆栈，
 * 遇到相同的则弹栈，重复以上步骤
 * 最后输出堆栈倒叙，字符串长度即为堆栈长度
 *
 * 可以把字符串按顺序放到一个栈中，
 * 如果下一个字符和栈头相同的话，就进行弹栈，
 * 不同则进行入栈，
 * 这样最后栈里剩下的元素都是相邻不相同的元素了
 * 
 * 原文链接：https://blog.csdn.net/chengyingcheng0324/article/details/124716306
 */
public class 消消乐 {
    public static String removeDuplicates(String string){
        //1.类似消括号，通过堆栈实现相邻字符串匹配
        if (string.isEmpty()){
            return null;
        }
        /**堆栈stack
         * empty()
         * 测试此堆栈是否为空
         * peek()
         * 查看此堆栈顶部的对象，而不从堆栈中删除它
         * pop()
         * 删除此堆栈顶部的对象，并将该对象作为此函数的值返回
         * push(E item)
         * 将项目推送到此堆栈的顶部
         * search(Object o)
         * 返回一个对象在此堆栈上的基于1的位置
         *
         */
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            //string.charAt(索引):将索引值从字符串转换成字符类型返回，如字符串为“abc”，索引为0的元素返回为'a'，索引为1返回'b'
            //遍历字符串的索引，拿到对应的字符值
            char charAt = string.charAt(i);
            /**
             * 如果
             * 1、堆栈为空
             * 2、栈顶元素（相邻元素）≠遍历获取到的当前字符值
             * 说明相邻元素不重复-->不用消除--》当前字符值入栈
             *
             * 否则
             * 说明相邻元素重复-->两两消除--》将栈顶元素弹出并删除
             *
             */
            if (stack.empty() || stack.peek() != charAt){
                stack.push(charAt);
            }else{
                stack.pop();
            }
        }
        /**跳出循环对剩余的堆栈元素处理：
         * 循环遍历堆栈的元素
         * 如果
         * 1、堆栈不为空
         * 将堆栈的每个元素都要查询出来
         * --》弹栈删除
         * -->返回剩余没重复的字符串
         *
         * 2、堆栈为空
         * （1）说明消消乐之后字符串已经完全消除了
         * 或者
         * （2）弹栈并删除完成
         *
         */
        String str="";
        while ( ! stack.empty()){
            //
            str = stack.pop() + str;
        }

        return str;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String strDiv = removeDuplicates(str);
        System.out.println("消消乐后的字符串：" +strDiv);
    }



}
