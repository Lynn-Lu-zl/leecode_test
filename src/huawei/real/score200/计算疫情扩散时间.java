package huawei.real.score200;

import java.util.Scanner;

/**
 * 题目描述： 在一个地图中(地图由n*n个区域组成），有部分区域被感染病菌。感染区域每天都会把周围（上下左右）的4个区域感染。 请根据给定的地图计算，多少天以后，全部区域都会被感染。
 *
 * 如果初始地图上所有区域全部都被感染，或者没有被感染区域，返回-1。
 *
 * 输入描述: 一行N*N个数字（只包含0,1，不会有其他数字）表示一个地图，数字间用,分割，0表示未感染区域，1表示已经感染区域 每N个数字表示地图中一行，输入数据共表示N行N列的区域地图。 例如输入1,0,1,0,0,0,1,0,1，表示地图 1,0,1 0,0,0
 * 1,0,1
 * 输出描述: 一个整数，表示经过多少天以后，全部区域都被感染
 *
 * 示例1
 * 输入
 * 1,0,1,0,0,0,1,0,1
 * 输出
 * 2
 * 说明
 * 1天以后，地图中仅剩余中心点未被感染；2天以后，全部被感染。
 *
 * 示例2
 * 输入
 * 0,0,0,0
 * 输出
 * -1
 * 说明
 * 无感染区域
 *
 * 示例3
 * 输入
 * 1,1,1,1,1,1,1,1,1
 * 输出
 * -1
 * 说明
 * 全部都感染
 *
 * 备注: 1<=N<200
 * ————————————————
 * 版权声明：本文为CSDN博主「青玉良田」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44505462/article/details/125494603
 */
public class 计算疫情扩散时间 {

         // 优化思路，把繁琐的数组转字符串判断是否包含0，
         // 改为抽象一个检查数组判断包含0的方法，
         // 去除转字符串数组，再转字符串的繁琐过程

         //检查区域是否已经全部被污染
         public static int isCheck(int[][] source,int n){
             for(int i = 0;i < n;i++){
                 for(int j = 0;j <n;j++){
                     if(source[i][j]==0){
                         return 0;
                     }
                 }
             }
             return 1;
         }

         //污染过程
         public static int[][] black(int[][] source,int n){

             //临时数组，保存改变的数组temp，source为原数组，作为基点，查找相邻污染点
             int[][] temp = new int[n][n];
             for(int i = 0;i < n;i++){
                 for(int j = 0;j <n;j++){
                     temp[i][j]=source[i][j];
                 }
             }

             //污染动作
             for(int i = 0;i < n;i++){
                 for(int j = 0;j <n;j++){
                     if(source[i][j]==1){
                         if(i-1>=0){//上
                             temp[i-1][j]=1;
                         }
                         if(j-1>=0){//左
                             temp[i][j-1]=1;
                         }
                         if(i+1<=n-1){//下
                             temp[i+1][j]=1;
                         }
                         if(j+1<=n-1){//右
                             temp[i][j+1]=1;
                         }
                     }
                 }
             }
             return temp;
         }

         public static void main(String[] args){
             // long startTime=System.currentTimeMillis(); //获取开始时间

             //获取输入数据
             Scanner in = new Scanner(System.in);
             String str = in.nextLine();

             //如果全为0或者全为1，返回-1
             if(!str.contains("1")||!str.contains("0")){
                 System.out.print("-1");
                 System.exit(0);
             }

             //分割字符串，获取二维数组维度n
             String[] arr = str.split(",");
             int len = arr.length;
             int n = (int) Math.sqrt(len);

             //初始化源二维数组source
             int[][] source = new int[n][n];
             for(int i = 0;i < n;i++){
                 for(int j = 0;j <n;j++){
                     source[i][j]=Integer.parseInt(arr[i*n+j]);
                 }
             }

             //定义天数
             int day = 0;

             //若检查区域还没有全部被污染，则继续循环
             while(isCheck(source,n)== 0){
                 source = black(source,n);
                 day++;
             }

             //输出结果
             System.out.print(day);

             //计算运行时间
             // long endTime=System.currentTimeMillis(); //获取结束时间
             // System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
         }




}
