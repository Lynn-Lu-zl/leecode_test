package huawei.real.score200;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Scanner;

/**https://f.daixianiu.cn/csdn/7008528433206368.html
 * 1、 房间由X*Y的方格组成，例如下图为6*4的大小。每一个方格以坐标(x，y)描述。
 * 2、 机器人固定从方格(0，0)出发，只能向东或者向北前进。出口固定为房间的最东北角，如下图的方格(5，3)。用例保证机器人可以从入口走到出口。
 * 3、 房间有些方格是墙壁，如(4，1)，机器人不能经过那儿。
 *
 * 4、 有些地方是一旦到达就无法走到出口的，如标记为B的方格，称之为陷阱方格。
 *
 * 5、 有些地方是机器人无法到达的的，如标记为A的方格，称之为不可达方格，不可达方格不包括墙壁所在的位置。
 *
 * 6、 如下示例图中，陷阱方格有2个，不可达方格有3个。
 *
 * 7、 请为该机器人实现路径规划功能：给定房间大小、墙壁位置，请计算出陷阱方格与不可达方格分别有多少个。
 *
 *
 *
 * 输入描述:
 *
 * 1） 第一行为房间的的X和Y (0<X,Y<=1000)
 * 2） 第二行为房间中墙壁的个数N（0<=N<X*Y）
 * 3） 接着下面会有N行墙壁的坐标
 * 同一行中如果有多个数据以一个空格隔开，用例保证所有的输入数据均合法。（结尾不带回车换行）
 *
 * 输出描述:
 *
 * 1）陷阱方格与不可达方格数量，两个信息在一行中输出，以一个空格隔开。（结尾不带回车换行）
 *
 * 示例1
 * 输入
 *
 * 6 4
 *
 * 5
 *
 * 0 2
 *
 * 1 2
 *
 * 2 2
 *
 * 4 1
 *
 * 5 1
 *
 * 输出
 *
 * 2 3
 *
 * 说明
 *
 * 该输入对应上图示例中的迷宫，陷阱方格有2个，不可达方格有3个
 *
 * 示例2
 * 输入
 *
 * 6 4
 *
 * 4
 *
 * 2 0
 *
 * 2 1
 *
 * 3 0
 *
 * 3 1
 *
 * 输出
 *
 * 0 4
 *
 * 说明
 *
 * 该输入对应的迷宫如下图，没有陷阱方格，不可达方格有4个，分别是(4, 0) (4, 1) (5, 0) (5, 1)
 *
 *
 *
 * 解题思路：
 * 将地图转换成二维数组，以例一为准，地图转换如下：
 *
 * 机器人初始位置在【0,0】，出口在【5,3】，方向向下和向右
 *
 * 值为0表示没有走过，-1表示墙，1表示能通过，2表示死路
 */
public class 机器人走迷宫 {

    /**
     *  -1  表示墙
     *  0   表示没有走过的，无法到达之地
     *  1   表示可以到达的
     *  2   表示死路
     * @param args
     */
    public static int[][] room;
    public static int x;
    public static int y;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        room = new int[x][y];
        int n = sc.nextInt();
        while (n-- > 0)
        {
            room[sc.nextInt()][sc.nextInt()] = -1;  //-1表示有墻
        }
        out(0, 0);
        int countA = 0, countB = 0;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(room[i][j] == 2){    //2表示死路
                    countB++;
                }else if(room[i][j] == 0){  //表示沒有走过的路，即无法到达的地方
                    countA++;
                }
            }
        }
        System.out.print(countB + " " + countA);
    }
    public static void out( int i, int j)
    {
        if(i==x-1 && j==y-1){   //表示到达终点，也就是出口
            room[i][j] = 1; //终点可以到达，设置为1
            return;
        }
        if(room[i][j] != 0){    //已经确定了不需要再次确定
            return;
        }
        if(i<x-1){  //没有到达x轴边界，继续探索
            out(i+1,j);
        }
        if(j<y-1){  //没有到达y轴边界，继续探索
            out(i,j+1);
        }
        if(i==x-1 || j==y-1){   //到达边界
            if(i==x-1 && j<y-1 && room[i][j+1]!=1){
                room[i][j] = 2; //到达x轴边界，上边是不可到达的，则此格为死路
            }else if(j==y-1 && i<x-1 && room[i+1][j]!=1){
                room[i][j] = 2; //到达y轴边界，右边是不可到达的，则此格为死路
            }else {
                room[i][j] = 1; //可以到达的格子
            }
        }else if(room[i][j+1]!=1 && room[i+1][j]!=1){
            room[i][j] = 2; //右边和上边都是不可到达，则此格为死路
        }else {
            room[i][j] = 1; //可到达的格子
        }
    }




}
