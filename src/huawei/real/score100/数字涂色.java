package huawei.real.score100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数字涂色       数学
 *
 疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。
 黑板上已经写上了N个正整数，同学们需要给这每个数分别上一种颜色。
 为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数整除

 现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这N个数进行上色。
 输入描述:
 第一行有一个正整数N，其中1 \leq N \leq 1001≤N≤score100。
 第二行有N个int型数(保证输入数据在[1,score100]范围中)，表示黑板上各个正整数的值。
 输出描述:
 输出只有一个整数，为最少需要的颜色种数。
 示例1
 输入
 3
 2 4 6
 输出
 1
 说明
 所有数都能被2整除
 示例2
 输入
 4
 2 3 4 9
 输出
 2
 说明
 2与4涂一种颜色，4能被2整除；3与9涂另一种颜色，9能被3整除。不能4个数涂同一个颜色，因为3与9不能被2整除。所以最少的颜色是两种
 ————————————————
 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/csfun1/article/details/124528902
 */
public class 数字涂色 {
     public static void main(String[] args) {


         // Scanner sc = new Scanner(System.in);
         // while (sc.hasNextInt()) {
         //     int n = sc.nextInt();
         //     int[] array = new int[n];
         //     for (int i = 0; i < n; i++) {
         //         array[i] = sc.nextInt();
         //     }
         //     // 先对数组进行排序，方便遍历
         //     Arrays.sort(array);
         //     System.out.println(Arrays.toString(array));
         //     // 记录最少需要的颜色数量
         //     int count = 0;
         //     int[] s = new int[n];
         //     for (int i = 0; i < n; i++) {
         //         if (s[i] > 0) {
         //             continue;
         //         } else {
         //             for (int j = i; j < n; j++) {
         //                 if ((array[j] % array[i]) == 0) {
         //                     s[j]++;
         //                 }
         //             }
         //             count++;
         //         }
         //     }
         //     System.out.println(count);
         // }

         // Scanner sc = new Scanner(System.in);
         // //输入一共有多少个数
         // String line = sc.nextLine();
         // //转成基本类型
         // int count = Integer.parseInt(line);
         // //所有的数字
         // String nums = sc.nextLine();
         // //根据空格分割变成数组
         // String[] input = nums.split(" ");
         //
         // //定义新数组
         // int[] arr = new int[count];
         // //遍历字符串数组-》转成整形数组
         // for (int i = 0; i < count; i++) {
         //     arr[i] = Integer.parseInt(input[i]);
         // }
         // // 先对整形数组进行排序，方便遍历
         // Arrays.sort(arr);
         // //新建链表
         // List<Integer> list = new ArrayList<>();
         // //遍历数组
         // for (int temp : arr) {
         //     //
         //     boolean flag = false;
         //     for (Integer aList : list) {
         //
         //         int num = aList;
         //         //如果list的数能整除arr[i] 就过 否则要加进list
         //         if (temp % num != 0) {
         //             flag = true;
         //             break;
         //         }
         //     }
         //     if (!flag) {
         //         list.add(temp);
         //     }
         // }
         // System.out.println(list.size());


         /**
          * 同种颜色的所有数都可以被这种颜色中最小的那个数整除
          *
          * 2 20 98 78 99 67 27 88 67 16
          *
          * 1、2:20 98 78 88 16
          * 2、99
          * 3、67:67
          * 4、27
          * 先排序：
          * 2 16  20 27 67 67 78 88  99
          * 需要两层循环
          *
          * 第一层：
          *
          */
         Scanner scanner = new Scanner(System.in);
         String line = scanner.nextLine();
         //输入一共有多少个数
         int count = Integer.parseInt(line);
         //数据
         String nums = scanner.nextLine();


         //变成字符串数组
         String[] split = nums.split(" ");
         //转成int数组
         int input[] = new int[count];
         for (int i = 0; i < split.length; i++) {
             input[i] = Integer.parseInt(split[i]);
         }
         //先对整形数组进行排序，方便遍历
         Arrays.sort(input);

         //[2, 16, 20, 27, 67, 67, 78, 88, 98, 99]
         System.out.println(Arrays.toString(input));

         //输出颜色的总数，赋初始值

         int num = 0;
         //如果第一层循环判断数组对应的索引值里面有数据--》该数据已经被整除过了--》做个标记颜色是同一种+
         int[] temp = new int[count];
         for (int i = 0; i < input.length; i++) {
             //s[0]=0--》进入else开始二层循环
             //s[0] > 0-->重新进入第一层循环
             if (temp[i] > 0) {
                 continue;
             } else {
                 /**
                  * 2 3 5
                  * 2/3-->新一种
                  * 2/5-->新一种
                  *
                  * 3/5-->新一种
                  */
                 for (int j = i ; j <input.length; j++) {
                     if ((input[i] % input[j]) == 0) {
                         //如果能整除，该索引的数组值从0--》1
                         temp[j]++;
                        // System.out.println(temp[j]++);
                     }
                 }
                 //跳出if else后+1
                 //走if--》不能被整除直接加1种颜色，如果
                 num++;
             }


         }
         System.out.println(num);
     }






}

