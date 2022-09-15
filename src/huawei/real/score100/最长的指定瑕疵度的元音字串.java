package huawei.real.score100;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目
 * 最长的指定瑕疵度的元音子串 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 * 开头和结尾都是元音字母（aeiouAEIOU）的字符串为 元音字符串 ，其中混杂的非元音字母数量为其 瑕疵度 。比如:
 * · “a” 、 “aa”是元音字符串，其瑕疵度都为0
 * · “aiur”不是元音字符串（结尾不是元音字符）
 * · “abira”是元音字符串，其瑕疵度为2
 *
 * 给定一个字符串，请找出指定瑕疵度的最长元音字符子串，并输出其长度，如果找不到满足条件的元音字符子串，输出0。
 *
 * 子串：字符串中任意个连续的字符组成的子序列称为该字符串的子串。
 *
 * 输入描述:
 * 首行输入是一个整数，表示预期的瑕疵度flaw，取值范围[0, 65535]。
 * 接下来一行是一个仅由字符a-z和A-Z组成的字符串，字符串长度(0, 65535]。
 *
 * 输出描述:
 * 输出为一个整数，代表满足条件的元音字符子串的长度。
 *
 * 示例1
 * 输入
 * 0
 * asdbuiodevauufgh
 * 输出
 * 3
 * 说明：满足条件的最长元音字符子串有两个，分别为uio和auu，长度为3。
 *
 * 示例2
 * 输入
 * 2
 * aeueo
 * 输出
 * 0
 * 说明：没有满足条件的元音字符子串，输出0
 *
 * 示例3
 * 输入
 * 1
 * aabeebuu
 * 输出
 * 5
 * 说明：满足条件的最长元音字符子串有两个，分别为aabee和eebuu，长度为5
 *
 * 示例4
 * 输入
 * 1
 * abeebuu
 * 输出
 * 5
 * 说明：满足条件的最长元音字符子串有eebuu，长度为5
 *
 * 示例5
 * 输入
 * 1
 * abc
 * 输出
 * 0
 * 说明：满足条件的最长元音字符子串有eebuu，长度为5
 *
 * 示例6
 * 输入
 * 1
 * cab
 * 输出
 * 0
 *
 * 示例7
 * 输入
 * 0
 * bcau
 * 输出
 * 2
 * ————————————————
 * 版权声明：本文为CSDN博主「Winyar Wen」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_42394052/article/details/125341390
 */
public class 最长的指定瑕疵度的元音字串 {
    public static void main(String[] args) {

        //最长的指定瑕疵度的元音字串
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 要求出现的瑕疵数
            int flaw = Integer.parseInt(sc.nextLine());
            // 输入字符串
            String input = sc.nextLine().toLowerCase(Locale.ROOT);
            String str = "aeiou";
            // 统计最大值
            int max = 0;
            for (int i = 0; i < input.length(); i++) {
                // 字符串起始位从i开始，首位不是元音字符的跳过
                if (!str.contains("" + input.charAt(i))) {
                    continue; }
                Stack<Character> stack = new Stack<>();
                // 统计当前瑕疵个数
                int current = 0;
                for (int j = i; j < input.length(); j++) {
                    char c = input.charAt(j);
                    stack.push(c);
                    if (!str.contains("" + c)) {
                        current++;
                        if (current > flaw) {
                            // 清栈，从0开始统计
                            // stack.clear();
                            // current = 0;
                            break; } }
                    // 瑕疵数必须符合要求，最后一个元素必须是元音字符,
                    if (!stack.isEmpty() && current == flaw
                        && str.contains("" + stack.peek()))
                        {max = Math.max(max, stack.size()); } } }
            System.out.println(max); }



    }

}
