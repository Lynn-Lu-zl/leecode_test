package huawei.real.score100;

import java.util.Scanner;

/**
 * 【玩牌高手】/翻牌求最大分
 *
 * 给定一个长度为n的整型数组，表示一个选手在n轮内可选择的牌面分数。选手基于规则选牌，
 *
 * 请计算所有轮结束后其可以获得的最高总分数。
 *
 * 选择规则如下：
 *
 * 在每轮里选手可以选择获取该轮牌面，则其总分数加上该轮牌面分数，为其新的总分数。
 * 选手也可不选择本轮牌面直接跳到下一轮，此时将当前总分数还原为3轮前的总分数，若当前轮次小于等于3（即在第1、2、3轮选择跳过轮次），则总分数置为0。
 * 选手的初始总分数为0，且必须依次参加每一轮。
 * 输入描述
 *
 * 第一行为一个小写逗号分割的字符串，表示n轮的牌面分数，1<= n <=20。
 *
 * 分数值为整数，-100 <= 分数值 <= 100。
 *
 * 不考虑格式问题。
 *
 * 输出描述
 *
 * 所有轮结束后选手获得的最高总分数。
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 1,-5,-6,4,3,6,-2
 *
 * 输出
 *
 * 11
 */
public class 玩牌高手 {
     public static void main(String[] args) {


         ///玩牌高手，翻牌求最大分，所有轮结束后其可以获得的最高总分数
         Scanner in = new Scanner(System.in);
         String[] str = in.nextLine().split(",");
         int[] nums = new int[str.length];
         for (int i = 0; i < str.length; i++) {
             nums[i] = Integer.parseInt(str[i]); }
         int[] score = new int[str.length];
         int sum = 0;
         for (int i = 0; i < nums.length; i++) {
             if (i < 3) {
                 if (nums[i] <= 0) {
                     score[i] = 0;
                 } else {
                     score[i] = sum + nums[i]; }
             } else {
                 if (nums[i] > 0) {
                     score[i] = sum + nums[i];
                 } else {
                     score[i] = Math.max(sum + nums[i],score[i - 3]);}}
             sum = score[i]; }
         System.out.println(score[str.length - 1]);


         }
}
