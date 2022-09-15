package huawei.real.score100;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 题目描述
 骰子是一个立方体，每个面一个数字，初始为左1，右2，前3（观察者方向），后4，上5，下6，用123456表示这个状态。放置在平面上，可以向左翻转（用L表示向左翻转1次），可以向右翻转（用R表示向右翻转1次），可以向前翻转（用F表示向前翻转1次），可以向后翻转（用B表示向后翻转一次），可以逆时针旋转（用A表示逆时针旋转90度），可以逆时针旋转（用C表示顺时针旋转90度），现从123456这个初始状态开始，根据输入的动作序列，计算得到最终的状态。

 题目要求
 输入一行，为只包含LRFBAC的字母序列，最大长度为50，可重复
 输出最终状态

 示例1
 输入 LB
 输出 5 6 1 2 3 4
 说明 骰子先向左翻转，在想后翻转，那么此时的状态561234

 示例2
 输入 LR
 输出 1 2 3 4 5 6
 说明 骰子先向左翻转，在想右翻转回到了原始状态，那么此时的状态123456

 示例3
 输入 FCR
 输出 3 4 2 1 5 6
 说明 ：
 骰子先向前翻转，状态变为125643
 再向顺时针旋转回90度，状态变成为562143
 再向右翻转，状态就变成为342156

 TIPS
 先观察一下，变化规则，初始状态{1,2,3,4,5,6}
 'L': {5,6,3,4,2,1}；索引赋值：[0]=[4]；[1]=[5]；[2]=[2]；[3]=[3]；[4]=[1]；[5]=[0]
 'R': {6,5,3,4,1,2}；索引赋值：[0]=[5]；[1]=[4]；[2]=[2]；[3]=[3]；[4]=[0]；[5]=[1]
 'F': {1,2,5,6,4,3}；索引赋值：[0]=[0]；[1]=[1]；[2]=[4]；[3]=[5]；[4]=[3]；[5]=[2]
 'B': {1,2,6,5,3,4}；索引赋值：[0]=[0]；[1]=[1]；[2]=[5]；[3]=[4]；[4]=[2]；[5]=[3]
 'A': {4,3,1,2,5,6}；索引赋值：[0]=[3]；[1]=[2]；[2]=[0]；[3]=[1]；[4]=[4]；[5]=[5]
 'C': {3,4,2,1,5,6}；索引赋值：[0]=[2]；[1]=[3]；[2]=[1]；[3]=[0]；[4]=[4]；[5]=[5]
 */
public class 转骰子问题 {
    public static void main(String[] args) {
        //转骰子,只包含LRFBAC的字母序列
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] init = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < line.length(); i++) {
            char charAt = line.charAt(i);
            if ('L' == charAt) {
                int temp = init[0];
                init[0] = init[4];
                init[4] = init[1];
                init[1] = init[5];
                init[5] = temp;
                continue; }
            if ('R' == charAt) {
                int temp = init[0];
                init[0] = init[5];
                init[5] = init[1];
                init[1] = init[4];
                init[4] = temp;
                continue; }
            if ('F' == charAt) {
                int temp = init[2];
                init[2] = init[4];
                init[4] = init[3];
                init[3] = init[5];
                init[5] = temp;
                continue; }
            if ('B' == charAt) {
                int temp = init[2];
                init[2] = init[5];
                init[5] = init[3];
                init[3] = init[4];
                init[4] = temp;
                continue; }
            if ('A' == charAt) {
                int temp = init[0];
                init[0] = init[3];
                init[3] = init[1];
                init[1] = init[2];
                init[2] = temp;
                continue; }
            if ('C' == charAt) {
                int temp = init[0];
                init[0] = init[2];
                init[2] = init[1];
                init[1] = init[3];
                init[3] = temp; } }
        String s = Arrays.toString(init);
        System.out.println(s.substring(1, s.length() - 1)
            .replace(",", ""));


    }
}
