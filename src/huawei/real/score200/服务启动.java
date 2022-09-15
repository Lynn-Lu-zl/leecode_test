package huawei.real.score200;

import java.util.*;

/**
 * 题目描述：
 * 有若干个连续编号的服务（编号从0开始），服务间有依赖关系，启动一个指定服务，请判断该服务是否可以成功启动，并输出以来的前置服务编号（依赖关系是可以传递的，比如服务2依赖服务1，服务1依赖于服务0，那么服务2依赖于服务1和服务0）。
 *
 * 输入描述
 * 第一行输入为N，N为服务的总个数（1 <= N <= 5000）
 * 第二行输入为M，M为指定启动服务的编号（0 <= M < 5000）
 * 接下来的N行，是从编号0服务~编号N-1服务的服务依赖表，每一行第一个数字是该服务依赖的服务个数T（0 <= T < 5000）,后面T个数字分别是对应的依赖服务编号
 *
 * 输出描述
 * 为了避免不同算法的服务加载顺序不同，请从服务编号从小到大以此输出所有前置服务的编号，不包括指定启动的服务编号自身。
 *
 * 如果没有依赖的前置服务则输出null。
 *
 * 如果服务无法启动（出现循环依赖，则服务无法启动，样例2为最简单的循环依赖）或其它异常，输出-1.
 *
 * 样例1
 * 输入
 * 4
 * 2
 * 0
 * 1,0
 * 1,1
 * 2,0,1
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 输出
 * 0,1
 * 1
 * 解释：
 * 第一行，4，一共四个服务，编号0~3
 * 第二行，2，指定启动编号为2的服务
 * 第三行开始为服务依赖关系表
 * 第三行，0，表示服务0，没有依赖的前置任务，依赖个数为0
 * 第四行，1,0，表示服务1，依赖1个前置任务，编号为0
 * 第三行，1,1，表示服务2，依赖1个前置任务，编号为1
 * 第三行，2,1,0 表示服务3，依赖2个前置任务，编号为0和1
 * 分析，服务启动顺序为0，1，2，可成功启动服务2，输出0，1
 *
 * 样例2
 * 输入
 * 2
 * 1
 * 1,1
 * 1,0
 * 1
 * 2
 * 3
 * 4
 * 输出
 * -1

 */
public class 服务启动 {
    /**
     * 思路：
     * 这道题可以使用BFS广度优先搜索，从启动服务的编号出发，遍历其所有前置编号及前置编号的前置编号。并用一个set来判断是否成环。
     *
     * 也可以使用DFS，拓扑排序。
     */
    public static void main(String[] args) {

        //服务启动 服务间有依赖关系，启动一个指定服务
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();
        List<List<Integer>> graph = new ArrayList<>(N);  // 二维list存储每个服务的启动依赖
        for (int i = 0; i < N; i++) {  // 初始化
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            String[] split = in.nextLine().split(",");
            for (int j = 1; j < split.length; j++) {
                graph.get(i).add(Integer.parseInt(split[j]));
            }
        }
        Deque<Integer> queue = new LinkedList<>(); // bfs
        queue.add(M);
        Set<Integer> visited = new HashSet<>();
        visited.add(M);
        Set<Integer> ans = new HashSet<>();
        while (!queue.isEmpty()) {
            int poll = queue.pollFirst();
            visited.add(poll);  // 用来判断是否成环
            for (int next : graph.get(poll)) {
                if (visited.contains(next) && graph.get(next).contains(poll)) {
                    // 要判断，已经加入过前置编号，且该前置编号对应的前置编号是当前值，即形成循环依赖，才输出-1
                    System.out.println(-1);
                    return;
                }
                if (ans.contains(next)) {
                    continue;
                }
                ans.add(next);
                queue.add(next);
            }
        }
        Integer[] ansArr = ans.toArray(new Integer[ans.size()]);  // 集合转数组要用Integer
        Arrays.sort(ansArr);
        for (int i = 0; i < ansArr.length; i++) {  // 检查启动的服务是否在一个大环里面，即它的前置结果集里有它自己
            if (ansArr[i] == M) {
                System.out.print(-1);
                return;
            }
        }
        for (int i = 0; i < ansArr.length - 1; ++i) {
            System.out.print(ansArr[i] + ",");
        }
        if (ansArr.length == 0) {
            System.out.println("null");
        } else {
            System.out.println(ansArr[ansArr.length - 1]);
        }

    }

}
