package huawei.real.score100;

import java.util.*;


/** 输出连续出现次数第k多的字母的次数
 * 给定一个字符串，只包含大写字母，求在包含同一字母的子串中，长度第 k 长的子串的长度，相同字母只取最长的那个子串。
 * 输入描述:
 * 第一行有一个子串(1<长度<=100)，只包含大写字母。
 * 第二行为 k的值
 * 输出描述:
 * 输出连续出现次数第k多的字母的次数。
 * 示例1
 * 输入
 * AAAAHHHBBCDHHHH
 * 3
 * 输出
 * 2
 * 说明
 * 同一字母连续出现的最多的是A和H，四次；第二多的是H，3次，但是H已经存在4个连续的，故不考虑；下个最长子串是BB，所以最终答案应该输出2。
 * 示例2
 * 输入
 * AABAAA
 * 2
 * 输出
 * 1
 * 说明
 * 同一字母连续出现的最多的是A，三次；第二多的还是A，两次，但A已经存在最大连续次数三次，故不考虑；下个最长子串是B，所以输出1
 * 示例3
 * 输入
 * ABC
 * 4
 * 输出
 * -1
 * 说明
 * 只含有3个包含同一字母的子串，小于k，输出-1
 * 示例4
 * 输入
 * ABC
 * 2
 * 输出
 * 1
 * 说明
 * 三个子串长度均为1，所以此时k = 1，k=2，k=3这三种情况均输出1。特此说明，避免歧义。
 * 备注:
 * 若子串中只包含同一字母的子串数小于k，则输出-1
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124516351
 */
public class 连续字母长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int k1 = Integer.parseInt(sc.nextLine());
        int[] arr = new int[26];
        int temp = 0;
        char pre = ' ';
        for (int i = 0; i < input.length(); i++) {
            if (i == 0){
                temp++;
                pre = input.charAt(i);
            }else if (input.charAt(i) == pre){
                temp++;
                int count = arr[pre - 'A'];
                arr[pre - 'A'] = Math.max(temp, count);
            }else {//换代
                temp = 1;
                pre = input.charAt(i);
                arr[input.charAt(i) - 'A'] = Math.max(temp, arr[input.charAt(i) - 'A'] );
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                list.add(arr[i]);
            }
        }
        list.sort((a1,b1) -> b1 - a1);
        if (list.size()<k1){
            System.out.println(-1);
        }else {
            System.out.println(list.get(k1-1));
        }
    }


    /**
     * 法2
     */
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String line = sc.nextLine();
    //     int num = sc.nextInt();
    //     char[] chars = line.toCharArray();
    //     Map<Character, Integer> map = new HashMap<>();
    //     int count = 1;
    //     for (int i = 0; i < chars.length; i++) {
    //         char c = chars[i];
    //         while (i + 1 < chars.length && c == chars[i + 1]) {
    //             count++;
    //             i++;
    //         }
    //         if (map.containsKey(c)) {
    //             if (count > map.get(c)) {
    //                 map.put(c, count);
    //             }
    //         } else {
    //             map.put(c, count);
    //         }
    //         count = 1;
    //     }
    //     if (map.size() < num) {
    //         System.out.println(-1);
    //         return;
    //     }
    //     Object[] array = map.values().toArray();
    //     Arrays.sort(array, (a1, a2)->{
    //         return (Integer)a2 - (Integer) a1;
    //     });
    //
    //     System.out.println(array[num - 1]);
    //
    // }
}
