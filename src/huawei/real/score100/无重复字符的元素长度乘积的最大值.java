package huawei.real.score100;

import java.util.Scanner;

/**无重复字符的元素长度乘积的最大值/计算最大乘积
 * 题目描述：
 * 给定一个元素类型为小写字符串的数组，请计算两个没有相同字符的元素长度乘积的最大值。
 * 如果没有符合条件的两个元素返回0。
 * 输入描述：
 * 输入为一个半角逗号分割的小写字符串数组
 * 2<= 数组长度 <=100
 * 0< 字符串长度 <=50
 * 输出描述
 * 两个没有相同字符的元素长度乘积的最大值

 iwdvpbn,hk,iuop,iikd,kadgpf
输出：14
 数组中有5个元素。
 iwdvpbn与hk无相同的字符，满足条件，iwdvpbn的长度为7，hk的长度为2，乘积为14（7*2）。
 iwdvpbn与iuop、iikd、kadgpf均有相同的字符，不满足条件。
 iuop与iikd、kadgpf均有相同的字符，不满足条件。
 */
public class 无重复字符的元素长度乘积的最大值 {
     public static void main(String[] args) {

         //无重复字符的元素长度乘积的最大值，iwdvpbn与hk无相同的字符
         Scanner in = new Scanner(System.in);
         String[] words = in.nextLine().split(",");
         int maxLength = 0;
         for (int i = 0; i < words.length - 1; i++) {
             for (int j = i + 1; j < words.length; j++) {
                 char[] word1 = words[i].toCharArray();
                 char[] word2 = words[j].toCharArray();
                 boolean flag = true;
                 for (int m = 0; m < word1.length; m++) {
                     for (int n = 0; n < word2.length; n++) {
                         if (word1[m] == word2[n]) {
                             flag = false;
                             break; } } }
                 if (flag) {  // 两个字符串不相等
                     int Length = word1.length * word2.length;
                     maxLength = Math.max(maxLength, Length); } } }
         System.out.println(maxLength);


     }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String[] split = sc.nextLine().split(",");
    //     int max = 0;
    //     for (int i = 0; i < split.length; i++) {
    //         for (int j = i+1; j < split.length; j++) {
    //             if (!checkHaveSame(split[i], split[j])){
    //                 max = Math.max(max,split[i].length() * split[j].length());
    //             }
    //         }
    //     }
    //     System.out.println(max);
    // }
    //
    // private static boolean checkHaveSame(String str1,String str2){
    //     //字符串排序
    //     char[] chars1 = str1.toCharArray();
    //     char[] chars2 = str2.toCharArray();
    //     Arrays.sort(chars1);
    //     Arrays.sort(chars2);
    //     int idx1 = 0;
    //     int idx2 = 0;
    //     while (idx1<str1.length() && idx2< str2.length()){
    //         if (chars1[idx1] == chars2[idx2]){
    //             return true;
    //         }else if (chars1[idx1] > chars2[idx2]){
    //             idx2++;
    //         }else if (chars1[idx1] < chars2[idx2]){
    //             idx1++;
    //         }
    //     }
    //     return false;
    // }

}
