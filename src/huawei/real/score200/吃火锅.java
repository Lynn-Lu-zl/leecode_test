package huawei.real.score200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**https://f.daixianiu.cn/csdn/3934865748927646.html
 * 题目描述
 * 入职后，导师会请你吃饭，你选择了火锅。
 *
 * 火锅里会在不同时间下很多菜。
 *
 * 不同食材要煮不同的时间，才能变得刚好合适。你希望吃到最多的刚好合适的菜，但你的手速不够快，用m代表手速，每次下手捞菜后至少要过m庙才能在捞（每次只能捞一个）。
 *
 * 那么用最合理的策略，最多能吃到多少刚好合适的菜？
 *
 * 输入描述：
 * 第一行两个整数n，m，其中n代表往锅里下的菜的个数，m代表手速。
 *
 * 接下来有n行，每行有两个数x，y代表第x秒下的菜过y秒才能变得刚好合适。
 * 输入描述:
 *
 * 第一行两个整数n，m，其中n 代表往锅里下的菜的个数，m 代表手速。
 * 接下来有n行，每行有两个数x，y 代表第x秒下的菜过y秒才能变得刚好合适。
 * (1 < n,m < 1000)
 * (1 <x, y<1000)
 *
 * 输出描述:
 *
 * 输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量
 *
 * 示例1
 *
 * 输入
 *
 * 2 1
 *
 * 1 2
 *
 * 2 1
 *
 * 输出
 *
 * 1
 *
 * 说明
 *
 * 一共下了两个菜，在第一秒下的菜需要到第三秒吃，在第二秒下的菜也要到第三秒吃，所以只能吃一个
 *
 * 示例2
 *
 * 输入
 *
 * 3 1
 *
 * 1 2
 *
 * 1 3
 *
 * 2 3
 *
 * 输出
 *
 * 3
 *
 * 说明
 *
 * 一共下了两个菜，可以每秒捞一个，第一个在第一秒下的菜需要到第3秒吃，第二个在第一秒下的菜需要到第4秒吃，在第二秒下的菜也要到第5秒吃，所以三个都能吃到
 *
 * （1 < n, m < 1000）
 *
 * （1 < x, y < 1000）
 *
 * 输出描述：
 * 输出一个整数代表用最合理的策略，最多能吃到刚好合适的菜的数量
 * ————————————————
 * 版权声明：本文为CSDN博主「可乐大数据」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_43005694/article/details/123328460
 */
public class 吃火锅 {
    public static void main(String[] args) {

        /**
         * 解题思路：
         * 菜可以吃的秒数=下菜的秒数x+菜适合吃的秒数y
         * 第一个菜可以直接吃，后面的菜必须在吃前一个菜的秒数上加上手速
         * 同一秒的菜肯定只能吃一个
         */
        //火锅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>(); //treeset可以自动去重和排序
        for(int i=0;i<n;i++){
            treeSet.add(sc.nextInt()+sc.nextInt()); //所有菜的最佳时机
        }
        int count = 0;  //吃菜的次数
        List<Integer> list = new ArrayList<>(treeSet);
        int len = list.size();
        int time = 0;   //吃菜的时间
        for(int i=0;i<len;i++){
            if(time <= list.get(i)){    //吃菜的时间小于菜的最佳时机，表示可以吃上
                count++;
                time = list.get(i)+m;   //这个菜吃完需要过m秒才能再次吃菜
            }
        }
        System.out.println(count);
    }
}
