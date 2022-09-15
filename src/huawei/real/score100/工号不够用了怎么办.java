package huawei.real.score100;

import java.util.Scanner;

/**
 * 3020年，空间通信集团的员工人数突破20亿人，即将遇到现有工号不够用的窘境。
 * 现在，请你负责调研新工号系统。继承历史传统，新的工号系统由小写英文字母（a-z）和数字（0-9）两部分构成。新工号由一段英文字母开头，之后跟随一段数字，比如"aaahw0001",“a12345”,“abcd1”,“a00”。注意新工号不能全为字母或者数字,允许数字部分有前导0或者全为0。
 * 但是过长的工号会增加同事们的记忆成本，现在给出新工号至少需要分配的人数X和新工号中字母的长度Y，求新工号中数字的最短长度Z。
 * 输入描述:
 * 一行两个非负整数 X Y，用数字用单个空格分隔。
 * 0< X <=2^50 - 1
 * 0< Y <=5
 * 输出描述:
 * 输出新工号中数字的最短长度Z
 * 示例1
 * 输入
 * 260 1
 * 输出
 * 1
 * 示例2
 * 输入
 * 26 1
 * 输出
 * 1
 * 说明
 * 数字长度不能为0
 * 示例3
 * 输入
 * 2600 1
 * 输出
 * 2
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124390802
 */
public class 工号不够用了怎么办 {

    public static void main(String[] args) {
        //工号不够用了怎么办
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt(), y = sc.nextInt();
            int result = Math.max(1, (int) Math.log10(x / Math.pow(26, y)));
            System.out.printf("%d\n", result);
        }
    }
}
