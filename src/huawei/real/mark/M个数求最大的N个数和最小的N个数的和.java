package huawei.real.score100;

import java.util.*;

/**最大N个数与最小N个数的和
 *
 * 在提供的M个数里找最大的N个和最小的N个的和，
 * 需要自己去重，
 * 最大数集合和最小数集合有重合的则返回-1
 * 输入
 * 第一行是数组元素个数M，M标识数组大小
 * 第二行是数组里的数字，输入M个数，标识数组内容,每个数字用空格隔开，
 *
 * 第三个数字是N，N表达需要计算的最大、最小N个数
 *
 * 输入
 * 6
 * 2 3 1 5 12 7
 * 2
 * 输出
 * 22
 * 最大的2个数是 12 7，最小的两个数是1 2，则输出 12+7+1+2=22
 *
 * 输入
 * 4
 * 1 7 1 2 2
 * 2
 * 输出
 * -1
 * 最大的2个数是7 2，最小的2个数是1 2，有重合的输出-1
 *
 * 示例1
 * 输入
 * 5
 * 95 88 83 64 100
 * 2
 * 输出
 * 342
 * 说明
 * 最大2个数[100,95],最小2个数[83,64], 输出为342
 * 示例2
 * 输入
 * 5
 * 3 2 3 4 2
 * 2
 * 输出
 * -1
 * 说明
 * 最大2个数[4,3],最小2个数[3,2], 有重叠输出为-1
 */
public class M个数求最大的N个数和最小的N个数的和 {
    /**
     * 读取数据后，
     * 第一步去重，
     * 第二步根据去重后留下的数个数可以算出是否会返回-1，
     * 如果不返回-1则继续计算，
     * 将数组排序，
     * 取前后N个求和返回。
     * 也可以不排序，
     * 定义两个堆，一个最大堆，一个最小堆，
     * 让最大堆存最大的N个数，
     * 最小堆存最小的N个数。
     * @param args
     */
     public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
         int count = Integer.parseInt(sc.nextLine());
         String[] input = sc.nextLine().split(" ");
         int max = Integer.parseInt(sc.nextLine());
         Set<Integer> set = new HashSet<>();
         for (int i = 0; i < input.length; i++) {
             set.add(Integer.parseInt(input[i]));
         }
         List<Integer> list = new ArrayList<>(set);
         Collections.sort(list);
         //找到最大N个数的最小值 ma < mi
         //最小N个数的最大值 mi
         List<Integer> listMin = list.subList(0,max);
         List<Integer> listMax = list.subList(list.size() - max,list.size());
         if (listMin.get(max-1) > listMax.get(0)){
             System.out.println(-1);
         }else {
             int total = 0;
             for (int i = 0; i < max; i++) {
                 total += listMin.get(i) + listMax.get(i);
             }
             System.out.println(total);
         }

         }
}
