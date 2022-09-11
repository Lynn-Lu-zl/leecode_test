package huawei.real.score100;

import java.util.Scanner;

/**
 * 芯片资源限制
 * 题目描述
 * 一个业务芯片的容量为10G,可支持两种不同的业务类型A、B。芯片的约束如下:
 *
 * 1.A业务容量为2.5G,一个芯片上最多可配置4路业务;
 * 2.B业务容量为10G,一个芯片上最多可配置1路业务;
 * 3.由于业务容量限制,配置了A业务后，该芯片就不能配置B业务;
 * 4.不能跨芯片占用资源,即业务只能配置在一块芯片上,不能占用一块芯片的容量,再占用另外芯片容量;
 * 5.为了保证使用最少的芯片资源，业务配置时，按芯片编号从小到大顺序依次配置,并优先使用已经占用的芯片。
 * 由于业务容量最小为2.5G，以最小业务容量为单位，一个芯片可以划分为4个资源区,将资源区依次编号为1,2,3,4。
 *
 * 一块板卡上有M块芯片，用户进行一系列业务配置后，请输出最后一个业务对应的芯片编号和芯片资源D，如果没有可用资源返回0 0.
 *
 * 输入描述
 * 板卡芯片数量M，芯片范围为1-32
 * 用户业务配置数量N,数量为1-128
 * 用户业务配置,业务配置间以空格分割
 *
 * 输出描述
 * 芯片编号 资源区编号
 *
 * 样例1
 * 输入
 5
 6
 A B A B A A
 * 输出
1
 4
 * 说明
 * A：第一块芯片配置A，占用芯片编号：1，资源ID：1，芯片容量未使用完
 * B：第二块芯片配置B，占用芯片编号：2，资源ID：1，芯片容量已经使用完
 * A：由于第一块芯片还能配置，故占用芯片编号：1，资源ID：2
 * B：第一块芯片虽然没有占满，但是A业务和B业务相斥，只能新占用，故占用芯片编号：3，资源ID：1
 * A：由于第一块芯片还能配置，故占用芯片编号：1，资源ID：3
 * A：由于第一块芯片还能配置，故占用芯片编号：1，资源ID：4
 *
 * 思路分析
 * 模拟问题，就按照读入的业务配置，进行判断计算即可。
 * ————————————————
 * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/124236350
 */
public class 芯片资源限制 {
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int M = in.nextInt();
         int N = in.nextInt();
         in.nextLine();
         String[] str = in.nextLine().split(" ");
         int a = 0; // 记录芯片被业务A的使用个数,即芯片资源ID
         int index1 = 1, index2 = 1;  // 未满状态的第一块芯片编号和全空状态的第一块芯片编号
         for (int i = 0; i < N - 1; i++) {  // 前N-1个业务的分配
             if (str[i].charAt(0) == 'A') {
                 if (a + 1 == 4) {
                     a = 0;
                     index1 = index2;
                 } else {
                     a++;
                     if (index1 == index2) {
                         index2++;
                     }
                 }
             } else if (str[i].charAt(0) == 'B') {
                 if (index1 == index2) {
                     index1++;
                     index2++;
                 } else {
                     index2++;
                 }
             }
         }
         // 判断最后一个
         if (str[N - 1].charAt(0) == 'A') {
             if (index1 > M) {
                 System.out.println(0);
                 System.out.println(0);
             } else {
                 System.out.println(index1);
                 System.out.println(a + 1);
             }
         } else {
             if (index2 > M) {
                 System.out.println(0);
                 System.out.println(0);
             } else {
                 System.out.println(index2);
                 System.out.println(1);
             }
         }

         }
}
