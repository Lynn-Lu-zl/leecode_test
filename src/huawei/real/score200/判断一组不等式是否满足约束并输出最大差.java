package huawei.real.score200;

import java.util.Scanner;

/**
 * 判断一组不等式是否满足约束并输出最大差
 * 题目描述：
 * 判断一组不等式是否满足约束并输出最大差
 *
 * 给定一组不等式，判断是否成立并输出不等式的最大差(输出浮点数的整数部分)， 要求：
 *
 * 1）不等式系数为double类型，是一个二维数组；
 *
 * 2）不等式的变量为int类型，是一维数组；
 *
 * 3）不等式的目标值为double类型，是一维数组；
 *
 * 4）不等式约束为字符串数组，只能是：“>”,“>=”,“<”,“<=”,“=”，例如,不等式组：
 *
 * a11*x1+a12*x2+a13*x3+a14*x4+a15*x5<=b1;
 *
 * a21*x1+a22*x2+a23*x3+a24*x4+a25*x5<=b2;
 *
 * a31*x1+a32*x2+a33*x3+a34*x4+a35*x5<=b3;
 * 1
 * 2
 * 3
 * 4
 * 5
 * 判断一组不等式是否满足约束并输出最大差=max
 * {  (a11*x1+a12*x2+a13*x3+a14*x4+a15*x5-b1),
 *
 * (a21*x1+a22*x2+a23*x3+a24*x4+a25*x5-b2),
 *
 * (a31*x1+a32*x2+a33*x3+a34*x4+a35*x5-b3)  }，
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 类型为整数(输出浮点数的整数部分)
 *
 * 输入描述
 * 1）不等式组系数(double类型)：
 *
 * a11,a12,a13,a14,a15 a21,a22,a23,a24,a25 a31,a32,a33,a34,a35
 * 1
 * 2）不等式变量(int类型)：
 *
 * x1,x2,x3,x4,x5
 * 1
 * 3）不等式目标值(double类型)：
 *
 * b1,b2,b3
 * 1
 * 4）不等式约束(字符串类型):
 *
 * <=,<=,<=
 * 1
 * 输入：
 *
 * a11,a12,a13,a14,a15;
 *
 * a21,a22,a23,a24,a25;
 *
 * a31,a32,a33,a34,a35;
 *
 * x1,x2,x3,x4,x5;
 *
 * b1,b2,b3;
 *
 * <=,<=,<=
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 10
 * 11
 * 输出描述
 * true 或者 false, 判断一组不等式是否满足约束并输出最大差
 *
 * 示例 1：
 * 输入
 * 2.3,3,5.6,7,6;11,3,8.6,25,1;0.3,9,5.3,66,7.8;1,3,2,7,5;340,670,80.6;<=,<=,<=
 * 1
 * 输出
 * false 458
 * 1
 * 说明
 * // 2.3   ×   1   +   3   ×   3   +   5.6   ×   2   +   7   ×   7   +   6   ×   5   -   340 = -238.5
 * // 11   ×   1   +   3   ×   3   +   8.6   ×   2   +   25   ×   7   +   5   ×   1   -   670 = -452.8
 * // 0.3   ×   1   +   9   ×   3   +   5.3   ×   2   +   66   ×   7   +   7.8   ×   5   -   80.6 = 458.3
 * 1
 * 2
 * 3
 * 前两个不满足条件，所以输出为false。
 * 然后计算三个差值中的最大值，取整数部分。
 *
 * 示例 2：
 * 输入
 * 2.36,3,6,7.1,6;1,30,8.6,2.5,21;0.3,69,5.3,6.6,7.8;1,13,2,17,5;340,67,300.6;<=,>=,<=
 * 1
 * 输出
 *
 * false 758
 * 1
 * 2
 * 思路分析
 * 题目臭长，纯模拟问题，这道题充分考察了一个字符串分割，提取，计算，拼接，判断。

 */
public class 判断一组不等式是否满足约束并输出最大差 {
     public static void main(String[] args) {


         Scanner in = new Scanner(System.in); //判断一组不等式是否满足约束并输出最大差
         String[] str = in.nextLine().split(";");
         int num_eq = str[str.length - 1].split(",").length;  // 3,等式的数量
         int num_x = str[0].split(",").length;  // 5，系数和未知数的数量
         double[][] a= new double[num_eq][num_x];
         int[] x = new int[num_x];
         double[] b = new double[num_eq];
         String[] eq = new String[num_eq];
         int[] res = new int[num_eq];
         int max = 0;
         boolean flag = true; // 分别处理a,x,b,符号
         for (int i = 0; i < num_eq; i++) {  // 处理a
             String[] tmp1 = str[i].split(",");
             for (int j = 0; j < tmp1.length; j++) {
                 a[i][j] = Double.valueOf(tmp1[j]); } }
         String[] tmp2 = str[num_eq].split(",");
         for (int i = 0; i < tmp2.length; i++) {  // 处理x
             x[i] = Integer.parseInt(tmp2[i]); }
         String[] tmp3 = str[num_eq + 1].split(",");
         for (int i = 0; i < tmp3.length; i++) {  // 处理b
             b[i] = Double.valueOf(tmp3[i]); }
         String[] tmp4 = str[num_eq + 2].split(",");
         for (int i = 0; i < tmp4.length; i++) {  // 处理符号
             eq[i] = tmp4[i]; }
         for (int i = 0; i < num_eq; i++) {
             double tmp = 0.0;
             for (int j = 0; j < num_x; j++) {
                 tmp += a[i][j] * x[j]; }
             if ("<=".equals(eq[i])) {
                 flag = tmp <= b[i] ? flag && true : flag && false;
             } else if ("<".equals(eq[i])) {
                 flag = tmp < b[i] ? flag && true : flag && false;
             }else if ("=".equals(eq[i])) {
                 flag = tmp == b[i] ? flag && true : flag && false;
             }else if (">=".equals(eq[i])) {
                 flag = tmp >= b[i] ? flag && true : flag && false;
             }else if (">".equals(eq[i])) {
                 flag = tmp > b[i] ? flag && true : flag && false;}
             res[i] =(int) ((tmp - b[i]) / 1); }
         for (int i = 0; i < num_eq; i++) {
             max = Math.max(max, res[i]); }
         System.out.println(flag + " " + max);


         }
}
