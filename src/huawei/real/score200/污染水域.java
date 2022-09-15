package huawei.real.score200;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目描述
 * 输入一行字符串，字符串可转换为N*N的数组，数组可认为是一个水域，判断多少天后，水域被全部污染。
 * 数组中只有0和1，0表示纯净，1表示污染，每天只可污染上下左右的水域，如果开始全部被污染，或永远无法污染，则返回-1。
 *输入
 * 1,0,1,0,0,0,1,0,1
 *输出
 * 2
 *
 * 转化为数组为：
 *
 * 1 0 1
 * 0 0 0
 * 1 0 1
 *
 *解释
 * 第一天后水域变为
 *
 * 1 1 1
 * 1 0 1
 * 1 1 1
 * 第二天全部被污染
 */
public class 污染水域 {
    /**
     * 思路分析
     * 这道题是典型的图的多源BFS问题，可以参考【Leetcode】图的多源BFS详解加强对图的多源BFS方法的学习。
     *
     * 这道题跟leetcode：1162. 地图分析意思是一样的，都是从多个源点开始，向四周扩展，问多少次能扩展完。
     *
     * 解题流程：
     *
     * 先把所有的污染源都入队
     * 然后从各个污染源同时开始一圈一圈的向净水扩散，
     * 那么最后扩散到的净水就是花费的天数！
     * 注：这里有一个小细节就是，可以直接修改原数组，扩散到了就在原数组上加1，最后统计数组中最大值-1即可。这里我同时把队列输出数组定义到循环外面，这样就可以直接输出最后一次扩散的值减1即可。
     */
     public static void main(String[] args) {


         Scanner in = new Scanner(System.in);  //污染水域，判断多少天后，水域被全部污染
         String[] s = in.nextLine().split(",");
         int N = (int)Math.sqrt(s.length);
         int[][] grid = new int[N][N];  // 将一维数组转化为二维数组
         for (int i = 0; i < N; i++) {
             for (int j = 0; j < N; j++) {
                 grid[i][j] = Integer.parseInt(s[j + i * N]); } }
         // 图的多源BFS
         int[] dx = new int[]{0, 0, 1, -1};
         int[] dy = new int[]{1, -1, 0, 0};
         Queue<int[]> queue = new ArrayDeque<>();
         // 将所有污染源都入队
         for (int i = 0; i < N; i++) {
             for (int j = 0; j < N; j++) {
                 if (grid[i][j] == 1) {
                     queue.offer(new int[]{i, j}); } } }
         // 全部被无污染或者永远无法被污染
         if (queue.size() == 0 || queue.size() == N * N) {
             System.out.println(-1);
             return; }
         // 从各个污染源开始，一圈圈遍历
         int[] node = null;  // 定义到循环外面，方便输出结果
         while (!queue.isEmpty()) {
             node = queue.poll();
             int x = node[0], y = node[1];
             for (int i = 0; i < 4; i++) {  // 上下左右扩散
                 int newX = x + dx[i];
                 int newY = y + dy[i];
                 // 越界或者不是净水
                 if (newX < 0 || newX >= N || newY < 0 || newY >= N || grid[newX][newY] != 0) {
                     continue; }
                 // 直接修改原数组，把净水改为污染源
                 grid[newX][newY] = grid[x][y] + 1;
                 queue.offer(new int[]{newX, newY}); } }
         // 返回最后一次遍历到净水的天数 - 1，或者输出当前数组的最大值-1
         System.out.println(grid[node[0]][node[1]] - 1);


     }
}
