package huawei.real.score100.字符串;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 给定两个字符串，从字符串2中找出字符串1中的所有字符，去重并按照ASCII值从小到大排序
 * 输入字符串1：长度不超过1024
 * 输入字符串2：长度不超过1000000
 * 字符范围满足ASCII编码要求，按照ASCII的值由小到大排序
 * 输入描述:
 * bach
 * bbaaccedfg
 * 输出描述:
 * abc
 * 示例1
 * 输入
 * fach
 * bbaaccedfg
 * 输出
 * acf
 * 说明
 * 备注:
 * 输入字符串1 为给定字符串bach，输入字符串2 bbaaccedfg
 * 从字符串2中找出字符串1的字符，去除重复的字符，并且按照ASCII值从小到大排序，得到输出的结果为abc。
 * 字符串1中的字符h在字符串2中找不到不输出。
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124551079
 */
public class 找出符合要求的字符串子串 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String target = sc.nextLine();
         String search = sc.nextLine();
         List<Character> list = new ArrayList<>();
         for (int i = 0; i < target.length(); i++) {
             Character tem = target.charAt(i);
             if (search.contains(String.valueOf(tem))) {
                 list.add(tem);
             }
         }
         Collections.sort(list);
         for (int i = 0; i < list.size(); i++) {
             System.out.print(list.get(i));
         }
         System.out.println();
     }
}
