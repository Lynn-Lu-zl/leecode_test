package Solutions.easy;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 1 <= s.length <= 104
 *s 仅由括号 '()[]{}' 组成
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 *
 *
 */
public class Solution20 {
    public boolean isValid(String s) {

        //1、字符串括号数量不匹配：字符串长度为单数则匹配无效，要么左括号多，要么右括号多
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        //2、字符串括号类型不匹配
        //pop出栈删除，peek出栈不删除
        Stack<Character> stack = new Stack<>();
        //字符串不能遍历，将字符串转换成数组遍历
        for (char c : s.toCharArray()) {
            //遍历到的左括号入栈
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else
            {
                //如果栈为空即没有左括号入栈，无论如何都不会匹配，返回false
                if (stack.isEmpty())
                {
                    return false;
                }

                //如果栈不为空即有左括号入栈，如果遍历到的右括号和栈顶括号（最后一个左括号）不匹配则返回false，匹配则pop出栈，直到遍历完
                if (c == ')' && stack.pop() !='(')
                {
                    return false;
                }
                if (c == ']' && stack.pop() !='[')
                {
                    return false;
                }
                if (c == '}' && stack.pop() !='{')
                {
                    return false;
                }

            }
        }
            //如果遍历完栈为空，则括号全部匹配有效
            return stack.isEmpty();
        }


        public static void main (String[]args){
            Solution20 solution20 = new Solution20();
            //有效括号，返回true
            String s = "[({";
            System.out.println(solution20.isValid(s));
        }
    }

