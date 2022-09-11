package huawei.real.score200;

import java.util.Arrays;
import java.util.Scanner;

/** 叠书本 有人考过
 *
 * 题目描述
 * 假设书本的叠放有这样的规则，当A书的长度和宽度都大于B书时，可以将其B书置于A的上方，堆叠摆放，请设计一个程序，根据输入的书本长宽，计算最多可以堆叠摆放多少本书？
 *
 * 输入
 * [[16,15],[13,12],[15,14]]
 *
 * 输出
 * 3
 *
 * 说明
 * 这里代表有3本书，第1本长宽分别为16和15，第2本长宽为13和12，第3本长宽为15和14，它们可以按照 [13, 12],[15, 14],[16,15] 的顺序堆叠，所以输出3
 *
 * [[20,16],[15,11],[10,10],[9,10]]
 * 输出
 * 3
 *
 * 【分析】
 * 动态规划，实质是求最长递增子序列，但本题有两个因素需要考虑，可以通过排序将长度置为有序，这样其实就是对宽度求最长递增子序列，且可能存在长度相同的情况，在更新dp数组判定时，也要考虑到
 * ————————————————
 * 版权声明：本文为CSDN博主「下一个路口遇见你48」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/m0_56229413/article/details/117743209
 */
public class 书本叠加 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().replaceAll("\\[", "").replaceAll("\\]", "");
        String[] str = s.split(",");
        int[][] nums = new int[str.length / 2][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = Integer.parseInt(str[i * 2]);
            nums[i][1] = Integer.parseInt(str[i * 2 + 1]);
        }
        Arrays.sort(nums, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i][1] > nums[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        System.out.println(res);
    }

}
