package huawei.real.score100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 在通信系统中，一个常见的问题是对用户进行不同策略的调度，会得到不同的系统消耗和性能。
 * 假设当前有n个待串行调度用户，每个用户可以使用A/B/C三种不同的调度策略，不同的策略会消耗不同的系统资源。请你根据如下规则进行用户调度，并返回总的消耗资源数。
 * 规则：
 * 1、相邻的用户不能使用相同的调度策略，例如，第1个用户使用了A策略，则第2个用户只能使用B或者C策略。
 * 2、对单个用户而言，不同的调度策略对系统资源的消耗可以归一化后抽象为数值。例如，某用户分别使用A/B/C策略的系统消耗分别为15/8/17。
 * 3、每个用户依次选择当前所能选择的对系统资源消耗最少的策略（局部最优），如果有多个满足要求的策略，选最后一个。
 * 输入描述:
 * 第一行表示用户个数n
 * 接下来每一行表示一个用户分别使用三个策略的系统消耗resA resB resC
 * 输出描述:
 * 最优策略组合下的总的系统资源消耗数
 * 示例1
 * 输入
 * 3
 * 15 8 17
 * 12 20 9
 * 11 7 5
 * 输出
 * 24
 * 说明
 * 1号用户使用B策略，2号用户使用C策略，3号用户使用B策略。系统资源消耗: 8 + 9 + 7 = 24。
 * 备注:
 * 所有策略对系统的资源消耗均为正整数，n < 1000
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124551079
 */
public class 用户调度问题 {
     // public static void main(String[] args) {
     //     Scanner sc = new Scanner(System.in);
     //     int count = Integer.parseInt(sc.nextLine());
     //     List<List<Integer>> lists = new ArrayList<>();
     //     for (int i = 0; i < count; i++) {
     //         String[] input = sc.nextLine().split(" ");
     //         List<Integer> list = new ArrayList<>();
     //         for (int j = 0; j < 3; j++) {
     //             list.add(Integer.parseInt(input[j]));
     //         }
     //         lists.add(list);
     //     }
     //     //执行策略
     //     int pre = -1;
     //     int total = 0;
     //     for (int i = 0; i < lists.size(); i++) {
     //         List<Integer> list = lists.get(i);
     //         int min = Integer.MAX_VALUE;
     //         if (i == 0){
     //             for (int j = 0; j < 3; j++) {
     //                 if (min >= list.get(j)){
     //                     min = list.get(j);
     //                     pre = j;
     //                 }
     //             }
     //         }else {
     //             int tem = 0;
     //             for (int j = 0; j < 3; j++) {
     //                 if (j != pre && min >= list.get(j)){
     //                     min = list.get(j);
     //                     tem = j;
     //                 }
     //             }
     //             pre = tem;
     //         }
     //         total += min;
     //     }
     //     System.out.println(total);
     // }


    /**
     * 法2,85%
     */
    public static void main(String[] args) {

        // 用户调度问题，1号用户使用B策略，2号用户使用C策略
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<TreeMap<Integer, Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = in.nextLine().split(" ");
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < split.length; j++) {
                map.put(Integer.parseInt(split[j]), j); }
            res.add(map); }
        Integer res1 = new ArrayList<>(res.get(0).keySet()).get(0);
        int sum = res1;
        Integer type = res.get(0).get(res1);
        if (res.size() > 1) {
            for (int i = 1; i < res.size(); i++) {
                ArrayList<Integer> keyList = new ArrayList<>(res.get(i).keySet());
                Integer resN = keyList.get(0);
                Integer typeN = res.get(i).get(resN);
                if (!typeN.equals(type)) {
                    sum += resN;
                    type = typeN;
                } else {
                    sum += keyList.get(1);
                    type = res.get(i).get(keyList.get(1)); } } }
        System.out.println(sum);


    }

}
