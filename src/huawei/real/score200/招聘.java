package huawei.real.score200;

import java.util.*;

/**
 * 某公司组织一场公开招聘活动，假设由于人数和场地的限制，每人每次面试的时长不等，并已经安排给定，用(S1,E1)、(S2,E2)、(Sj,Ej)…(Si < Ei，均为非负整数)表示每场面试的开始和结束时间。面试采用一对一的方式，即一名面试官同时只能面试一名应试者，一名面试官完成一次面试后可以立即进行下一场面试，且每个面试官的面试人次不超过m。
 * 为了支撑招聘活动高效顺利进行，请你计算至少需要多少名面试官。
 * 输入描述:
 * 输入的第一行为面试官的最多面试人次m，第二行为当天总的面试场次n，接下来的n行为每场面试的起始时间和结束时间，起始时间和结束时间用空格分隔。
 * 其中，1 <= n, m <= 500
 * 输出描述:
 * 输出一个整数，表示至少需要的面试官数量。
 * 示例1
 * 输入
 * 2
 * 5
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 5 6
 * 输出
 * 3
 * 说明
 * 总共有5场面试，且面试时间都不重叠，但每个面试官最多只能面试2人次，所以需要3名面试官。
 * 示例2
 * 输入
 * 3
 * 3
 * 1 2
 * 2 3
 * 3 4
 * 输出
 * 1
 * 说明
 * 总共有3场面试，面试时间都不重叠，每个面试官最多能面试3人次，所以只需要1名面试官。
 * 示例3
 * 输入
 * 3
 * 3
 * 8 35
 * 5 10
 * 1 3
 * 输出
 * 2
 * 说明
 * 总共有3场面试，[5,10]和[8,35]有重叠，所以至少需要2名面试官。
 * ————————————————
 * 版权声明：本文为CSDN博主「qq_34811681」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_34811681/article/details/125341528
 */
public class 招聘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, Comparator.comparing(c1 -> c1[0]));
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{arr[0][1], 1});
        for (int i = 1; i < n; i++) {
            boolean flag = false;
            for (int[] p : deque) {
                if (p[0] <= arr[i][0] && p[1] < m) {
                    p[1]++;
                    p[0] = arr[i][1];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                deque.offer(new int[]{arr[i][1], 1});
            }
        }
        System.out.println(deque.size());
    }


}
