package huawei.real.score100;

import java.util.Scanner;

/**
 * 给定字符串 target和 source, 判断 target 是否为 source 的子序列。
 * 你可以认为 target 和 source 中仅包含英文小写字母。字符串 source可能会很长（长度 ~= 500,000），而 target 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"abc"是"aebycd"的一个子序列，而"ayb"不是）。
 * 请找出最后一个子序列的起始位置。
 * 输入描述:
 * 第一行为target，短字符串（长度 <=100）
 * 第二行为source，长字符串（长度 ~= 500,000）
 * 输出描述:
 * 最后一个子序列的起始位置， 即最后一个子序列首字母的下标
 * 示例1
 * 输入
 * abc
 * abcaybec
 * 输出
 * 3
 * 说明
 * 这里有两个abc的子序列满足，取下标较大的，故返回3
 * 备注:
 * 若在source中找不到target，则输出-1
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124516351
 */
public class 判断字符串子序列 {
     // public static void main(String[] args) {
     //     Scanner sc = new Scanner(System.in);
     //     String target = sc.nextLine();//[0,100]
     //     String source = sc.nextLine();//[0,50w]
     //
     //     int idx = source.length();
     //     for (int i = target.length()-1; i >= 0; i--) {
     //         char ta = target.charAt(i);
     //         if (source.contains(String.valueOf(ta))) {
     //             int idxLast = source.lastIndexOf(String.valueOf(ta));
     //             if (idxLast < idx){
     //                 idx = idxLast;
     //             }else {
     //                 System.out.println(-1);
     //                 return;
     //             }
     //         }else {
     //             System.out.println(-1);
     //             return;
     //         }
     //     }
     //     System.out.println(idx);
     // }

     // public static void main(String[] args) {
     //     Scanner scanner = new Scanner(System.in);
     //     String s1 = scanner.nextLine();
     //     String s2 = scanner.nextLine();
     //     int m = s1.length() - 1;
     //     int n = s2.length() - 1;
     //     boolean flag = false;
     //     while (m >= 0 && n >= 0) {
     //         if (s1.charAt(m) == s2.charAt(n)) {
     //             if (m == 0) {
     //                 flag = true;
     //                 System.out.println(n);
     //             }
     //             m--;
     //         }
     //         n--;
     //     }
     //     if (!flag) {
     //         System.out.println(-1);
     //     }
     //
     // }

    /**
     * 法3
     */
    public static void main(String[] args) {

        /**
         * 输入 ace
         * abcde
         * 输出 4
         *
         * fgh
         * abcde
         * -1
         */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String l = sc.nextLine();
        int w1 = 0;
        int w2 = 0;
        boolean flag=false;
        for (int i = w1; i < s.length(); i++) {
            for (int j = w2; j < l.length(); j++) {
                if (s.charAt(i) == l.charAt(j)) {
                    w1 = i;
                    w2 = j;
                    flag=true;
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println(-1);
        } else {
            System.out.println(w2);
        }

    }



}
