package huawei.real.score200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 题目描述
 * 某通信网络中有N个网络结点，用1到N进行标识。网络通过一个有向无环图表示，其中图的边的值表示结点之间的消息传递时延。
 * 现给定相连节点之间的时延列表times[i]={u，v，w}，其中u表示源结点，v表示目的结点，w表示u和v之间的消息传递时延。
 * 请计算给定源结点到目的结点的最小传输时延，如果目的结点不可达，返回-1。
 * 注：
 *
 * N的取值范围为[1，100];
 * 时延列表times的长度不超过6000，且 1 <= u,v <= N，0 <= w <= 100;
 *
 * 输入的第一行为两个正整数，分别表示网络结点的个数N，以及时延列表的长度M，用空格分隔；
 * 接下来的M行为两个结点间的时延列表[u v w];
 * 输入的最后一行为两个正整数，分别表示源结点和目的结点
 * 输出描述
 * 起点到终点得最小时延，不可达则返回-1
 */
public class 最小传输时延 {
    public static void main(String[] args) {
        //邻接表
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] times = new int[M][3];
        for (int i = 0; i < M; i++) {
            times[i][0] = in.nextInt();
            times[i][1] = in.nextInt();
            times[i][2] = in.nextInt();
        }
        int start = in.nextInt();
        int end = in.nextInt();

        // Dijkstra算法，邻接表
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0];
            for (int i = 0; i < times.length; i++) {
                if (times[i][0] == node) {
                    int next = times[i][1];
                    if (dist[next] > dist[node] + times[i][2]) {
                        dist[next] = dist[node] + times[i][2];
                        queue.add(new int[]{next, dist[next]});
                    }
                }
            }
        }
        if (dist[end] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[end]);
        }
    }

}
