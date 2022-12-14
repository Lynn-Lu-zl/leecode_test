package huawei.real.score100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 有m个水果超市在1-n个小时的不同时间段提供不同价格的打折水果，如果某餐厅每个小时都要新采购一种水果给餐厅使用的话， 请选出n个小时内，采购水果的最便宜的花费总和。 （假设m个超市打折时间段可以覆盖n小时）
 *
 * 输入描述
 * N — 总小时数n
 * m — 水果超市个数m
 * X[0]x[1]x[2]—第2~m+1行：每行长度为3的数组，代表各超市在x[0]~x[1]小时（包含[x1]）提供价格为x[2]的水果。
 *
 * 范围提示: 1 <= n < 2^10 （1024）
 *
 * 输出描述
 * 采购水果的最便宜的花费总和。
 *
 * 样例1
 * 输入
 * 4
 * 6
 * 2 3 10--》第2、3个小时价格为10
 * 2 4 20--》第2、4个小时价格为20
 * 1 3 15-->第1、3个小时价格为15
 * 1 4 25--》第1、4个小时价格为25
 * 3 4 8--》第3 、4个小时价格为8
 * 1 4 16--》第1、4个小时价格为16
 *
 *

 * 输出
 * 41
 * 解释
 *
 * 第1小时选15元的水果，-->第一个小时打折水果价格：15、25、16，最便宜是15
 * 第2小时10元水果，--》第2个小时打折水果价格：10、20，最便宜是10
 * 第3选8元水果，--》第3个小时打折水果价格：8、10、15，最便宜是8
 * 第4 小时选8元水果，--》第4个小时打折水果价格：8、25、16，最便宜是8
 * 共15+10+8+8=41。

 */
public class 购买水果最便宜的方案 {
    /**
     * 思路分析
     * 这道题首先是对于水果超市的起始时间和终止时间以及价格的存储，比较方便的一个存储方式就是用二维数组去存（这也是比较常用的方法）。
     *
     * 然后就是一个二维数组排序问题，按照价格从低到高排序，判断水果超市的时间段符合要求，则结束内层循环。
     */
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int m = in.nextInt();
         int[][] arr = new int[m][3];
         for (int i = 0; i < m; i++) {
             arr[i][0] = in.nextInt();
             arr[i][1] = in.nextInt();
             arr[i][2] = in.nextInt();
         }
         Arrays.sort(arr, (a, b) -> (a[2] - b[2]));  // 按价格升序排
         int res = 0;
         for (int i = 1; i <= n; i++) {
             for (int j = 0; j < m; j++) {
                 if (arr[j][0] <= i && arr[j][1] >= i) {
                     res += arr[j][2];
                     break;
                 }
             }
         }
         System.out.println(res);

         }
}
