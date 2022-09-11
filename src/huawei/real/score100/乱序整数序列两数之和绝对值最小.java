package huawei.real.score100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个随机的整数（可能存在正整数和负整数）数组 nums ，请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值，并返回这个两个数（按从小到大返回）以及绝对值。
 * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 输入描述:
 * 一个通过空格分割的有序整数序列字符串，最多1000个整数，且整数数值范围是 [-65535, 65535]。
 * 输出描述:
 * 两数之和绝对值最小值
 *
 * 示例1
 * 输入
 * -1 -3 7 5 11 15
 *
 * 输出
 * -3 5 2
 *
 * 说明
 * 因为 |nums[0] + nums[2]| = |-3 + 5| = 2 最小，所以返回 -3 5 2
 * ————————————————
 * 版权声明：本文为CSDN博主「Winyar Wen」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_42394052/article/details/125361530
 */
public class 乱序整数序列两数之和绝对值最小 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(" ");
            int length = split.length;
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            // 记录最小绝对值
            int min = Integer.MAX_VALUE;
            int[] minArr = new int[2];
            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    int sum = Math.abs(arr[i] + arr[j]);
                    if (sum < min) {
                        min = sum;
                        minArr[0] = arr[i];
                        minArr[1] = arr[j];
                    }
                }
            }
            Arrays.sort(minArr);
            for (int i : minArr) {
                System.out.print(i + " ");
            }
            System.out.println(min);
        }
        sc.close();
    }

}
