package huawei.real.score200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 题目描述
 * LISP 语言唯一的语法就是括号要配对。 形如(OP P1 P2 …)，括号内元素由单个空格分割。 其中第一个元素 OP 为操作符，后续元素均为其参数，参数个数取决于操作符类型 注意：参数 P1, P2 也有可能是另外一个嵌套的(OP P1 P2 …) 当前 OP 类型为 add / sub / mul / div（全小写），分别代表整数的加减乘除法简单起见，所有 OP 参数个数均为 2
 *
 * 题目涉及数字均为整数，可能为负；
 * 不考虑 32 位溢出翻转，计算过程中也不会发生 32 位溢出翻转 除零错误时，输出 “error”；
 * 除法遇除不尽，向下取整，即 3 / 2 = 1
 * 输入描述：
 * 输入为长度不超过 512 的字符串，用例保证了无语法错误
 *
 * 输出描述：
 * 输出计算结果或者“error”
 *
 * 举例:
 * 输入：
 * (mul 3 -7)
 * 1
 * 输出：
 * -21
 * 1
 * 输入：
 * (add 1 2)
 * 1
 * 输出：
 * 3
 * 1
 * 输入：
 * (sub (mul 2 4) (div 9 3))
 * 1
 * 输出：
 * 5
 * 1
 * 输入：
 * (div 1 0)
 * 1
 * 输出：
 * error
 * 1
 * 输入：
 * (div 12 (sub 45 45))
 * 1
 * 输出：
 * error
 * ————————————————
 * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/125902077
 */
public class 仿LISP运算 {
    public static void main(String[] args) {

        //仿LISP运算，LISP 语言唯一的语法就是括号要配对
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder dd = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            dd.append(str.charAt(i));
            if (str.charAt(i) == '(') {
                dd.append(" "); }
            if (str.charAt(i + 1) == ')') {
                dd.append(" "); } }
        dd.append(str.charAt(str.length() - 1));
        String ss = dd.toString();
        // System.out.println(ss);
        String[] s1 = ss.split(" ");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : s1) {
            if (s.equals(")")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                String c = stack.pop();
                stack.pop();
                if (c.equals("add")) {
                    stack.push(String.valueOf(a + b));
                } else if (c.equals("sub")) {
                    stack.push(String.valueOf(b - a));
                } else if (c.equals("mul")) {
                    stack.push(String.valueOf(b * a));
                } else if (c.equals("div")) {
                    if (a == 0) {
                        System.out.println("error");
                        return; }
                    stack.push(String.valueOf(b / a)); }
            } else{
                stack.push(s); } }
        System.out.println(stack.pop());


    }
}