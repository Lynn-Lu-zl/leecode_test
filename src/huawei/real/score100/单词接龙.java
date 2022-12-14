package huawei.real.score100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 单词接龙的规则是：
 * 可用于接龙的单词首字母必须要前一个单词的尾字母相同；
 * 当存在多个首字母相同的单词时，取长度最长的单词，如果长度也相等，则取字典序最小的单词；-->字母a-z排序，如da、db、dd--》字典序最小为da
 * 已经参与接龙的单词不能重复使用。
 *
 *
 * 现给定一组全部由小写字母组成单词数组，并指定其中的一个单词作为起始单词，进行单词接龙，请输出最长的单词串，单词串是单词拼接而成，中间没有空格。
 * 输入描述:
 * 输入的第一行为一个非负整数，表示起始单词在数组中的索引K，0 <= K < N ；
 * 输入的第二行为一个非负整数，表示单词的个数N；
 * 接下来的N行，分别表示单词数组中的单词。
 * 输出描述:
 * 输出一个字符串，表示最终拼接的单词串。
 * 示例1：
 * 输入
 * 0
 * 6
 * word
 * dd
 * da
 * dc
 * dword
 * d
 * 输出
 * worddwordda
 * 说明
 * 先确定起始单词word，再接以d开头的且长度最长的单词dword，剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，所以最后输出worddwordda。
 * 示例2：
 * 输入
 * 4
 * 6
 * word
 * dd
 * da
 * dc
 * dword
 * d
 * 输出
 * dwordda
 * 说明
 * 先确定起始单词dword，剩余以d开头且长度最长的有dd、da、dc，则取字典序最小的da，所以最后输出dwordda。
 * 备注:
 * 单词个数N的取值范围为[1, 20]；
 * 单个单词的长度的取值范围为[1, 30]；
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124390802
 */
public class 单词接龙 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int start = Integer.parseInt(sc.nextLine());
         int len = Integer.parseInt(sc.nextLine());
         List<String> list = new ArrayList<>();
         for (int i = 0; i < len; i++) {
             list.add(sc.nextLine());
         }
         String startWord = list.get(start);
         // 移除起始元素
         list.remove(startWord);
         list.sort((s1, s2) -> {
             int length1 = s1.length();
             int length2 = s2.length();
             if (length1 != length2) {
                 return length2 - length1;
             }
             // 按照字典排序，遍历每一个字符，返回不相同字符的差值
             return s1.compareTo(s2);
         });
         String result = startWord;
         for (int i = 0; i < list.size(); i++) {
             String value = list.get(i);
             if (getStartOrEnd(startWord, 100).equals(getStartOrEnd(value, 1))) {
                 result = result + value;
                 // 找到的单词作为起始单词
                 startWord = value;
                 // 移除用过的单词
                 list.remove(value);
                 // 找到了归零，下一个从头开始找
                 i = 0;
             }
         }
         System.out.println(result);
     }

    private static String getStartOrEnd(String key, int num) {
        // 求字符串首字母
        if (num == 1) {
            return key.substring(0, 1);
        } else { // 求字符串尾字幕
            return key.substring(key.length() - 1, key.length());
        }

     }
}
