package huawei.real.score100;

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个含有N个正整数的数组, 求出有多少个连续区间（包括单个正整数）, 它们的和大于等于x。
 *
 * 题目要求
 * 第一行两个整数N x（0 < N <= 100000, 0 <= x <= 10000000)
 * 第二行有N个正整数（每个正整数小于等于100)
 *
 * 输出 一个整数，表示所求的个数
 *
 * 示例1
 * 输入
 * 3 7
 * 3 4 7
 * 输出
 * 4
 * 说明
 * 3+4 4+7 3+4+7 7这四组数据都是大于等于7的，所以答案为4
 *
 * 示例2
 * 输入
 * 10 10000000
 * 1 2 3 4 5 6 7 8 9 10
 * 输出
 * 0
 */
public class 数组连续和 {
    public static void main(String[] args) {

        //数组连续和，求出有多少个连续区间
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String numStr = scanner.nextLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int x = Integer.parseInt(line.split(" ")[1]);
        int[] ints = new int[N]; // 得到所有的正整数
        String[] strings = numStr.split(" ");
        for (int i = 0; i < numStr.split(" ").length; i++){
            ints[i] = Integer.parseInt(strings[i]); }
        int count = 0;
        int sum = 0;
        for (int j = 0; j < N; j++) {// 比较各种连续和
            for (int i = j; i < N; i++) {
                sum += ints[i];
                if (sum >= x) {
                    count++; } }
            sum = 0; }
        System.out.println(count);


    }
}
