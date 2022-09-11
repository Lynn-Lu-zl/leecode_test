package huawei.real.score100;

import java.util.Scanner;
import java.util.TreeSet;

/**  有人考过
 * 给定两个字符串
 *         从字符串2中找出字符串1中的所有字符
 *         去重并按照ASCII码值从小到大排列
 *         输入字符串1长度不超过1024
 *         字符串2长度不超过100
 *         字符范围满足ASCII编码要求，按照ASCII由小到大排序
 *         输入描述：
 *          bach
 *          bbaaccddfg
 *          输出
 *           abc

 *           输入
 *           fach
 *           bbaaccedfg
 *           输出
 *           acf
 */
public class 字符去重并按照ASCII码值从小到大排列 {
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         String str1=sc.nextLine();
         String str2=sc.nextLine();
         String[] s1=str1.split("");
         TreeSet<String> treeset=new TreeSet<>();
         for (String i:s1)
         {
             if(str2.contains(i)){
                 treeset.add(i);
             }

         }
         for (String re:treeset) {
             System.out.print(re);
         }
         }
}
