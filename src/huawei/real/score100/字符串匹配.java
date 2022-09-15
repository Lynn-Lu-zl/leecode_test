package huawei.real.score100;

import java.util.Scanner;

/**
 * 【字符串匹配】
 *
 * 给你一个字符串数组（每个字符串均由小写字母组成）和一个字符规律（由小写字母和.和*组成），识别数组中哪些字符串可以匹配到字符规律上。
 *
 * ‘.’ 匹配任意单个字符，’*’ 匹配零个或多个前面的那一个元素，所谓匹配，是要涵盖整个字符串的，而不是部分字符串。
 *
 * 输入描述
 *
 * 第一行为空格分割的多个字符串，1<单个字符串长度<100，0，1<字符串个数<100
 *
 * 第二行为字符规律，1<字符串个数<100
 *
 * 第二行为字符规律，1<=字符规律长度<=50
 *
 * 不需要考虑异常场景。
 *
 * 输出描述
 *
 * 匹配的字符串在数组中的下标（从0开始），多个匹配时下标升序并用,分割，若均不匹配输出-1
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * ab aab
 *
 * .*
 *
 * 输出
 *
 * 0,1
 *
 * 示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * ab abc bsd
 *
 * .*
 *
 * 输出
 *
 * 0,1,2
 *
 * 示例3 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * avd adb sss as
 *
 * adb
 *
 * 输出
 *
 * 1
 */
public class 字符串匹配 {

    // public static void main(String[] args){
    //     Scanner in = new Scanner(System.in);
    //     while(in.hasNext()){
    //         String s1 = in.nextLine();
    //         String s2 = in.nextLine();
    //         System.out.println(helper(s1, s2, 0, 0));
    //     }
    // }
    //
    // private static boolean helper(String s1, String s2, int p1, int p2){
    //     //base case
    //     if (p1 == s1.length() && p2 == s2.length()){
    //         return true;
    //     }else if (p1 == s1.length() || p2 == s2.length()){
    //         return false;
    //     }
    //     //遇到'*'两种情况，要不就各跳过一个比较后面，要不就s2继续往后跳先不比较
    //     if (s1.charAt(p1) == '*'){
    //         return helper(s1, s2, p1, p2+1) || helper(s1, s2, p1+1, p2+1);
    //         //遇到'?'跟两个一样操作一样，直接指针都往后移一个继续比较
    //     }else if (s1.charAt(p1) == '?' || s1.charAt(p1) == s2.charAt(p2)){
    //         return helper(s1, s2, p1+1, p2+1);
    //     }else {
    //         return false;
    //     }
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String reg = sc.nextLine();
            String str = sc.nextLine();

            reg = reg.replace("?", "[0-9a-zA-Z]{1}");
            reg = reg.replace("*", "[0-9a-zA-Z]*");
            System.out.println(str.matches(reg));
        }
    }

}
