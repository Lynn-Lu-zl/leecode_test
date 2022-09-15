package huawei.real.score100;

import java.util.Scanner;
import java.util.Stack;

/**
 * 表达式括号匹配  栈
 *
 * 题目描述
 *
 * (1+(2+3)*(3+(8+0))+1-2)这是一个简单的数学表达式,今天不是计算它的值,而是比较它的括号匹配是否正确。
 *
 * 前面这个式子可以简化为(()(()))这样的括号我们认为它是匹配正确的,
 *
 * 而((())这样的我们就说他是错误的。注意括号里面的表达式可能是错的,也可能有多个空格，对于这些我们是不用去管的，
 *
 * 我们只关心括号是否使用正确。
 *
 * 输入
 *
 * 给出一行表达式(长度不超过 100)。
 *
 * 输出
 *
 * 如果匹配正确输出括号的对数，否则输出-1。
 *
 * 样例
 *
 * 示例 1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * (1+(2+3)*(3+(8+0))+1-2)
 *
 * 输出
 *
 * 4
 */
public class 表达式括号匹配 {
     public static void main(String[] args) {


         //表达式括号匹配
         Scanner scanner = new Scanner(System.in);
         String line = scanner.nextLine();
         if (line.isEmpty()){
             System.out.println(-1); }
         char[] chars = line.toCharArray();
         System.out.println(chars);
         Stack<Character> stack = new Stack<>();
         int count = 0;
         for (char aChar : chars) {
         //栈为空或者栈顶元素为遍历值为左括号则入栈
            if (stack.isEmpty() || aChar == '('){
                stack.push(aChar);
         //这是栈肯定不为空且栈顶元素为左括号
            }else if (aChar == ')'){
                stack.pop();
                count++; } }
         //循环结束后栈为空则输出正确的括号数
         if (stack.empty()){
             System.out.println(count);
         }else {
             //不为空则返回-1
             System.out.println(-1); }


     }
}
