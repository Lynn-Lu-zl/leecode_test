package huawei.real.score200;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 统计射击比赛成绩
 *
 * 给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高3个分数之和进行降序排名，输出降序排名后的选手ID序列。条件如下：
 * 1、一个选手可以有多个射击成绩的分数，且次序不固定。
 * 2、如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手。
 * 3、如果选手的成绩之和相等，则成绩之和相等的选手按照其ID降序排列。
 * 输入描述:
 * 输入第一行，一个整数N，表示该场比赛总共进行了N次射击，产生N个成绩分数（2<=N<=score100）。
 * 输入第二行，一个长度为N整数序列，表示参与每次射击的选手ID（0<=ID<=99）。
 * 输入第三行，一个长度为N整数序列，表示参与每次射击的选手对应的成绩（0<=成绩<=score100）。
 * 输出描述:
 * 符合题设条件的降序排名后的选手ID序列。
 * 示例1
 * 输入
 13
 3,3,7,4,4,4,4,7,7,3,5,5,5
 53,80,68,24,39,76,66,16,100,55,53,80,55
 * 输出
 * 5,3,7,4


 说明：
 该场射击比赛进行了13次，参赛的选手为{3,4,5,7}。
 3号选手成绩：53,80,55，最高3个成绩的和为：80+55+53=188。
 4号选手成绩：24,39,76,66，最高3个成绩的和为：76+66+39=181。
 5号选手成绩：53,80,55，最高3个成绩的和为：80+55+53=188。
 7号选手成绩：68,16,100，最高3个成绩的和为：100+68+16=184。
 比较各个选手最高3个成绩的和，有3号=5号>7号>4号，由于3号和5号成绩相等且ID号5>3，所以输出为：5,3,7,4



 三次输入分别表示比赛次数、选手id，选手成绩
 我们首先需要对输入进行整理，可以考虑使用哈希表来记录选手的成绩
 对每个选手的成绩取最高3个分数之和进行排序
 如果选手成绩长度小于3 在哈希表中删除该选手
 使用 sorted 函数进行排序，定义排序规则
 */
public class 统计射击比赛成绩 {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int count = Integer.parseInt(sc.nextLine());
    //     String[] turnList = sc.nextLine().split(",");
    //     String[] scores = sc.nextLine().split(",");
    //     List<Player> plays = new ArrayList<>();
    //     Map<Integer,Integer> map= new HashMap<>();
    //     int tempCount = 0;
    //     //获取成绩
    //     for (int i = 0; i < count; i++) {
    //         int idx = Integer.parseInt(turnList[i]);
    //         List<Integer> li = new ArrayList<>();
    //         li.add(Integer.parseInt(scores[i]));
    //         Player pls = new Player(idx,li);
    //         if (plays.contains(pls)) {
    //             plays.get(map.get(idx)).list.add(Integer.parseInt(scores[i]));
    //         }else{
    //             map.put(idx,tempCount++);
    //             plays.add(pls);
    //         }
    //     }
    //     //整理成绩
    //     for (int i = 0; i < plays.size(); i++) {
    //         Player player = plays.get(i);
    //         List<Integer> list = player.list;
    //         list.sort((a0,b0) -> b0 -a0);//逆序
    //         int total = 0;
    //         for (int j = 0; j < 3; j++) {
    //             total += list.get(j);
    //         }
    //         player.setScore(total);
    //     }
    //     plays.sort(null);
    //     for (int i = 0; i < plays.size(); i++) {
    //         if (i == plays.size() -1){
    //             System.out.print(plays.get(i).idx);
    //         }else {
    //             System.out.print(plays.get(i).idx + ",");
    //         }
    //     }
    // }
    // static class Player implements Comparable<Player>{
    //     private int idx;
    //     private List<Integer> list;
    //     private int score;
    //
    //     public void setScore(int score) {
    //         this.score = score;
    //     }
    //
    //     public Player(int idx, List<Integer> list) {
    //         this.idx = idx;
    //         this.list = list;
    //     }
    //
    //     @Override
    //     public boolean equals(Object obj) {
    //         Player ply = (Player)obj;
    //         return ply.idx == this.idx;
    //     }
    //
    //     @Override
    //     public int compareTo(Player ply) {
    //         if (ply.score != this.score){
    //             return ply.score - this.score;
    //         }else {
    //             return ply.idx - this.idx;
    //         }
    //     }
    // }

    public static void main(String[] args) {
        // 统计射击比赛成绩
        Scanner scanner = new Scanner(System.in);
        // 总射击次数
        int count =Integer.parseInt(scanner.nextLine());
        // 射击选手的ID
        List<Integer> ids = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        // 射击选手对应的成绩
        List<Integer> scores = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        HashMap<Integer, List<Integer>> id_scores = new HashMap<>();
        // 分配选手的各自的分数
        for (int i = 0; i < count; i++) {
            Integer id = ids.get(i);
            Integer score = scores.get(i);
            List<Integer> list = id_scores.getOrDefault(id, new LinkedList<>());
            list.add(score);
            id_scores.put(id, list);
        }
        StringBuilder builder = new StringBuilder();
        id_scores.entrySet()
            .stream()
            .filter(x -> x.getValue().size() >= 3)
            .sorted((o1, o2) -> {
                Integer sum1 = sum(o1.getValue());
                Integer sum2 = sum(o2.getValue());
                if (Objects.equals(sum1, sum2)) {
                    return o2.getKey() - o1.getKey();
                } else {
                    return sum2 - sum1;
                }
            })
            .map(Map.Entry::getKey)
            .forEach(x -> builder.append(x).append(","));
        System.out.println(builder.substring(0, builder.length() - 1));
    }
    private static Integer sum(List<Integer> list) {
        list.sort(Integer::compareTo);
        int sum = 0;
        for (int i = list.size() - 1; i >= list.size() - 3; i--) {
            sum += list.get(i); }
        return sum;
    }

}
