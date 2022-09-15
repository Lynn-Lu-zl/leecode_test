package huawei.real.score100;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*** 有人考过  统计字符串中各个子字母出现的次数
 * 给出一个仅包含字母的字符串，不包含空格，统计字符串中各个字母（区分大小写）出现的次数，并按照字母出现次数从大到小的顺序输出各个字母及其出现次数。如果次数相同，按照自然顺序进行排序，且小写字母在大写字母之前。
 * 输入描述:
 * 输入一行，为一个仅包含字母的字符串。
 * 输出描述:
 * 按照字母出现次数从大到小的顺序输出各个字母和字母次数，用英文分号分隔，注意末尾的分号；字母和次数间用英文冒号分隔。
 * 示例1
 * 输入
 * xyxyXX
 * 输出
 * x:2;y:2;X:2;
 * 说明
 * 每个字符出现的个数都是2，故x排在y之前，而小写字母x在X之前
 * 示例2
 * 输入
 * abababb
 * 输出
 * b:4;a:3;
 * 说明
 * b的出现个数比a多，故b排在a之前
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124579505
 */
public class 字符统计及重排 {
    //字符统计及重排 x:2;y:2;X:2;
    public static void main(String[] args) {
        List<Word> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character,Integer> map = new HashMap<>();//存
        int idx = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            Word word = new Word(1,ch);
            if (map.containsKey(ch)) {
                int index = map.get(ch);
                list.get(index).count++;
            }else {
                map.put(ch,idx++);
                list.add(word); } }
        Collections.sort(list);//取
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Word word = list.get(i);
            sb.append(word.ch).append(":").append(word.count).append(",");}
        sb.deleteCharAt(sb.length() -1).append(";");
        System.out.println(sb); }
    private static class Word implements Comparable<Word>{
        private int count;
        private char ch;
        public Word(int count, Character ch) {
            this.count = count;
            this.ch = ch; }
        @Override
        public int compareTo(Word wo) {
            char o1 = wo.ch;
            char o2 = this.ch;
            if (wo.count!= this.count)
                {return wo.count - this.count; }
            if ((o1 >= 'a' && o2>= 'a') || (o1 <= 'Z' && o2<= 'Z')){
                return o2 - o1;//相同时正序排
            }else {//逆序排
                return o1 - o2; } }
        @Override
        public boolean equals(Object obj) {
            Word wo = (Word) obj;
            return this.ch == wo.ch; }}


    /**
     * 法2 85%
     */
    // public static void main(String[] args) {
    //
    //     Scanner in = new Scanner(System.in);
    //     String str = in.nextLine();
    //     in.close();
    //
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     for (char c : str.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
    //
    //     print(map.entrySet().stream().filter(e -> e.getKey() >= 'a'));
    //     print(map.entrySet().stream().filter(e -> e.getKey() <= 'Z'));
    //
    // }
    //
    // private static void print(Stream<Map.Entry<Character, Integer>> stream) {
    //     List<Map.Entry<Character, Integer>> list = stream
    //         .sorted((o1, o2) -> {
    //             int v1 = o1.getValue();
    //             char k1 = o1.getKey();
    //             int v2 = o2.getValue();
    //             char k2 = o2.getKey();
    //             if (v1 != v2) {
    //                 return v2 - v1;
    //             } else {
    //                 return k1 - k2;
    //             }
    //         }).collect(Collectors.toList());
    //
    //     StringBuilder builder = new StringBuilder();
    //     for (Map.Entry<Character, Integer> entry : list) {
    //         builder.append(entry.getKey()).append(":")
    //             .append(entry.getValue()).append(";");
    //     }
    //
    //     System.out.print(builder);
    // }




}
