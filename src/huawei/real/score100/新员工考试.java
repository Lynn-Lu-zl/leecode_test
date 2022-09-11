package huawei.real.score100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 新员工考试
 * 题目描述
 * 小聪入职新公司，参加线上的新员工必考试共25题,依次是10个判断题(每题2分）、10个单选题(每题1分)和5个多选题(每题8分),总分100分。
 *
 * 考题只能顺序作答，答对题目获得相应的分数,答错题目获得0分,考试系统不提示作答是否正确，答题过程中如果累积有3题答错,直接中考试并计算考试分数。
 *
 * 小聪考试结果是N分（0<=N<=100)，请根据小聪的分数,算出所有可能的答题情况的个数。
 *
 * 输入描述
 * 整数，表示小聪的考试得分N，N为偶数，0<=N<=100，N不会是不可能考出来的分数。
 *
 * 输出描述
 * 整数表示所有可能的答题情况的个数。
 *
 * 样例1
 * 输入
 * 94
 * 1
 * 输出
 * 100
 * 1
 * 解释
 * 有1道单选和一道判断题答错，其余题都对，所有可能的答题情况的个数为100。
 *
 * 样例2
 * 输入
 * 100
 * 1
 * 输出
 * 1
 * 1
 * 解释
 * 所有题都对，答题情况的个数为1。

 */
public class 新员工考试 {
    /**
     * 思路分析
     * 这道题考察的是回溯，分情况讨论，用一个变量表示题目，如果是选择题，分数减2回溯，如果是判断题，分数减4回溯，如果是多选题，分数减8回溯，同时用一个变量表示错误的题目个数，如果分数减为0，种类加1，如果错够3道题目，或者25道题目答完，直接结束。
     */
    // public static int res = 0;
    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     int N = in.nextInt();
    //     dfs (N, 1, 0);  // 1表示答的题目，0表示错误的个数
    //     System.out.println(res);
    // }
    // public static void dfs(int target, int i, int wrong) {
    //     if (target == 0) {
    //         res++;
    //         return;
    //     }
    //     if (i > 25 || wrong >= 3) {
    //         return;
    //     }
    //     if (i <= 10) {  // 选择题
    //         dfs (target - 2, i + 1, wrong);  // 答对
    //         dfs (target, i + 1, wrong + 1);  // 答错
    //     } else if (i <= 20) { // 判断题
    //         dfs (target - 4, i + 1, wrong);
    //         dfs (target, i + 1, wrong + 1);
    //     } else { // 多选题
    //         dfs (target - 8, i + 1, wrong);
    //         dfs (target, i + 1, wrong + 1);
    //     }
    // }

    //法二，列出来得分数组，然后进行回溯
    public static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] num = new int[25];
        Arrays.fill(num, 2);
        for (int i = 10; i < num.length; i++) {
            if (i < 20) {
                num[i] = 4;
            } else {
                num[i] = 8;
            }
        }
        dfs (num,0, 0, 0, N);
        System.out.println(res);
    }
    private static void dfs(int[] num, int index, int score, int err, int N) {
        if (score == N) {
            res++; // 答题情况+1
            return;
        }
        if (score > N || err >= 3) return;

        for (int i = index; i < num.length; i++) {
            score += num[i];
            dfs(num,i + 1, score, err, N);
            score -= num[i];
            err++;
        }
    }


}
