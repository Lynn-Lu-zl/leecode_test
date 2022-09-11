package huawei.real.score100;

import java.util.Scanner;

/**
 * 输入一个字符串仅包含大小写字母和数字，求字符串中包含的最长的非严格递增连续数字序列的长度（比如12234属于非严格递增连续数字序列）。
 * 输入描述:
 * 输入一个字符串仅包含大小写字母和数字，输入的字符串最大不超过255个字符。
 * 输出描述:
 * 最长的非严格递增连续数字序列的长度
 * 示例1：
 * 输入
 * abc2234019A334bc
 * 输出
 * 4
 * 说明
 * 2234为最长的非严格递增连续数字序列，所以长度为4。
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124390802
 */
public class 非严格递增连续数字序列 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();
         char[] chars = input.toCharArray();
         int start = 0;
         int end = 0;
         int max = 0;
         char tem = ' ';
         for (int i = 0; i < chars.length; i++) {
             char ch = chars[i];
             if (ch>= '0' && ch<='9'){
                 if (start == 0){
                     start = i;
                     end = i;
                     tem = ch;
                     continue;
                 }
                 if (ch == tem + 1 || ch == tem){
                     tem = ch;
                     end++;
                 }else {
                     max = Math.max(max,end - start+1);
                     start = 0;
                     end = 0;
                     tem = ' ';
                 }
             }else {
                 max = Math.max(max,end - start+1);
                 start = 0;
                 end = 0;
                 tem = ' ';
             }
         }
         System.out.println(max);
     }


}
