package huawei.soeasy;

import java.util.Scanner;

/***
 * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
 * 本题含有多组样例输入。
 * 数据范围：字符串长度 1 \le n \le 200 \1≤n≤200 ， 保证每组输入都至少含有一个数字
 *
 * 描述:
 * 输入：输入一个字符串。1<=len(字符串)<=200
 * 输出：输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
 *
 * 示例1
 * 输入
 * abcd12345ed125ss123058789
 * a8a72a6a5yy98y65ee1r2
 *
 * 输出
 * 123058789,9
 * 729865,2
 *
 * 说明：
 * 样例一最长的数字子串为123058789，长度为9
 * 样例二最长的数字子串有72,98,65，长度都为2
 */
public class HJ92在字符串中找出连续最长的数字串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StringBuilder digitalStr = new StringBuilder();
            StringBuilder digitalStr1 = findDigitalStr(line, digitalStr, 0, 0);
            System.out.println(digitalStr1.toString());
        }



    }

    private static StringBuilder findDigitalStr(String line, StringBuilder digitalStr, int index, int count) {
        if (index >= line.length()) {
            return digitalStr.append(",").append(count);
        }
        StringBuilder temp = new StringBuilder();
        for (int i = index; i < line.length(); i++) {
            index++;
            char c = line.charAt(i);
            if (47 < c && c < 58) {
                temp.append(c);
                continue;
            }

            break;
        }
        if (temp.length() > 0 && temp.length() == count) {
            digitalStr.append(temp);
        }
        if (temp.length() > count) {
            count = temp.length();
            digitalStr = temp;
        }
        return findDigitalStr(line, digitalStr, index, count);

    }
}
