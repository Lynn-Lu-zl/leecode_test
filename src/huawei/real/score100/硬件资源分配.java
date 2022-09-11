package huawei.real.score100;

import java.util.*;

/**
 * 题目描述
 * 有M台服务器，每台服务器有以下属性：编号、CPU核数（1~100）、内存、CPU架构（0~8）、是否支持NP加速的标识（0,1）。然后有一个资源分配要求，要求分配N台满足要求的服务器。具体如下：CPU核数>=cpuCount、内存>=memSize、CPU架构=cpuArch、是否支持NP加速=supportNP。其中，cpuCount、memSize、cpuArch、supportNP为这个要求输入的分配参数。
 * 分配时会指定优先级策略，策略如下：
 *
 * 策略1：CPU优先，优先选择CPU核数满足分配要求并且最接近分配要求的cpuCount。如果CPU核数相同，在按内存满足要求并选择最接近memSize的服务器分配。
 * 策略2：内存优先，优先选择内存满足分配要求并且最接近分配要求的memSize。如果内存相同，在按cpu核数满足要求并选择最接近cpuCount的服务器分配
 * 如果两台服务器属性都相同，则按服务器编号从小到大选择（编号不会重复）
 *
 * 输入描述
 * 第一行：服务器数量M
 * 接下来M行为M台服务器属性的数组
 * 下一行为分配要求：最大分配数量N，分配策略strategy，cupCount，memSize，cpuArch，supportNP
 * 其中：
 * 1<=M<=1000
 * 1<=N<=1000
 * strategy：1表示策略1,2表示策略2
 * 1<=cpuCount<=100
 * 10<=memSize<=1000
 * 0<=cpuArch<=8，另外，cpuArch使用9表示所有服务器架构都满足分配要求
 * 0<=supportNP<=1，另外，为2时表示无论是否支持NP加速都满足分配要求
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 10
 * 11
 * 输出描述
 * 先输出实际分配数量，后按照分配的服务器编号从小到大依次输出，以空格分开
 * 1
 * 样例1
 * 输入
 * 4
 * 0,2,200,0,1
 * 1,3,400,0,1
 * 2,3,400,1,0
 * 3,3,300,0,1
 * 3 1 3 200 0 1
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 输出
 * 2 1 3
 * 1
 * 说明
 * 只有1和3满足要求，要求分配2台服务器，所以结果为2 1 3
 *
 * 样例2
 * 输入
 * 6
 * 0,2,200,0,1
 * 1,4,330,2,1
 * 2,3,400,3,1
 * 3,3,310,1,1
 * 4,3,320,8,1
 * 5,3,330,0,1
 * 3 2 3 300 9 2
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 输出
 * 3 3 4 5
 * 1
 * 说明
 * 编号1~5都满足分配要求，按策略2分配即内存优先，内存>=300并且最接近300的服务器编号是3 4 1 5 2。
 * 其中1和5内存相同，然后会比较CPU，即CPU>=3且最接近的，所以5优先于1.因此最后分配的三台服务器是3 4 5。
 * 输出时先输出数量3，再按编号排序输出3 4 5
 * ————————————————
 * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/124221326
 */
public class 硬件资源分配 {

    /**
     * 思路分析
     * 题目很长，考察的跟华为机试2022.4.6：查找舆情热词一样，多关键字排序，就是自定义排序。这里有两种方法进行自定义排序：
     *
     * 优先队列实现自定义排序。
     * HashMap实现自定义排序。
     * 注意区别是：优先队列把整个服务器的信息都存储到队列里面，HashMap是key为编号，其余信息为value。
     * ————————————————
     * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/124221326
     */

    //优先队列实现
    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     int M = Integer.parseInt(in.nextLine());
    //     int[][] service = new int[M][5];
    //     for (int i = 0; i < M; i++) {
    //         String[] str = in.nextLine().split(",");
    //         for (int j = 0; j < 5; j++) {
    //             service[i][j] = Integer.parseInt(str[j]);
    //         }
    //     }
    //     int N = in.nextInt();
    //     int strategy = in.nextInt();
    //     int cpuCount = in.nextInt();
    //     int memSize = in.nextInt();
    //     int cpuArch = in.nextInt();
    //     int supportNP = in.nextInt();
    //
    //     // 通过优先队列自定义排序
    //     PriorityQueue<int[]> queue = null;
    //     if (strategy == 1) {  // 如果策略1，先CPU核数，再内存，再编号
    //         queue = new PriorityQueue<>((o1, o2) -> {
    //             if (o1[1] != o2[1]) {
    //                 return o1[1] - o2[1];
    //             } else {
    //                 if (o1[2] != o2[2]) {
    //                     return o1[2] - o2[2];
    //                 } else {
    //                     return o1[0] - o2[0];
    //                 }
    //             }
    //         });
    //     }
    //     if (strategy == 2) {  // 如果策略2，先内存，再CPU核数，再编号
    //         queue = new PriorityQueue<>((o1, o2) -> {
    //             if (o1[2] != o2[2]) {
    //                 return o1[2] - o2[2];
    //             } else {
    //                 if (o1[1] != o2[1]) {
    //                     return o1[1] - o2[1];
    //                 } else {
    //                     return o1[0] - o2[0];
    //                 }
    //             }
    //         });
    //     }
    //     for (int i = 0; i < M; i++) {  // 将满足条件的服务器加入到queue中
    //         if (service[i][1] >= cpuCount && service[i][2] >= memSize && (service[i][3] == cpuArch || cpuArch == 9)
    //             && (service[i][4] == supportNP || supportNP == 2)) {
    //             queue.add(service[i]);
    //         }
    //     }
    //     int resCount = Math.min(queue.size(), N);  // 实际分配数量为所有满足条件的服务器与最大分配数量N之间的最小值
    //     int[] res = new int[resCount];  // 满足条件的服务器编号
    //     for (int i = 0; i < resCount; i++) {
    //         res[i] = queue.poll()[0];
    //     }
    //     Arrays.sort(res);
    //     System.out.print(resCount);
    //     for (int i = 0; i < resCount; i++) {
    //         System.out.print(" " + res[i]);
    //     }
    // }

    //HashMap实现
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = Integer.parseInt(in.nextLine());
        int[][] service = new int[M][5];
        for (int i = 0; i < M; i++) {
            String[] str = in.nextLine().split(",");
            for (int j = 0; j < 5; j++) {
                service[i][j] = Integer.parseInt(str[j]);
            }
        }
        int N = in.nextInt();
        int strategy = in.nextInt();
        int cpuCount = in.nextInt();
        int memSize = in.nextInt();
        int cpuArch = in.nextInt();
        int supportNP = in.nextInt();

        // 通过HashMap实现自定义排序
        HashMap<Integer, int[]> map = new HashMap<>();


        for (int i = 0; i < M; i++) {  // 将满足条件的服务器加入到queue中
            if (service[i][1] >= cpuCount && service[i][2] >= memSize && (service[i][3] == cpuArch || cpuArch == 9)
                && (service[i][4] == supportNP || supportNP == 2)) {
                map.put(service[i][0], Arrays.copyOfRange(service[i], 1, service[i].length));
            }
        }
        List<Map.Entry<Integer, int[]>> list = new ArrayList<>(map.entrySet());
        if (strategy == 1) {  // 如果策略1，先CPU核数，再内存，再编号
            // lambda表达式，也可以使用比较器
            list.sort((o1, o2) -> (o1.getValue()[0] == o2.getValue()[0] ? (o1.getValue()[1] == o2.getValue()[1] ?
                o1.getKey() - o2.getKey() : o1.getValue()[1] - o2.getValue()[1]) :  o1.getValue()[0] - o2.getValue()[0]));
        }
        if (strategy == 2) {  // 如果策略2，先内存，再CPU核数，再编号
            list.sort((o1, o2) -> (o1.getValue()[1] == o2.getValue()[1] ? (o1.getValue()[0] == o2.getValue()[0] ?
                o1.getKey() - o2.getKey() : o1.getValue()[0] - o2.getValue()[0]) :  o1.getValue()[1] - o2.getValue()[1]));
        }
        int resCount = Math.min(map.size(), N);  // 实际分配数量为所有满足条件的服务器与最大分配数量N之间的最小值
        int[] res = new int[resCount];  // 满足条件的服务器编号

        for (int i = 0; i < resCount; i++) {
            Map.Entry<Integer, int[]> entry = list.get(i);
            res[i] = entry.getKey();
        }
        Arrays.sort(res);
        System.out.print(resCount);
        for (int i = 0; i < resCount; i++) {
            System.out.print(" " + res[i]);
        }
    }


}
