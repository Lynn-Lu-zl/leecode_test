package huawei.real.score200;

import java.util.Scanner;

/**
 * 题目描述
 * 学校组织活动，将学生排成一个矩形方阵。
 * 请在矩形方阵中找到最大的位置相连的男生数量。
 * 这个相连位置在一个直线上，方向可以是水平的，垂直的，成对角线的或者呈反对角线的。
 * 注：学生个数不会超过10000
 * 输入描述
 * 输入的第一行为矩阵的行数和列数，接下来的n行为矩阵元素，元素间用”,”分隔。
 * 输出描述
 * 输出一个整数，表示矩阵中最长的位置相连的男生个数。
 *
 * 3,4
 * F,M,M,F
 * F,M,M,F
 * F,F,F,M
 *输出：
 * 3
 *
 *输入
 * 1,2
 * M,M
 *
 * 输出：
 *2
 *
 * 输入：
 * 2,1
 * M
 * F
 *
 * 输出：
 * 1
 * ————————————————
 * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/125881141
 */
public class 学生方阵 {

         public static void main(String[] args) {
         //     Scanner in = new Scanner(System.in);
         //     String[] str1 = in.nextLine().split(",");
         //     int m = Integer.parseInt(str1[0]);
         //     int n = Integer.parseInt(str1[1]);
         //     String[][] s = new String[m][n];
         //     for (int i = 0; i < m; i++) {
         //         String[] s1 = in.nextLine().split(",");
         //         for (int j = 0; j < n; j++) {
         //             s[i][j] = s1[j];
         //         }
         //     }
         //     int[][] dp1 = new int[m][n];  // 从左往右
         //     int[][] dp2 = new int[m][n];  // 从上往下
         //     int[][] dp3 = new int[m][n];  // 对角线
         //     int[][] dp4 = new int[m][n];  // 反对角线
         //     // 特例，只有一行或只有一列，不能给每一个等于M的初始化为1，还要考虑前一个的情况
         //     int ans = 0;
         //     if (m == 1) {
         //         if (s[0][0].equals("M")) {
         //             dp1[0][0] = 1;
         //         }
         //         for (int j = 1; j < n; j++) {
         //             if (s[0][j - 1].equals("M")) {
         //                 if (s[0][j].equals("M")) {
         //                     dp1[0][j] = dp1[0][j - 1] + 1;
         //                 }
         //             } else {
         //                 if (s[0][j].equals("M")){
         //                     dp1[0][j] = 1;
         //                 }
         //             }
         //         }
         //         for (int j = 0; j < n; j++) {
         //             ans = Math.max(ans, dp1[0][j]);
         //         }
         //         System.out.println(ans);
         //         return;
         //     }
         //     if (n == 1) {
         //         if (s[0][0].equals("M")) {
         //             dp2[0][0] = 1;
         //         }
         //         for (int i = 1; i < m; i++) {
         //             if (s[i - 1][0].equals("M")) {
         //                 if (s[i][0].equals("M")) {
         //                     dp2[i][0] = dp2[i - 1][0] + 1;
         //                 }
         //             } else {
         //                 if (s[i][0].equals("M")) {
         //                     dp2[i][0] = 1;
         //                 }
         //             }
         //         }
         //         for (int i = 0; i < m; i++) {
         //             ans = Math.max(ans, dp2[i][0]);
         //         }
         //         System.out.println(ans);
         //         return;
         //     }
         //     // 初始化dp1, dp2, dp3, dp4数组
         //     for (int i = 0; i < m; i++) {
         //         if (s[i][0].equals("M")) {
         //             dp1[i][0] = 1;
         //             dp2[i][0] = 1;
         //             dp3[i][0] = 1;
         //         }
         //     }
         //     for (int j = 0; j < n; j++) {
         //         if (s[0][j].equals("M")) {
         //             dp1[0][j] = 1;
         //             dp2[0][j] = 1;
         //             dp3[0][j] = 1;
         //             dp4[0][j] = 1;
         //         }
         //     }
         //     // 初始化dp4数组
         //     for (int i = 0; i < m; i++) {
         //         if (s[i][n - 1].equals("M")) {
         //             dp4[i][n - 1] = 1;
         //         }
         //     }
         //     for (int i = 1; i < m; i++) {
         //         for (int j = 1; j < n; j++) {
         //             if (s[i][j].equals("M")) {
         //                 if (s[i][j - 1].equals("M")) { // 从左往右
         //                     dp1[i][j] = dp1[i][j - 1] + 1;
         //                 }
         //                 if (s[i - 1][j].equals("M")) {  // 从上往下
         //                     dp2[i][j] = dp2[i - 1][j] + 1;
         //                 }
         //                 if (s[i - 1][j - 1].equals("M")) { // 对角线
         //                     dp3[i][j] = dp3[i - 1][j - 1] + 1;
         //                 }
         //             }
         //         }
         //     }
         //     for (int i = 1; i < m; i++) {
         //         for (int j = n - 2; j >= 0; j--) {
         //             if (s[i][j].equals("M")) {
         //                 if (s[i - 1][j + 1].equals("M")) { // 反对角线
         //                     dp4[i][j] = dp4[i - 1][j + 1] + 1;
         //                 }
         //             }
         //         }
         //     }
         //     for (int i = 0; i < m; i++) {  // 取四个数组中的最大值
         //         for (int j = 0; j < n; j++) {
         //             ans = Math.max(ans, Math.max(dp1[i][j], Math.max(dp2[i][j], Math.max(dp3[i][j], dp4[i][j]))));
         //         }
         //     }
         //     System.out.println(ans);
         // }


    /**
     * 模拟
     *
     */
    //学生方阵，学校组织活动，将学生排成一个矩形方阵
    Scanner in = new Scanner(System.in);
    String[] str1 = in.nextLine().split(",");
    int m = Integer.parseInt(str1[0]);
    int n = Integer.parseInt(str1[1]);
    String[][] s = new String[m][n];
        for (int i = 0; i < m; i++) {
        String[] s1 = in.nextLine().split(",");
        for (int j = 0; j < n; j++) {
            s[i][j] = s1[j]; } }
    int[][] dp1 = new int[m][n];  // 从左往右
    int[][] dp2 = new int[m][n];  // 从上往下
    int[][] dp3 = new int[m][n];  // 对角线
    int[][] dp4 = new int[m][n];  // 反对角线
    //特例，只有一行或只有一列，不能给每一个等于M的初始化为1，还要考虑前一个的情况
    int ans = 0;
        if (m == 1) {
        if (s[0][0].equals("M")) {
            dp1[0][0] = 1; }
        for (int j = 1; j < n; j++) {
            if (s[0][j - 1].equals("M")) {
                if (s[0][j].equals("M")) {
                    dp1[0][j] = dp1[0][j - 1] + 1; }
            } else {
                if (s[0][j].equals("M")){
                    dp1[0][j] = 1; } } }
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, dp1[0][j]); }
        System.out.println(ans);
        return; }
        if (n == 1) {
        if (s[0][0].equals("M")) {
            dp2[0][0] = 1; }
        for (int i = 1; i < m; i++) {
            if (s[i - 1][0].equals("M")) {
                if (s[i][0].equals("M")) {
                    dp2[i][0] = dp2[i - 1][0] + 1; }
            } else {
                if (s[i][0].equals("M")) {
                    dp2[i][0] = 1; } } }
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dp2[i][0]); }
        System.out.println(ans);
        return; }
    // 初始化dp1, dp2, dp3, dp4数组
        for (int i = 0; i < m; i++) {
        if (s[i][0].equals("M")) {
            dp1[i][0] = 1;
            dp2[i][0] = 1;
            dp3[i][0] = 1; } }
        for (int j = 0; j < n; j++) {
        if (s[0][j].equals("M")) {
            dp1[0][j] = 1;
            dp2[0][j] = 1;
            dp3[0][j] = 1;
            dp4[0][j] = 1; } }
    // 初始化dp4数组
        for (int i = 0; i < m; i++) {
        if (s[i][n - 1].equals("M")) {
            dp4[i][n - 1] = 1; } }
        for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (s[i][j].equals("M")) {
                if (s[i][j - 1].equals("M")) { // 从左往右
                    dp1[i][j] = dp1[i][j - 1] + 1; }
                if (s[i - 1][j].equals("M")) {  // 从上往下
                    dp2[i][j] = dp2[i - 1][j] + 1; }
                if (s[i - 1][j - 1].equals("M")) { // 对角线
                    dp3[i][j] = dp3[i - 1][j - 1] + 1; } } } }
        for (int i = 1; i < m; i++) {
        for (int j = n - 2; j >= 0; j--) {
            if (s[i][j].equals("M")) {
                if (s[i - 1][j + 1].equals("M")) { // 反对角线
                    dp4[i][j] = dp4[i - 1][j + 1] + 1; } } } }
        for (int i = 0; i < m; i++) {  // 取四个数组中的最大值
        for (int j = 0; j < n; j++) {
            ans = Math.max(ans, Math.max(dp1[i][j], Math.max(dp2[i][j],
                Math.max(dp3[i][j], dp4[i][j])))); } }
        System.out.println(ans);

}

}

