package huawei.real.score100;

import java.util.Scanner;

/**分治
 * 给航天器一侧加装长方形或正方形的太阳能板（图中的红色斜线区域），需要先安装两个支柱（图中的黑色竖条），再在支柱的中间部分固定太阳能板。但航天器不同位置的支柱长度不同，太阳能板的安装面积受限于最短一侧的那根支柱长度。如图：
 * 现提供一组整形数组的支柱高度数据，假设每根支柱间距离相等为1个单位长度，计算如何选择两根支柱可以使太阳能板的面积最大。
 * 输入描述:
 * 10,9,8,7,6,5,4,3,2,1
 * 注：支柱至少有2根，最多10000根，能支持的高度范围1~10^9的整数。柱子的高度是无序的，例子中递减只是巧合。
 * 输出描述:
 * 可以支持的最大太阳能板面积：（10米高支柱和5米高支柱之间）
 * 25
 * 示例1
 * 输入
 * 10,9,8,7,6,5,4,3,2,1
 * 输出
 * 25
 * 备注:
 * 10米高支柱和5米高支柱之间宽度为5，高度取小的支柱高也是5，面积为25。任取其他两根支柱所能获得的面积都小于25。所以最大的太阳能板面积为25。
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124544351
 */
public class 太阳能板最大面积 {
     // public static void main(String[] args) {
     //     Scanner sc = new Scanner(System.in);
     //     String[] arr = sc.next().split(",");
     //     int res = 0;
     //     for (int i = 0; i < arr.length; i++) {
     //         for (int j = i + 1; j < arr.length; j++) {
     //             int a = Integer.parseInt(arr[i]);
     //             int b = Integer.parseInt(arr[j]);
     //             int c = Math.abs(a - b);
     //             if (a > b) {
     //                 if (res < b * c) {
     //                     res = b * c;
     //                 }
     //             } else {
     //                 if (res < a * c) {
     //                     res = a * c;
     //                 }
     //             }
     //         }
     //     }
     //     System.out.println(res);
     //     }
     //

          public static void main(String[] args) {
              //数组两个元素的间距 乘以 两个元素中的最小值，取最大的，就是太阳能板的最大面积了
              Scanner sc = new Scanner(System.in);
              String line = sc.nextLine();
              String[] split = line.split(",");
              int len = split.length;
              // 结果
              int res = 0;
              for (int i = 0; i < len - 1; i++) {
                  for (int j = i + 1; j < len; j++) {
                      int eare = Math.min(Integer.parseInt(split[i]), Integer.parseInt(split[j])) * (j - i);
                      res = Math.max(res, eare);
                  }
              }
              System.out.println(res);

              }


}
