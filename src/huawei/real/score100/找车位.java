package huawei.real.score100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 找车位/停车场/最大停车距离  动态规划DP
 * 停车场有一横排车位，0代表没有停车，1代表有车。至少停了一辆车在车位上，也至少有一个空位没有停车。
 *
 * 为了防剐蹭，需为停车人找到一个车位，使得距停车人的车最近的车辆的距离是最大的，返回此时的最大距离。
 *
 * 输入描述
 *
 * 1、一个用半角逗号分割的停车标识字符串，停车标识为0或1，0为空位，1为已停车。
 *
 * 2、停车位最多100个。
 *
 * 输出描述
 *
 * 输出一个整数记录最大距离。
 *
 * 示例1   输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 1,0,0,0,0,1,0,0,1,0,1
 *
 * 输出
 *
 * 2
 *
 * 说明
 *
 * 当车停在第3个位置上时，离其最近的的车距离为2（1到3）。
 *
 * 当车停在第4个位置上时，离其最近的的车距离为2（4到6）。
 *
 * 其他位置距离为1。
 *
 * 因此最大距离为2。
 */
public class 找车位 {
     // public static void main(String[] args) {
     //     Scanner scanner = new Scanner(System.in);
     //     String c = scanner.nextLine();
     //     String replace = c.replace(",", "");
     //     char[] split = replace.toCharArray();
     //     System.out.println(Arrays.toString(split));
     //     int max = 0;
     //     for (int i = 0; i < split.length; i++) {
     //         char s = split[i];
     //         if (s == '0') {
     //             // 下一个位置
     //             int last = replace.indexOf("1", i);
     //             // 上一个位置
     //             int pre = replace.lastIndexOf("1", i);
     //             if (last == -1) {
     //                 last = replace.length() - 1;
     //             }
     //             if (pre == -1) {
     //                 //？
     //                 pre = 100;
     //             }
     //             //取最近的距离
     //             int min = Math.min(last - i, i-pre);
     //             max = Math.max(min, max);
     //         }
     //     }
     //     System.out.println(max);
     // }
    //取出所有已停车的位置的索引，计算其与停车场头的距离、停车场尾的距离、两车之间的距离/2，输出最大的值
     public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
         String line = sc.nextLine();
         String[] split = line.split(",");
         // 存放停车位置的索引
         List<Integer> list = new ArrayList<>();
         for (int i = 0; i < split.length; i++) {
             int num = Integer.parseInt(split[i]);
             if (1 == num) {
                 list.add(i);
             }
         }
         // 第一辆车与停车场头的距离
         int startLen = list.get(0);
         // 最后一辆车与停车场尾的距离
         int endLen = split.length - 1 - list.get(list.size() - 1);
         int res = 0;
         for (int i = 0; i < list.size() - 1; i++) {
             // 停车后与左右车的最小距离
             int len = (list.get(i + 1) - list.get(i)) / 2;
             res = Math.max(res, len);
         }
         // 最大距离
         System.out.println(Math.max(res,Math.max(startLen, endLen)));

         }
}
