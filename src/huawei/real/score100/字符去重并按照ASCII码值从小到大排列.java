package huawei.real.score100;

import java.util.*;

/**  找出符合要求的字符串子串   有人考过
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

         //字符去重排序，并按照ASCII码值从小到大排列
         Scanner sc=new Scanner(System.in);
         String str1=sc.nextLine();
         String str2=sc.nextLine();
         String[] s1=str1.split("");
         TreeSet<String> treeset=new TreeSet<>();
         for (String i:s1)
         { if(str2.contains(i))
             {treeset.add(i);} }
         for (String re:treeset) {
             System.out.print(re); }


         }


    // public static void main(String[] args) {
    //
    //     //字符串去重排序,按照ASCII由小到大排序
    //     Scanner scanner = new Scanner(System.in);
    //     String str1 = scanner.nextLine();
    //     String str2 = scanner.nextLine();
    //     char[] chars1 = str1.toCharArray();
    //     Arrays.sort(chars1);
    //     char[] chars2 = str2.toCharArray();
    //     Set<Character> set = new HashSet<>();
    //     for (char c : chars2) {
    //         set.add(c); }
    //     Set<Character> res = new TreeSet<>();
    //     for (char c : chars1) {
    //         if (set.contains(c)) {
    //             res.add(c); } }
    //     for (Character c : res) {
    //         System.out.print(c); }
    //
    //
    // }


    // public static void main(String[] args) {
    //     //找出符合要求的字符串子串，
    //     Scanner sc = new Scanner(System.in);
    //     String target = sc.nextLine();
    //     String search = sc.nextLine();
    //     List<Character> list = new ArrayList<>();
    //     for (int i = 0; i < target.length(); i++) {
    //         Character tem = target.charAt(i);
    //         if (search.contains(String.valueOf(tem))) {
    //             list.add(tem);
    //         }
    //     }
    //     Collections.sort(list);
    //     for (int i = 0; i < list.size(); i++) {
    //         System.out.print(list.get(i));
    //     }
    //     System.out.println();
    //
    //
    // }
}
