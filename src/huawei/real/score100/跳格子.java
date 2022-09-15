package huawei.real.score100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 地上共有N个格子，你需要跳完地上所有的格子，但是格子间是有强依赖关系的，跳完前一个格子后，后续的格子才会被开启，格子间的依赖关系由多组steps数组给出，steps[0]表示前一个格子,steps[1]表示steps[0]可以开启的格子:
 *
 * 比如[0,1]表示从跳完第0个格子以后第1个格子就开启了，比如[2,1]，[2,3]表示跳完第2个格子后第1个格子和第3个格子就被开启了
 *
 * 请你计算是否能由给出的steps数组跳完所有的格子,如果可以输出yes，否则输出no
 *
 * 说明：
 *
 * 1.你可以从一个格子跳到任意一个开启的格子
 *
 * 2.没有前置依赖条件的格子默认就是开启的
 *
 * 3.如果总数是N，则所有的格子编号为[0,1,2,3…N-1]连续的数组
 *
 * 输入描述:
 *
 * 输入一个整数N表示总共有多少个格子，接着输入多组二维数组steps表示所有格子之间的依赖关系
 *
 * 输出描述:
 *
 * 如果能按照steps给定的依赖顺序跳完所有的格子输出yes
 *
 * 否则输出no
 *
 * 示例1
 *
 * 输入
 *
 * 3
 *
 * 0 1
 *
 * 0 2
 *
 * 输出
 *
 * yes
 *
 * 说明
 *
 * 总共有三个格子[0,1,2]，跳完0个格子后第1个格子就开启了，跳到第0个格子后第2个格子也被开启了，按照0->1->2或者0->2->1的顺序都可以跳完所有的格子
 *
 * 示例2
 *
 * 输入
 *
 * 2
 *
 * 1 0
 *
 * 0 1
 *
 * 输出
 *
 * no
 *
 * 说明
 *
 * 总共有2个格子，第1个格子可以开启第0格子，但是第1个格子又需要第0个格子才能开启，相互依赖，因此无法完成
 *
 * 示例3
 *
 * 输入
 *
 * 6
 *
 * 0 1
 *
 * 0 2
 *
 * 0 3
 *
 * 0 4
 *
 * 0 5
 *
 * 输出
 *
 * yes
 *
 * 说明
 *
 * 总共有6个格子，第0个格子可以开启第1,2,3,4,5个格子，所以跳完第0个格子之后其他格子都被开启了，之后按任何顺序可以跳完剩余的格子
 *
 * 示例4
 *
 * 输入
 *
 * 5
 *
 * 4 3
 *
 * 0 4
 *
 * 2 1
 *
 * 3 2
 *
 * 输出
 *
 * yes
 *
 * 说明
 *
 * 跳完第0个格子可以开启格子4，跳完格子4可以开启格子3，跳完格子3可以开启格子2，跳完格子2可以开启格子1，按照0->4->3->2->1这样就跳完所有的格子
 *
 * 示例5
 *
 * 输入
 *
 * 4
 *
 * 1 2
 *
 * 1 0
 *
 * 输出
 *
 * yes
 *
 * 说明
 *
 * 总共4个格子[0,1,2,3]，格子1和格子3没有前置条件所以默认开启，格子1可以开启格子0和格子2，所以跳到格子1之后就可以开启所有的格子，因此可以跳完所有格子
 * ————————————————
 * 版权声明：本文为CSDN博主「Jay=Zheng」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/JackSnack/article/details/124554285
 */
public class 跳格子 {
    private static final int NOT_VISITED = 0;
    private static final int VISITED = 1;
    private static final int VISIT_FINISHED = 2;
    static int[] visitStatus;//节点遍历状态
    static List<List<Integer>> edges;//记录每个节点的相邻节点
    static boolean stepAllGrids;//是否能跳完所有格子的结果判断
    public static boolean step(int N,List<List<Integer>> edges) {
        visitStatus = new int[N];     //节点默认为0 ~ N - 1
        for(int i = 0; i < N && stepAllGrids; i++) {//总是从节点0开始进入
            if(visitStatus[i] == NOT_VISITED) {
                dfs(i); } }
        return stepAllGrids; }
    public static void dfs(int node) {
        visitStatus[node] = VISITED;
        for(int neighbor : edges.get(node)) {//遍历相邻节点
            if(visitStatus[neighbor] == NOT_VISITED) {
                dfs(neighbor);
                if(!stepAllGrids) {  //如果退出循环时检测到环，直接退出
                    return; }
            }else if(visitStatus[neighbor] == VISITED){
                stepAllGrids = false;//再一次遍历到此节点，说明存在环，无法完成拓扑排序
                return; } }
        visitStatus[node] = VISIT_FINISHED; }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            int N = sc.nextInt();
            if(N < 1 || N >= 500) {
                // System.out.println("error:输入的格子个数应该大于等于1且小于500");
                System.out.println("no");
                return; }
            edges = new ArrayList<>();
            for(int i = 0; i < N; i++) {//默认节点在0 ~ N - 1之间
                edges.add(new ArrayList<>());}
            stepAllGrids = true;
            while(sc.hasNext()) {
                int a = sc.nextInt();
                if(a == -1) { //题目缺失输入退出条件，不妨设置输入-1就退出输入
                    break; }
                String line = sc.nextLine();
                String[] strs = line.split(" ");
                if(strs.length != 2) {
                    // System.out.println("error:输入的格子数组列数不为2");
                    System.out.println("no");
                    return; }
                if(a < 0 || a >= N) {
                    // System.out.println("error:输入的左侧格子号码应该大于等于0且小于" + N);
                    System.out.println("no");
                    return; }
                int b = Integer.parseInt(strs[1]);
                if(b < 0 || b >= N) {
                    // System.out.println("error:输入的右侧格子号码应该大于等于0且小于" + N);
                    System.out.println("no");
                    return; }
                edges.get(b).add(a); }
            if(step(N, edges)) {
                System.out.println("yes");
            }else {
                System.out.println("no"); } } }



}
