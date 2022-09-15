package huawei.real.score100;

import java.util.*;

/**
 * 题目描述：
 * 网上新闻越来越多，希望对新闻进行热词处理并归类，方便获取信息，现在已经将每篇文章处理为2个字符串，即一个标题，一个正文串，字符串中使用“ ”作为分隔符进行分词。
 *
 * M篇新闻按照新闻发布的先后顺序处理完并输入，现在希望对所有新闻中出现的词语进行处理，输出出现频率最高的topN个词语，作为热词。标题中出现的词语频率系数为3，正文中出现的词语频率系数为1；返回的答案按照词语出现频率由高到低排序，当词语出现的频率相同时，在标题中出现的频率次数高的排在前面；如果仍然相同，则按照词语在标题中出现的先后顺序进行排序，先出现的排在前面；如果仍然相同，则按照词语在正文中出现的先后顺序进行排序，先出现的排在前面。
 *
 * 输入描述
 * 第一行输入为正整数topN和文章数M，即要输出的出现频率最高的词语的个数和处理文章的数量，由于每篇文章被处理为标题和正文2行，因此后面有2 * M行数据。
 *
 * 从第二行起，是按顺序处理后每篇文章的标题串和正文串，即第二行是第一篇文章的标题串，第三行是第一篇文章的正文串，第四行是第二篇文章的标题串，第五行是第二篇文章的正文串，以此类推。
 *
 * 参数限制如下：
 * 0 < topN < 1000
 * 0 < M < 100000
 * 0 < 每篇文章的词语数 < 5000
 *
 * 输出描述
 * 使用一行输出出现频率最高的topN个词语，每个词语以“ ”隔开。
 *
 * 示例一：
 * 输入
 3 2
 xinguan feiyan xinzeng bendi quezhen anli
 ju baodao chengdu xinzeng xinguan feiyan bendi quezhen anli yili shenzhen xinzeng bendi quezhen anli liangli yiqing zhhengti kongzhi lianghao
 xinguan yimiao linchuang shiyan
 wuzhong xinguan yimiao tongguo sanqi linchuang shiyan xiaoguo lianghao

 * 输出
 xinguan xinzeng bendi


 * 解释：
 * 各词语出现频率：
 *
 xinguan=2*3+2=8
 feiyan=1*3+1=4
 xinzeng=1*3+2=5
 bendi=1*3+2=5
 quezhen=1*3+2=5
 anli=1*3+2=5
 yimiao=1*3+1=4
 linchuang=1*3+1=4
 shiyan=1*3+1=4

 * 返回频率最高的三个词语，有4个词语出现频率都为5，标题出现频率都为3，所以选择先出现的两个词语xinzeng和bendi

 */
public class 查找舆情热词 {
    /**
     * 这道题考察的是多关键字排序，在Java中使用treeMap对关键字进行排序。关键字用数组进行存储。
     */
    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     int topN = in.nextInt();
    //     int M = in.nextInt();
    //     in.nextLine();
    //     Map<String, int[]> map = new HashMap<>();
    //     int titleIdx = 0;
    //     int textIdx = 0;
    //     // 处理标题和正文的单词，map的key是单词，value是长度为4的一维数组
    //     for (int i = 0; i < M; i++) {
    //         // 处理标题的单词
    //         String[] title = in.nextLine().split(" ");
    //         for (int j = 0; j < title.length; j++) {
    //             if (!map.containsKey(title[j])) {
    //                 map.put(title[j], new int[]{0, 0, titleIdx, -1});  // 第一个是单词出现频次，第二个是标题中出现频次，第三个是标题中的顺序，第四个是正文中的顺序
    //             }
    //             int[] info = map.get(title[j]);
    //             if (info[2] == -1) {
    //                 info[2] = titleIdx;
    //             }
    //             info[0] += 3;
    //             info[1]++;
    //             titleIdx++;
    //         }
    //         // 处理正文的单词
    //         String[] text = in.nextLine().split(" ");
    //         for (int j = 0; j < text.length; j++) {
    //             if (!map.containsKey(text[j])) {
    //                 map.put(text[j], new int[]{0, 0, -1, textIdx});  // 第一个是单词出现频次，第二个是标题中出现频次，第三个是标题中的顺序，第四个是正文中的顺序
    //             }
    //             int[] info = map.get(text[j]);
    //             if (info[3] == -1) {
    //                 info[3] = textIdx;
    //             }
    //             info[0]++;
    //             textIdx++;
    //         }
    //     }
    //     // 使用treeMap对value进行排序，实现多关键字排序
    //     TreeMap<int[], String> treeMap = new TreeMap<>((o1, o2) -> {
    //         int re = Integer.compare(o1[0], o2[0]);  // 单词出现的频率
    //         if (re != 0) {  // 频率不相等
    //             return -re;  // 降序排
    //         }
    //         re = Integer.compare(o1[1], o2[1]);  // 单词出现的频率相等，比较在标题中出现的频率
    //         if (re != 0) {  // 频率不相等
    //             return -re;  // 降序排
    //         }
    //         re = Integer.compare(o1[2], o2[2]);  // 单词出现的频率相等,在标题中出现的频率相等，比较在标题中的先后顺序
    //         if (re != 0) {  // 不相等
    //             return re;  // 按顺序
    //         }
    //         re = Integer.compare(o1[3], o2[3]);  // 单词出现的频率相等,在标题中出现的频率相等，在标题中的先后顺序相等，比较在正文的先后顺序
    //         if (re != 0) {  // 不相等
    //             return re;  // 按顺序
    //         }
    //         return 0;
    //     });
    //     for (Map.Entry<String, int[]> entry: map.entrySet()) {
    //         treeMap.put(entry.getValue(), entry.getKey());
    //     }
    //     int count = 0;
    //     StringBuilder sb = new StringBuilder();
    //     for (String word : treeMap.values()) {
    //         if (count < topN ) {
    //             sb.append(word + " ");
    //         }
    //         count++;
    //     }
    //     System.out.print(sb.toString().trim());
    // }

    /**
     * 直接使用HashMap进行value排序
     * @param args
     */
    public static void main(String[] args) {
        //查找舆情热词，网上新闻越来越多，希望对新闻进行热词处理并归类
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        in.nextLine();
        Map<String, int[]> map = new HashMap<>();
        int titleIdx = 0, textIdx = 0;
        for (int i = 0; i < N; i++) {
            String[] title = in.nextLine().split(" ");
            for (int j = 0; j < title.length; j++) {
                if (!map.containsKey(title[j])) {
                    // 第一个是单词出现频次，第二个是标题中出现频次，第三个是标题中的顺序，第四个是正文中的顺序
                    map.put(title[j], new int[]{0, 0, titleIdx, -1}); }
                int[] info = map.get(title[j]);
                if (info[2] == -1) {
                    info[2] = titleIdx; }
                info[0] += 3;
                info[1]++;
                titleIdx++; }
            String[] text = in.nextLine().split(" ");
            for (int j = 0; j < text.length; j++) {
                if (!map.containsKey(text[j])) {
                    // 第一个是单词出现频次，第二个是标题中出现频次，第三个是标题中的顺序，第四个是正文中的顺序
                    map.put(text[j], new int[]{0, 0, -1, textIdx}); }
                int[] info = map.get(text[j]);
                if (info[3] == -1) {
                    info[3] = textIdx; }
                info[0]++;
                textIdx++; } }
        // Map按value排序，先将map转为list,再排序list(按value值进行排序)
        List<Map.Entry<String, int[]>> list = new ArrayList<>(map.entrySet());
        // 直接使用lambda表达式排序
        list.sort((o1, o2) -> (o1.getValue()[0] == o2.getValue()[0] ? (o1.getValue()[1] == o2.getValue()[1] ?
            (o1.getValue()[2] == o2.getValue()[2] ? (o1.getValue()[3] - o2.getValue()[3])
                : o1.getValue()[2] - o2.getValue()[2])
            : o2.getValue()[1] - o1.getValue()[1])
            : (o2.getValue()[0] - o1.getValue()[0])));
        for (int i = 0; i < M; i++) {// 输出前M个高频词汇
            Map.Entry<String, int[]> entry = list.get(i);
            if (i != list.size() - 1) {
                System.out.print(entry.getKey() + " ");
            } else {
                System.out.println(entry.getKey()); } }


    }

}
