package huawei.real.score100;

import java.util.Scanner;

/**
 * 一天一只顽猴想去从山脚爬到山顶，途中经过一个有个N个台阶的阶梯，但是这猴子有一个习惯： 每一次只能跳1步或跳3步，试问猴子通过这个阶梯有多少种不同的跳跃方式？
 * 输入描述:
 * 输入只有一个整数N（0<N<=50）此阶梯有多少个阶梯
 * 输出描述:
 * 输出有多少种跳跃方式（解决方案数）
 * 示例1：
 * 输入
 * 50
 * 输出
 * 122106097
 * 示例2：
 * 输入
 * 3
 * 输出
 * 2
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124509176
 */
public class 猴子爬山 {

    //  public static void main(String[] args) {
    //      Scanner sc = new Scanner(System.in);
    //      int input = sc.nextInt();
    //      System.out.println(calcCount(input));
    //  }
    // private static int calcCount(int step){
    //     //只剩一个台阶了
    //     if (step < 3){
    //         return 1;
    //     }
    //     //剩下的场景都需要分成当前跳1步或者跳3步
    //     return calcCount(step -1) + calcCount( step -3);
    // }

     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int nums = sc.nextInt();
         int value = fun(nums);
         System.out.println(value);
     }
    private static int fun(int nums) {
        // 递归结束条件
        if (nums == 1 || nums == 2) {
            return 1;
        }
        // 递归结束条件
        if (nums == 3) {
            return 2;
        }
        // 规律
        return fun(nums - 1) + fun(nums - 3);

         }
}
