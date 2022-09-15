package huawei.real.score100;

import java.util.Scanner;

/**
 *输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 */
public class 分解质因数 {
    /**
     * 先找到最小的质因数2，
     * 将输入的数不断除以这个质因数，
     * 如果能整除就打印，
     * 如果不能整除，则将质因数加1
     * @param args
     */
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     long input = sc.nextLong();
    //     int n = 2;
    //     while (input >= n) {
    //         if (input % n == 0) {
    //             System.out.printf("%d ", n);
    //             input /= n;
    //         } else {
    //             n++;
    //         }
    //     }
    // }

    public static void main(String[] args) {
        //分解质因数 输出它的所有质数的因子
        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();
        int n = 2;
        while (input >= n) {
            if (input % n == 0) {
                System.out.printf("%d ", n);
                input /= n;
            } else {
                n++; } }


    }


}
