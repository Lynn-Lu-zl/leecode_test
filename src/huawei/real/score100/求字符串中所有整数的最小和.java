package huawei.real.score100;

import java.util.Scanner;

/**
 * 题目描述
 *
 * 输入字符串s，输出s中包含所有整数的最小和。
 *
 * 说明
 *
 * 字符串s，只包含 a-z A-Z ± ；
 * 合法的整数包括
 *
 * 1） 正整数 一个或者多个0-9组成，如 0 2 3 002 102
 * 2）负整数 负号 – 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 *
 * 输入描述
 *
 * 包含数字的字符串
 *
 * 输出描述
 *
 * 所有整数的最小和
 *
 * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * bb1234aa
 *
 * 输出
 *
 * 10
 *
 * 示例2  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * bb12-34aa
 *
 * 输出
 *
 * -31
 *
 * 说明
 *
 * 1+2+（-34） = 31
 */
public class 求字符串中所有整数的最小和 {
    public static void main(String[] args) {


        //整数最小和，输出s中包含所有整数的最小和
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = (line + "+").toCharArray();
        // 定义一个标记,是否是‘-’后面的数字，如果是的话就把数字串起来最大
        boolean flag = false;
        StringBuilder sb = new StringBuilder(); // 用来拼接负数字符
        int sum_min = 0;
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) { //判断是否为数字
                if (flag) {
                    sb.append(aChar); // 如果负数就先拼接
                } else {// 其他符号后面的直接计算，才能得到最小正数
                    sum_min += aChar - 48; }
                continue; } // 把前面拼接好的字符串计算出来，并且置空
            if (flag && sb.length() != 0) {
                sum_min -= Integer.parseInt(sb.toString());
                sb.setLength(0); }
            flag = aChar == '-'; }// 遇到负号改变标记
            System.out.println(sum_min);


    }
    /**
     * 法二
     */
    // public static void main(String[] args) {
    //     //整数最小和，输出s中包含所有整数的最小和
    //     Scanner in = new Scanner(System.in);
    //     String str = in.nextLine();
    //     char[] ch = str.toCharArray();
    //     int sum = 0;
    //     boolean flag = false; // 负数
    //     StringBuilder sb = new StringBuilder();
    //     for (char c : ch) {
    //         if (c >= '0' && c <= '9') {  // 如果是数字
    //             if (flag) {  // 如果是负号后面的数字，加到sb中
    //                 sb.append(c);
    //             } else {  // 正数直接求和
    //                 sum += Integer.parseInt(c + ""); }
    //         } else if ('-' == c) {  // 如果是'-'
    //             if (flag) {
    //                 // 遇到负号后，将负号后面的连续数字组成字符串
    //                 if (!sb.toString().isEmpty()) { // 如果sb不空
    //                     sum -= Integer.parseInt(sb.toString());
    //                     sb = new StringBuilder(); } }
    //             flag = true;
    //         } else {  // 其它字符
    //             flag = false;// 用来判断负号后的字符串结束
    //             // 队列不空，说明负号字符串到此为止，将去整体
    //             if (!sb.toString().isEmpty()) {
    //                 sum -= Integer.parseInt(sb.toString());
    //                 sb = new StringBuilder(); } } }
    //     if (flag) {
    //         if (!sb.toString().isEmpty()) {
    //             sum -= Integer.parseInt(sb.toString()); } }
    //     System.out.print(sum);
    // }


    /**
     * 法3
     */
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String line = sc.nextLine();
    //     // 将字符串转为字符数组
    //     char[] chars = line.toCharArray();
    //     // 累加结果
    //     int sum = 0;
    //     for (int i = 0; i < chars.length; i++) {
    //         char c = chars[i];
    //         if (c == '-') {
    //             int start = i;
    //             i++;
    //             while (i < chars.length && Character.isDigit(chars[i])) {
    //                 i++;
    //             }
    //             // 截取负数
    //             String substring = line.substring(start, i);
    //             // 当substring = 1时只有一个负号
    //             if (substring.length() > 1) {
    //                 sum += Integer.parseInt(substring);
    //             }
    //         }
    //
    //         // 判断字符是不是数字
    //         if (Character.isDigit(c)) {
    //             // 将字符数字转为数字,当字符数字小于第二个参数时，返回-1
    //             sum += Character.digit(c, 10);
    //         }
    //     }
    //
    //     System.out.println(sum);
    // }
}
