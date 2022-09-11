package huawei.real.score100;

import java.util.Scanner;

/**
 * 题目描述：
 * 给定一个仅包含0和1的N*N二维矩阵，请计算二维矩阵的最大值，计算规则如下：
 *
 * 每行元素按下标顺序组成一个二进制数（下标越大越排在低位），二进制数的值就是该行的值。矩阵各行值之和为矩阵的值。
 * 允许通过向左或向右整体循环移动每行元素来改变各元素在行中的位置。 比如：
 * [1,0,1,1,1]向右整体循环移动2位变为[1,1,1,0,1]，二进制数为11101，值为29。
 * [1,0,1,1,1]向左整体循环移动2位变为[1,1,1,1,0]，二进制数为11110，值为30。
 * 输入描述:
 * 输入的第一行为正整数，记录了N的大小，0 < N <= 20。
 * 输入的第2到N+1行为二维矩阵信息，行内元素半角逗号分隔。
 * 输出描述：
 * 矩阵的最大值。

 5
 1,0,0,0,1
 0,0,0,1,1
 0,1,0,1,0
 1,0,0,1,1
 1,0,1,0,1

 输出：122

 第一行向右整体循环移动1位，得到本行的最大值[1,1,0,0,0]，二进制为11000，十进制为24。
 第二行向右整体循环移动2位，得到本行的最大值[1,1,0,0,0]，二进制为11000，十进制为24。
 第三行向左整体循环移动1位，得到本行的最大值[1,0,1,0,0]，二进制为10100，十进制为20。
 第四行向右整体循环移动2位，得到本行的最大值[1,1,1,0,0]，二进制为11100，十进制为28。
 第五行向右整体循环移动1位，得到本行的最大值[1,1,0,1,0]，二进制为11010，十进制为26。
 总和为24+24+20+28+26=122。


 */
public class 矩阵最大值 {
     public static void main(String[] args) {
              Scanner in = new Scanner(System.in);int n = in.nextInt();
              in.nextLine();
              int total = 0;
              while (n > 0) {
                  String[] matrix = in.nextLine().split(",");
                  total += deal(matrix);
                  n--;
              }
              System.out.println(total);
          }
         private static int deal(String[] matrix) {   // 主函数中调用自定义函数要加static
             int max = 0;
             for (int i = 0; i < matrix.length; i++) {
                 if ("1".equals(matrix[i])) {
                     StringBuilder sb = new StringBuilder();
                     for (int m = i; m < matrix.length; m++) {  // 先加后半部分
                         sb.append(matrix[m]);
                     }
                     for (int n = 0; n < i; n++) {  // 再加前半部分
                         sb.append(matrix[n]);
                     }
                     max = Math.max(max, Integer.parseInt(sb.toString(), 2));  // 字符串转化为相对应的数字
                 }
             }
             return max;
          }


    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int num = Integer.parseInt(sc.nextLine());
    //     //如何把1全部移动到高位0到低位
    //     int total = 0;
    //     for (int i = 0; i < num; i++) {
    //         String[] split = sc.nextLine().split(",");
    //         StringBuilder sb = new StringBuilder();
    //         for (int j = 0; j < num; j++) {
    //             sb.append(split[j]);
    //         }
    //         total += calcMax(sb.toString(), num);
    //     }
    //     System.out.println(total);
    // }
    //
    // //最多移动num次
    // private static int calcMax(String str,int num){
    //     int max = Integer.parseInt(str,2);
    //     while (num>1){
    //         String tem = str.substring(1) + str.charAt(0);
    //         max = Math.max(max,Integer.parseInt(tem,2));
    //         str = tem;
    //         num--;
    //     }
    //     return max;
    // }



}
