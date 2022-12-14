package huawei.real.score100;

import java.util.Scanner;

/**
 * RSA加密算法在网络安全世界中无处不在，它利用了极大整数因数分解的困难度，数据越大，安全系数越高，给定一个32位正整数，请对其进行因数分解，找出是哪两个素数的乘积。
 * 输入描述:
 * 一个正整数num
 * 0 < num <= 2147483647
 * 输出描述:
 * 如果成功找到，以单个空格分割，从小到大输出两个素数，分解失败，请输出-1 -1
 * 示例1
 * 输入
 * 15
 * 输出
 * 3 5
 * 说明
 * 因数分解后，找到两个素数3和5，使得3*5=15，按从小到大排列后，输出3 5
 * 示例2
 * 输入
 * 27
 * 输出
 * -1 -1
 * 说明
 * 通过因数分解，找不到任何素数，使得他们的乘积为27，输出-1 -1
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124544351
 */
public class 素数之积 {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int target = sc.nextInt();//[0,2147483647]
    //     int max = target;
    //     for (int i = 3; i <= max; i++) {
    //         //先判断能不能被target整除
    //         if (target % i == 0){
    //             max = target / i;
    //             if (checkSu(i) && checkSu(target/i)){
    //                 System.out.println(i + " " + target/i);
    //                 return;
    //             }
    //         }
    //     }
    //     System.out.println(-1 + " " + -1);
    // }
    // //素数是指除了1和本身不能被其他所有数整除
    // private static boolean checkSu(int num){
    //     for (int i = 2; i < num; i++) {
    //         if (num % i == 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    //
    //
    //

    /**
     * 法二
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a = -1;
        int b = -1;
        // 计算输入数字的平方根，原因如上
        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            // 判断是否为素数
            if (!isPrime(i)) {
                continue;
            }
            // 判断能否整除
            if (num % i != 0) {
                continue;
            }
            // 判断另一个乘数是否为素数
            if (!isPrime(num / i)) {
                continue;
            }
            // 结果赋值
            a = i;
            b = num / i;
        }

        System.out.println(a + " " + b);
    }

    /**
     * 判断是否是素数
     *
     * @param arg 入参
     * @return bool
     */
    public static boolean isPrime(int arg) {
        if (arg <= 1) {
            return false;
        }
        // 计算输入数字的平方根，原因如上
        double sqrt = Math.sqrt(arg);
        for (int j = 2; j <= sqrt; j++) {
            if (arg % j == 0) {
                return false;
            }
        }
        return true;
    }

}
