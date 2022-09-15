package huawei.real.score100;

import java.util.*;

/**
 * 删除字符串中出现次数最少的字符，如果有多个字符出现次数一样，则都删除。
 * 输入描述:
 * 输入abcdd
 * 字符串中只包含小写英文字母。
 * 输出描述:
 * dd
 * 示例1
 * 输入
 * abcdd
 * 输出
 * dd
 * 示例2
 * 输入
 * aabbccdd
 * 输出
 * empty
 * 说明
 * 如果字符串的字符都被删除，则范围empty
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124528902
 */
public class 删除字符串中字符最少字符 {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String input = sc.nextLine();
    //     Map<String,Integer> map = new HashMap<>();
    //     for (int i = 0; i < input.length(); i++) {
    //         int orDefault = map.getOrDefault(String.valueOf(input.charAt(i)), 0);
    //         map.put(String.valueOf(input.charAt(i)),orDefault+1);
    //     }
    //     int less = Collections.min(map.values());
    //     StringBuilder res = new StringBuilder();
    //     Set<String> set = new HashSet<>();
    //     for (Map.Entry<String,Integer> mp:map.entrySet()) {
    //         int times = mp.getValue();
    //         if (times == less) {
    //             set.add(mp.getKey());
    //         }
    //     }
    //     for (int i = 0; i < input.length(); i++) {
    //         if (!set.contains(String.valueOf(input.charAt(i)))) {
    //             res.append(input.charAt(i));
    //         }
    //     }
    //     if (res.length() == 0){
    //         System.out.println("empty");
    //     }else {
    //         System.out.println(res);
    //     }
    // }


    /**
     * 法2,100%
     * @param args
     */
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);

         String line = in.nextLine();
         in.close();
         HashMap<Character, Long> map = new HashMap<>();
         for (char c : line.toCharArray()) {
             map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1L);
         }

         Long[] counts = new Long[map.values().size()];
         Long[] longs = map.values().toArray(counts);
         Arrays.sort(longs);
         Long min = longs[0];
         for (Map.Entry<Character, Long> entry : map.entrySet()) {
             if (entry.getValue().equals(min)) {
                 line = line.replaceAll(entry.getKey() + "", "");
             }
         }

         System.out.println(line.length() == 0 ? "empty" : line);
         }

}
