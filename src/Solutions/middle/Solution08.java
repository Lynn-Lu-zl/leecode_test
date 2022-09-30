package Solutions.middle;

/**8. 字符串转换整数 (atoi)
 *
 *请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 * 示例 2：
 *
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 *             ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 *              ^
 * 第 3 步："   -42"（读入 "42"）
 *                ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 * 示例 3：
 *
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 *              ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution08 {
    /**
     * 状态机，不同状态
     *
     * 1、去掉前导空格
     *
     * 2、再是处理正负号
     *
     * 3、识别数字，注意越界情况
     * 越界是超出了Integer的取值范围
     * res * 10 + temp > Integer.MAX_VALUE 即为越界-->
     * res > (Integer.MAX_VALUE - temp) / 10
     * @param s
     * @return
     */
    public int myAtoi(String s) {

        int i = 0;
        int len = s.length();
        int sign = 1;
        int res = 0;
        //如果字符串前导位置为空格，循环到有数据的那一个位置
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        //记录一下当前之后所有数据开始的位置
        int start = i;
        for (; i < len; i++) {
            int c = s.charAt(i);
            //判断是否是+，并且+要在初始位置
            if (i == start && c == '+') {
                sign = 1;
                //判断是-
            } else if (i == start && c == '-') {
                sign = -1;
                //判断是数字
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                //如果是数字，其他不用考虑，只需要考虑两种超限的情况，这里不细说，具体去"https://leetcode-cn.com/problems/reverse-integer/"看
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                } else if (res < Integer.MIN_VALUE / 10 || (res ==Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return  Integer.MIN_VALUE;
                }
                res = res * 10 + sign * num;
                //如果有一次循环既不是数字，又不是'+'和'-'，那么立即退出循环，并返回当前res中已经储存的值
            } else {
                break;
            }
        }
        return res;
    }



     public static void main(String[] args) {
         Solution08 solution08 = new Solution08();
         //有符号整数的范围 [−2^31,  2^31 − 1] ，即[-2147483648,2147483647]就返回最值
         String s="7463847412";
         // String s="   -42";
         System.out.println(solution08.myAtoi(s));
     }
}
