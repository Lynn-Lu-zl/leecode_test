package huawei.real.score200;

import java.util.*;

/**
 * 题目内容：
 * 小杨申请了一个保密柜，但是他忘记了密码。只记得密码都是数字，而且所有数字都是不重复的。请你根据他记住的数字范围和密码的最小数字数量，帮他算下有哪些可能的组合，
 * 规则如下：
 * 1、输出的组合都是从可选的数字范围中选取的，且不能重复；
 * 2、输出的密码数字要按照从小到大的顺序排列，密码组合需要按照字母顺序，从小到大的顺序排序。
 * 3、输出的每一个组合的数字的数量要大于等于密码最小数字数量；
 * 4、如果可能的组合为空，则返回“None…"
 * 输入要求：
 * 1、输入的第一行是可能的密码数字列表，数字间以半角逗号分隔
 * 2、输入的第二行是密码最小数字数量
 * 输出要求：
 * 1、可能的密码组合，每种组合显示成一行，每个组合内部的数字以半角逗号分隔，从小到大的顺序排列。
 * 2、输出的组合间需要按照字典序排序。
 * 3、2,3,4放到2,4的前面

 示例
 输入
 2,3,4
 2

 输出
 2,3
 2,3,4
 2,4
 3,4

 示例
 输入 2,0
 1
 输出
 0
 0,2
 2
 */
public class 猜密码 {

    public static void main(String[] args) {
        //猜密码，小杨申请了一个保密柜，但是他忘记了密码
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int minNum = Integer.parseInt(scanner.nextLine());
            String[] split = s.split(",");
            List<Integer> integers = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < split.length; i++) {
                int value = Integer.parseInt(split[i]);
                if (set.add(value)) {
                    integers.add(value); } }
            integers.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });

            minNum = Math.max(minNum, 1);
            StringBuilder sb = new StringBuilder();
            for (int i = minNum; i <= integers.size(); i++) {
                getPassword(i, integers, 0, sb); } } }
    private static void getPassword(int minNum, List<Integer> integers, int startIndex, StringBuilder sb) {
        if (sb.length() >= minNum) {

            System.out.println(sb);
            return;
        }
        if (startIndex > integers.size() - 1) {
            return;
        }
        for (int i = startIndex; i < integers.size(); i++) {
            int originLength = sb.length();
            sb.append(integers.get(i));
            getPassword(minNum, integers, i + 1, sb);
            sb.setLength(originLength); } }
}
