package huawei.real.score200;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * https://f.daixianiu.cn/csdn/895998501292594.html
 * 贪吃蛇是一个经典游戏，蛇的身体由若干方格连接而成，身体随蛇头移动。蛇头触碰到食物时，蛇的长度会增加一格。蛇头和身体的任一方格或者游戏版图边界碰撞时，游戏结束。
 * 下面让我们来完成贪吃蛇游戏的模拟。给定一个N*M的数组arr，代表N*M个方格组成的版图，贪吃蛇每次移动一个方格。若arr[i][j] == 'H'，表示该方格为贪吃蛇的起始位置；若arr[i][j] == 'F'，表示该方格为食物，若arr[i][j] == 'E'，表示该方格为空格。
 *
 * 贪吃蛇初始长度为1，初始移动方向为向左。为给定一系列贪吃蛇的移动操作，返回操作后蛇的长度，如果在操作执行完之前已经游戏结束，返回游戏结束时蛇的长度。
 *
 * 贪吃蛇移动、吃食物和碰撞处理的细节见下面图示：
 *https://img-blog.csdnimg.cn/1a54511285eb48338ae2a6480bd226c5.png
 *
 *
 *  图1：截取了贪吃蛇移动的一个中间状态，H表示蛇头，F表示食物，数字为蛇身体各节的编号，蛇为向左移动，此时蛇头和食物已经相邻
 * 图2：蛇头向左移动一格，蛇头和食物重叠，注意此时食物的格子成为了新的蛇头，第1节身体移动到蛇头位置，第2节身体移动到第1节身体位置，以此类推，最后添加第4节身体到原来第3节身体的位置。
 * 图3：蛇头继续向左移动一格，身体的各节按上述规则移动，此时蛇头已经和边界相邻，但还未碰撞。
 * 图4：蛇头继续向左移动一格，此时蛇头已经超过边界，发生碰撞，游戏结束。
 * 图5和图6给出一个蛇头和身体碰撞的例子，蛇为向上移动。图5时蛇头和第7节身体相邻，但还未碰撞；图6蛇头向上移动一格，此时蛇头和第8节身体都移动到了原来第7节身体的位置，发生碰撞，游戏结束。
 *
 * 输入描述:
 * 输入第一行为空格分隔的字母，代表贪吃蛇的移动操作。字母取值为U、D、L、R和G，U、D、L、R分别表示贪吃蛇往上、下、左、右转向，转向时贪吃蛇不移动，G表示贪吃蛇按当前的方向移动一格。用例保证输入的操作正确。第二行为空格分隔的两个数，指定N和M，为数组的行和列数。余下N行每行是空格分隔的M个字母。字母取值为H、F和E，H表示贪吃蛇的起始位置，F表示食物，E表示该方格为空。用例保证有且只有一个H，而F和E会有多个。
 *
 * 输出描述:
 * 输出一个数字，为蛇的长度
 *
 *
 * 示例1
 * 输入
 *
 * D G G
 *
 * 3 3
 *
 * F F F
 *
 * F F H
 *
 * E F E
 *
 * 输出
 *
 * 1
 *
 * 说明
 *
 * 贪吃蛇一开始就向下转向并且移动两步，此时蛇头已经和边界碰撞，游戏结束，蛇没有吃任何食物，故长度为1
 *
 * 示例2
 * 输入
 *
 * G G G
 *
 * 3 3
 *
 * F F F
 *
 * F F H
 *
 * E F E
 *
 * 输出
 *
 * 3
 *
 * 说明
 *
 * 贪吃蛇保存最初的向左方向移动三步，此时蛇头已经和边界碰撞，游戏结束，蛇吃了两个食物，故长度为3
 *
 * 解题思路：
 * 1、游戏面板可以格式化为二维数组
 *
 * 2、将蛇的头部和身体分开，头部为一个包含x，y坐标的数组，身体为包含多个数组的集合。
 *
 * 3、蛇的前行：头部的x，y坐标的变更，向上：x-1；向下：x+1；向左：y-1；向右：y+1。身体部分：集合最前面加上之前头部数组，没有迟到食物则直接取出最后一个数组；碰到食物则不需要取出数组，但要记得将F置为E，防止后面再次走到此位置
 */
public class 贪吃蛇 {
    public static Deque<int[]> snake = new ArrayDeque<>();  //蛇的身体
    public static String[][] panel ;    //游戏面板
    public static int[] header = new int[2];    //头部
    public static String direction = "left"; //移动方向，初始方向为左
    public static boolean over = false; //撞墙游戏结束
    public static int row;  //游戏面板宽度
    public static int col;  //游戏面板长度
    public static void main(String[] args) {
        //贪吃蛇
        Scanner sc = new Scanner(System.in);
        String[] action = sc.nextLine().split(" ");
        String[] str = sc.nextLine().split(" ");
        row = Integer.valueOf(str[0]);
        col = Integer.valueOf(str[1]);
        panel = new String[row][col];
        int step = action.length;
        for(int i=0;i<row;i++){
            String[] temp = sc.nextLine().split(" ");
            for(int j=0;j<col;j++){
                panel[i][j] = temp[j];
                if(temp[j].equals("H")){    //头部位置
                    header[0] = i;
                    header[1] = j;
                }
            }
        }
        for(int i=0;i<step;i++){
            if(action[i].equals("U")){
                direction = "up";
            }else if(action[i].equals("D")){
                direction = "down";
            }else if(action[i].equals("L")){
                direction = "left";
            }else if(action[i].equals("R")){
                direction = "right";
            }else if(action[i].equals("G")){
                move();
            }
            if(over){
                break;
            }
        }
        System.out.println(snake.size()+1);
    }

    public static void move(){
        int x = header[0];
        int y = header[1];
        int len = snake.size();
        if(direction.equals("up")){
            if(x==0){
                over = true;
                return; //已经到边界，向上越界
            }
            header[0] = x-1;
            snake.addFirst(new int[]{x,y});
            if(panel[x-1][y].equals("F") ){
                panel[x-1][y] = "E";
            }else if(len != 0){
                snake.removeLast();
            }
        }else if(direction.equals("down")){
            if(x==row-1){
                over = true;
                return; //已经到边界，向下越界
            }
            header[0] = x+1;
            snake.addFirst(new int[]{x,y});
            if(panel[x+1][y].equals("F")){
                panel[x+1][y] = "E";
            }else if(len != 0){
                snake.removeLast();
            }
        }else if(direction.equals("left")){
            if(y==0){
                over = true;
                return; //已经到边界，向左越界
            }
            header[1] = y-1;
            snake.addFirst(new int[]{x,y});
            if(panel[x][y-1].equals("F")){
                panel[x][y-1] = "E";
            }else if(len != 0){
                snake.removeLast();
            }
        }else if(direction.equals("right")){
            if(y==col-1){
                over = true;
                return; //已经到边界，向右越界
            }
            header[1] = y+1;
            snake.addFirst(new int[]{x,y});
            if(panel[x][y+1].equals("F")){
                panel[x][y+1] = "E";
            }else if(len != 0){
                snake.removeLast();
            }
        }
        snake.forEach(v->{
            if(Arrays.equals(v,header)){    //发生碰撞
                over = true;
                return;
            }
        });
    }

}
