package huawei.real.score100;

import java.util.Scanner;
import java.util.Stack;

/**
 * 现有一字符串仅由 ‘(‘，’)’，'{‘，’}’，'[‘，’]’六种括号组成。
 *
 * 若字符串满足以下条件之一，则为无效字符串：
 *
 * ①任一类型的左右括号数量不相等；
 *
 * ②存在未按正确顺序（先左后右）闭合的括号。
 *
 * 输出括号的最大嵌套深度，若字符串无效则输出0。
 *
 * 0≤字符串长度≤100000
 *
 * 输入描述:
 *
 * 一个只包括 ‘(‘，’)’，'{‘，’}’，'[‘，’]’的字符串
 *
 * 输出描述:
 *
 * 一个整数，最大的括号深度
 *
 * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * []
 *
 * 输出
 *
 * 1
 *
 * 说明
 *
 * 有效字符串，最大嵌套深度为1
 *
 * 示例2  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * ([]{()})
 *
 * 输出
 *
 * 3
 *
 * 说明
 *
 * 有效字符串，最大嵌套深度为3
 *
 * 示例3  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * (]
 *
 * 输出
 *
 * 0
 *
 * 说明
 *
 * 无效字符串，有两种类型的左右括号数量不相等
 *
 * 示例4  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * ([)]
 *
 * 输出
 *
 * 0
 *
 * 说明
 *
 * 无效字符串，存在未按正确顺序闭合的括号
 *
 * 示例5  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * )(
 *
 * 输出
 *
 * 0
 *
 * 说明
 *
 * 无效字符串，存在未按正确顺序闭合的括号。
 */
public class 最大括号深度 {
     public static void main(String[] args) {
         //最大括号深度
         Scanner in = new Scanner(System.in);
         String s = in.nextLine();
         if (s.equals("")) {// 字符串为空
             System.out.println(0);
             return ; }
         Stack<Character> stack = new Stack<>();
         int i = 0;
         int max = 0;
         for (i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (c == '(' || c == '{' || c == '['){
                 stack.push(c);
                 max = Math.max(max, stack.size());
             } else {  // 第一个是右括号，直接break
                 if (stack.size() == 0) {  //
                     break; }
            // 判断括号是否匹配
                 if (c == ')'){
                     if (stack.pop() == '('){
                         continue; }
                 } else if (c == ']') {
                     if (stack.pop() == '['){
                         continue; }
                 } else {
                     if (stack.pop() == '{'){
                         continue; } }
                 break; } }
         if (i == s.length() && stack.size() == 0){
             System.out.println(max);
         } else {
             System.out.println(0);}


     }
}
