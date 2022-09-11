package huawei.real.score100;

import java.util.Arrays;
import java.util.Scanner;

/**停车场车辆统计
 * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3），统计停车场最少可以停多少辆车，返回具体的数目。
 * 输入描述:
 * 整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
 * 输出描述:
 * 整型数字字符串，表示最少停车数目。
 * 示例1
 * 输入
 * 1,0,1
 * 输出
 * 2
 * 说明
 * 1个小车占第1个车位
 * 第二个车位空
 * 1个小车占第3个车位
 * 最少有两辆车
 * 示例2
 * 输入
 * 1,1,0,0,1,1,1,0,1
 * 输出
 * 3
 * 说明
 * 1个货车占第1、2个车位
 * 第3、4个车位空
 * 1个卡车占第5、6、7个车位
 * 第8个车位空
 * 1个小车占第9个车位
 * 最少3辆车
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124544351
 */
public class 停车场车辆统计 {
     public static void main(String[] args) {
         /**
          *
          * 1,1,0,0,1,1,1,0,1
          *
          * 最少车辆--》说明什么都按最多的分量计算--》
          * 1、0就是没车
          * 2、只有1个1就是一辆小车
          * 2、2个1连续就是一辆货车，
          * 3、3个1连续就是一辆卡车
          *
          * 把0当成分割点--》[11, 111, 1]
          * 两层循环：
          * 循环整数数组--》
          * 对截取的每段索引值的长度进行取模--》
          * 循环获取每段索引值的长度
          * 该索引值长度%3=0--》卡车
          * 该索引值长度%2=0--》货车
          * 剩下是汽车
          * 
          * 操作完要对索引值长度清零
          * 
          */
         // Scanner scanner = new Scanner(System.in);
         // String line = scanner.nextLine();
         // String[] strings = line
         //     .replaceAll(",", "")
         //     .replaceAll("0+","0")
         //     .split("0");
         // //1,1,0,0,1,1,1,0,1--》[11, 111, 1]
         // System.out.println(Arrays.toString(strings));
         // //记录返回值
         // int num = 0;
         // for (int i = 0; i < strings.length; i++) {
         //     //[11, 111, 1]的分割后每段的长度：2、3、1
         //     int n = strings[i].length();
         //     //System.out.println(n);
         //     while (n != 0){
         //         //卡车3
         //         if(n/3 != 0){
         //             num+=n/3;
         //             //变成0，n=n%3--》无论是1还是2都为0
         //             n%=3;
         //
         //             //货车2
         //         }else if(n/2 != 0){
         //             num+=n/2;
         //             n%=2;
         //             System.out.println(n%=2);
         //         }else{
         //             //小车1
         //             num += n;
         //             n=0;
         //         }
         //     }
         // }
         // System.out.println(num);

         Scanner scanner = new Scanner(System.in);
         String line = scanner.nextLine();
         String[] strings = line
             .replaceAll(",", "")
             .replaceAll("0+","0")
             .split("0");
         //1,1,0,0,1,1,1,0,1--》[11, 111, 1]
         System.out.println(Arrays.toString(strings));
         //记录返回值
         int num = 0;
         for (int i = 0; i < strings.length; i++) {
             //[11, 111, 1]的分割后每段值的长度：2、3、1
             int n = strings[i].length();
             //System.out.println(n);
             while (n != 0){
                 //卡车3
                 if(n%3 == 0){
                     num++;
                     //变成0，n=n%3--》无论是1还是2都为0
                     //n%=3;
                     //可以直接变成0，每次计算完一次车种都转成0否则会一直是n不等于0然后循环
                     n=0;

                     //货车2
                 }else if(n%2 == 0){
                     num++;
                     // n%=2;
                     n=0;

                 }else{
                     //小车1
                     num++;
                     n=0;
                 }
             }
         }
         System.out.println(num);
     }
}
