package huawei.real.score100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 机智的外卖员
 * 题目描述：
 * 外卖员每天在大厦中送外卖，大厦共有L层（0<L<=10^5），当他处于第N层楼时，可以每分钟通过步行梯向上达到N+1层，或向下达到N-1层，或者乘坐电梯达到2*N层。给定他所处位置N，以及外卖配送的目的楼层M，计算他送达的最短时间。
 *
 * 输入描述
 * 当前所处楼层N和外卖配送的目的楼层M
 *
 * 输出描述
 * 送达的最短时间
 *
 * 样例
 * 输入
 * 5 17
 * 输出
 * 4
 * ————————————————
 * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/124246788
 */
public class 机智的外卖员 {
    /**
     * 思路分析
     * 这道题是一道动态规划问题，dp[i]表示到达第i层的最短时间。
     *
     * 初始化的时候，到N层以下需要的时间，都减去相应的楼层，即步行向下
     *
     * for (int i = 0; i <= N; i++) {  // 初始化到N层以下需要的时间
     *     dp[i] = N - i;
     * }
     * 1
     * 2
     * 3
     * 转移方程为，走步行梯都是dp[i - 1] + 1，走电梯需要判断是偶数层，如果是偶数层，则dp[i / 2] + 1，如果是奇数层，则dp[(i + 1) / 2] + 2，选择走步行梯和电梯时间最短的。

     * @param args
     */
     public static void main(String[] args) {

         Scanner in = new Scanner(System.in);
         int N = in.nextInt();
         int M = in.nextInt();
         if (N >= M) {
             System.out.println(0);
             return;
         }
         int[] dp = new int[M + 1];  // dp[i]表示到达第i层的最短时间
         Arrays.fill(dp, 0);
         for (int i = 0; i <= N; i++) {  // 初始化到N层以下需要的时间
             dp[i] = N - i;
         }
         for (int i = N + 1; i <= M; i++) {  // 计算从N层到M层的最短时间
             // 计算走步行梯和坐电梯的最短时间
             if (i % 2 == 0) {  // 偶数层可以直接到2*i，时间加1
                 dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
             } else { // 奇数层需要先上或者先下，再到2*(i+1)，时间加2
                 dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2);
             }
         }
         System.out.println(dp[M]);

         }
}
