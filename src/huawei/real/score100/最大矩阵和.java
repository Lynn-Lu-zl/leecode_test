package huawei.real.score100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 给定一个二维整数矩阵，要在这个矩阵中选出一个子矩阵，使得这个子矩阵内所有的数字和尽量大，我们把这个子矩阵称为和最大子矩阵，子矩阵的选取原则是原矩阵中一块相互连续的矩形区域。
 * 输入描述:
 * 输入的第一行包含2个整数n, m(1 <= n, m <= 10)，表示一个n行m列的矩阵，下面有n行，每行有m个整数，同一行中，每2个数字之间有1个空格，最后一个数字后面没有空格，所有的数字的在[-1000, 1000]之间。
 * 输出描述:
 * 输出一行一个数字，表示选出的和最大子矩阵内所有的数字和。
 * 示例1
 * 输入
 * 3 4
 * -3 5 -1 5
 * 2 4 -2 4
 * -1 3 -1 3
 * 输出
 * 20
 * 说明
 * 一个3*4的矩阵中，后面3列的子矩阵求和加起来等于20，和最大。
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124579505
 */
public class 最大矩阵和 {

    public static Map<Node04,Integer> usedMap = new HashMap<Node04, Integer>();
    public static void main(String[] args) {
        //最大矩阵和，使得这个子矩阵内所有的数字和尽量大
        Scanner sc =new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int n1 = Integer.parseInt(nums[0]);//行
        int m1 = Integer.parseInt(nums[1]);//列
        int[][] arr = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < m1; j++) {
                arr[i][j] = Integer.parseInt(input[j]); } }
        System.out.println(calcMax(arr,0,n1,0,m1)); }
    public static int calcMax(int[][] arr,int startX,int endX,int startY,int endY){
        Node04 node = new Node04(startX,endX,startY,endY);
        int max = 0;
        if (usedMap.containsKey(node)) {
            return usedMap.get(node);
        }else {
            //计算当前范围的node结果值，分成4个方向 上下左右各切一刀
            max = calcRes(arr,startX,endX,startY,endY);
            if (startX + 1 <= endX){
                int res1 = calcMax(arr, startX + 1, endX, startY, endY);
                int res2 = calcMax(arr, startX, endX-1, startY, endY);
                max = Math.max(max,Math.max(res1,res2)); }
            if (startY+1 <= endY){
                int res3 = calcMax(arr, startX , endX, startY+1, endY);
                int res4 = calcMax(arr, startX, endX, startY, endY-1);
                max = Math.max(max,Math.max(res3,res4)); }
            Integer put = usedMap.put(node, max); }
        return max; }
    public static int calcRes(int[][] arr,int x1,int x2,int y1,int y2){
        int total = 0;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                total += arr[i][j]; } }
        return total; }
    public static class Node04{
        private int startX;
        private int endX;
        private int startY;
        private int endY;
        public Node04(int startX, int endX, int startY, int endY) {
            this.startX = startX;
            this.endX = endX;
            this.startY = startY;
            this.endY = endY; }
        @Override
        public boolean equals(Object obj) {
            Node04 node = (Node04) obj;
            return node.startX == this.startX && node.endX == this.endX &&
                node.startY == this.startY && node.endY == this.endY; }}

}
