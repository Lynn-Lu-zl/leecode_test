package huawei.real.score100;

import java.util.*;

/**
 * 一个工厂有m条流水线，来并行完成n个独立的作业，该工厂设置了一个调度系统，在安排作业时，总是优先执行处理时间最短的作业。
 * 现给定流水线个数m，需要完成的作业数n, 每个作业的处理时间分别为t1,t2…tn。请你编程计算处理完所有作业的耗时为多少？
 * 当n>m时，首先处理时间短的m个作业进入流水线，其他的等待，当某个作业完成时，依次从剩余作业中取处理时间最短的进入处理。
 * 输入描述:
 * 第一行为2个整数（采用空格分隔），分别表示流水线个数m和作业数n；
 * 第二行输入n个整数（采用空格分隔），表示每个作业的处理时长t1,t2…tn。
 * 0< m,n<100，0<t1,t2…tn<100。
 * 注：保证输入都是合法的。
 * 输出描述:
 * 输出处理完所有作业的总时长
 * 示例1
 * 输入
 * 3 5
 * 8 4 3 2 10
 * 输出
 * 13
 * 说明
 * 1、先安排时间为2、3、4的3个作业--》因为有3条流水线，第一次作业：2s第一条,3s第二条,4s第三条--》第一条才2s最快完成作业--》第一条优先调度8s的进行作业--》接着第二条3s也完成了-》调度10s的到第二条
 * 2、第一条流水线先完成作业，然后调度剩余时间最短的作业8--》第一条流水线总完成2+8s=10s
 * 3、第二条流水线完成作业，然后调度剩余时间最短的作业10--》第二条流水线总完成3+10=13s
 * 4、总工耗时就是第二条流水线完成作业的时间13（3+10）
 *
 * 3 9
 * 1 1 1 2 3 4 6 7 8
 * 输出
 * 13
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124516351
 */
public class 流水线 {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String[] input = sc.nextLine().split(" ");
    //     String[] job = sc.nextLine().split(" ");
    //     int med = Integer.parseInt(input[0]);
    //     int[] arr = new int[job.length];
    //     for (int i = 0; i < job.length; i++) {
    //         arr[i] = Integer.parseInt(job[i]);
    //     }
    //     Arrays.sort(arr);
    //     List<Medic> list = new ArrayList<>();
    //     for (int i = 0; i < arr.length; i++) {
    //         if (list.size() <med){
    //             list.add(new Medic(arr[i],arr[i]));
    //         }else {
    //             //找到数组中 total最小的medic 加进去
    //             Collections.sort(list);
    //             Medic medic = list.get(0);
    //             medic.total += arr[i];
    //         }
    //     }
    //     Collections.sort(list);
    //     System.out.println(list.get(list.size()-1).total);
    // }
    // static class Medic implements Comparable{
    //     private int end;
    //     private int total;
    //
    //     public Medic(int end, int total) {
    //         this.end = end;
    //         this.total = total;
    //     }
    //
    //     @Override
    //     public int compareTo(Object obj) {
    //         Medic medic= (Medic)obj;
    //         return this.total - medic.total;
    //     }
    // }

     public static void main(String[] args) {
         //分流水线数量大于作业数和小于等于--》小于输出最大的作业数即可--》大于可以新建一个集合存放结果
         Scanner sc = new Scanner(System.in);
         String line1 = sc.nextLine();
         String line2 = sc.nextLine();
         String[] split1 = line1.split(" ");
         // 流水线个数m和作业数n
         int m = Integer.parseInt(split1[0]);
         int n = Integer.parseInt(split1[1]);
         String[] split2 = line2.split(" ");
         List<Integer> list = new ArrayList<>();
         for (int i = 0; i < split2.length; i++) {
             list.add(Integer.parseInt(split2[i]));
         }
         // 对数组进行排序
         Collections.sort(list);
         // 作业数n小于等于流水线个数m，则结果为排序后的最后一个值
         if (n <= m) {
             //相当于有3个流水线只有两个在干活，做最久的那条线就是最大总时长，不存在后面的调度问题
             System.out.println(list.get(list.size() - 1));
             return;
         }
         // 总耗时
         int res = 0;
         // 遍历每一条流水线
         for (int k = 0; k < m; k++) {
             // 每条流水线获取到的任务时长总和
             int allTime = 0;
             // 累加每条流水线获取到的任务时长
             for (int i = k; i < list.size(); i += m) {
                 allTime += list.get(i);
             }
             // 取最大的
             res = Math.max(allTime, res);
         }
         System.out.println(res);

         }

}
