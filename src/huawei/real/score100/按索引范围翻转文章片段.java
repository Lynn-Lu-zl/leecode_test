package huawei.real.score100;

import java.util.Scanner;

/**
 * 按索引范围翻转文章片段/按索引范围翻转文章片段  字符串
 *
 *  输入一个英文文章片段
 *  翻转指定区间的单词顺序，标点符号和普通字母一样处理
 *  例如输入字符串 "I am a developer."
 *  区间[0,3]则输出 "developer. a am I"
 *
 *  输入描述：
 *  使用换行隔开三个参数
 *  第一个参数为英文文章内容即英文字符串
 *  第二个参数为反转起始单词下标，下标从0开始
 *  第三个参数为结束单词下标，
 *
 *  输出描述
 *  反转后的英文文章片段，所有单词之间以一个半角空格分割进行输出
 *
 *  示例一：
 *  输入
 *  I am a developer.
 *  1
 *  2
 *  输出
 *  I a am developer.
 *
 *  示例二：
 *  输入
 *  Hello world!
 *  0
 *  1
 *  输出
 *  world! Hello
 *
 *  说明：
 *  输入字符串可以在前面或者后面包含多余的空格，
 *  但是反转后的不能包含多余空格
 *
 *  示例三：
 *  输入：
 *  I am a developer.
 *  0
 *  3
 *  输出
 *  developer. a am I
 *
 *  说明：
 *  如果两个单词间有多余的空格
 *  将反转后单词间的空格减少到只含一个
 *
 *  示例四：
 *  输入
 *  Hello!
 *  0
 *  3
 *  输出
 *  EMPTY
 *
 *  说明：
 *  指定反转区间只有一个单词，或无有效单词则统一输出EMPTY
 */
public class 按索引范围翻转文章片段 {
    /**
     * 要求：
     * 反转后的不能包含多余空格
     * 如果反转区间只有一个单词，或无有效单词则统一输出EMPTY
     */
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         //输入文章
         String line = scanner.nextLine();
         //头索引
         int start = scanner.nextInt();
         //尾索引
         int end = scanner.nextInt();
         // 去掉前后的空格
         line = line.trim();
         //根据空格分割字符串将单词分开
         String[] split = line.split(" ");

         // 如果起始数小于0，取0
         start = Math.max(start, 0);
         // 如果结束数大于数组长度，取数组最后一个
         end = Math.min(end, split.length - 1);
         // 指定反转区间只有一个单词，或无有效单词则统一输出EMPTY
         if (start >= end || start >= split.length - 1 ) {
             System.out.println("EMPTY");
             return;
         }
         /**双指针
          * 遍历进行字符串翻转，直至重合
          *
          * 把调换的头索引值放到temp--》尾和头调换--》再把temp存储的头元素放到尾
          */
         while (start < end){
             //要调换的索引值放到temp
             String temp = split[start];
             //尾和头调换
             split[start] = split[end];
             // 再把temp存储的头元素放到尾
             split[end] = temp;
             //索引指针下移一位
             start++;
             //索引指针上移一位
             end--;
         }

         StringBuilder sb = new StringBuilder();
         //拼接字符串，根据空格拼接
         for (String s : split) {
             sb.append(s + " ");
         }
         // 去掉前后的空格，如abc空格--》abc没有空格
         System.out.println(sb.toString().trim());

     }



}
