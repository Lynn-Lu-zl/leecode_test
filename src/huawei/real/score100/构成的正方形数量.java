package huawei.real.score100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *  二分
 * 题目描述
 *
 * 输入N个互不相同的二维整数坐标，求这N个坐标可以构成的正方形数量。[内积为零的的两个向量垂直]
 *
 * 输入描述
 *
 * 第一行输入为N，N代表坐标数量，N为正整数。N <= 100
 *
 * 之后的 K 行输入为坐标x y以空格分隔，x，y为整数，-10<=x, y<=10
 *
 * 输出描述
 *
 * 输出可以构成的正方形数量。
 *
 * 示例 1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 3
 *
 * 1 3
 *
 * 2 4
 *
 * 3 1
 *
 * 输出
 *
 * 0 （3个点不足以构成正方形）
 *
 * 示例 2 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 4
 *
 * 0 0
 *
 * 1 2
 *
 * 3 1
 *
 * 2 -1
 *
 * 输出
 *
 * 1
 */
public class 构成的正方形数量 {
     public static void main(String[] args) {

         //正方形数量，求这N个坐标可以构成的正方形数量
         Scanner sc = new Scanner(System.in);
         int num = Integer.parseInt(sc.nextLine());
         List<String> list = new ArrayList<>();
         for (int i = 0; i < num; i++) {
             list.add(sc.nextLine()); }
         int count = 0;
         if (num <= 3) {
             System.out.println(count);
             return; }
         for (int i = 0; i<list.size(); i++) {
             String str = list.get(i);
             String[] split = str.split(" ");
             int x1 = Integer.parseInt(split[0]);
             int y1 = Integer.parseInt(split[1]);
             for (int j = i + 1; j<list.size(); j++) {
                 String str1 = list.get(j);
                 String[] split1 = str1.split(" ");
                 int x2 = Integer.parseInt(split1[0]);
                 int y2 = Integer.parseInt(split1[1]);
                 int x31 = x1 - (y1-y2);
                 int y31 = y1 + (x1-x2);
                 int x41 = x2 - (y1-y2);
                 int y41 = y2 + (x1-x2);
                 int x32 = x1 + (y1-y2);
                 int y32 = y1 - (x1-x2);
                 int x42 = x2 + (y1-y2);
                 int y42 = y2 - (x1-x2);
                 if (list.contains(x31 + " " + y31)
                     && list.contains(x41 + " " + y41))
                 { count++; }
                 if (list.contains(x32 + " " + y32)
                     && list.contains(x42 + " " + y42))
                 { count++; } } }
         System.out.println(count / 4);


     }


}
