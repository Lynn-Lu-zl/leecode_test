package huawei.real.score100;

import java.util.Scanner;

/**
 * 第一行输入一个非负整数字符串，第二行输入一个整数n
 *
 * 输出从该字符串中取出n个字符后剩下的字符组成的最小的数（不改变字符顺序）
 *
 * 输入 ：
 * 2615371
 * 4
 * 输出：131
 */
public class 剩下的字符组成的最小的数 {


    public static void main(String[] args) {
        //输出从该字符串中取出n个字符后剩下的字符组成的最小的数（不改变字符顺序）
        //2615371+4--》out：131
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String originStr = scanner.nextLine();
            int num = Integer.parseInt(scanner.nextLine());
            String[] split = originStr.split("");
            // 全部去掉，输出空字符
            if(num >= split.length){
                System.out.println("");
            }
            StringBuilder resultSb = new StringBuilder();
            int index = 0;
            // 循环取num可去范围内的最小值
            while (num > 0 && num < split.length - index) {
                int min = Integer.MAX_VALUE;
                int range = Math.min(split.length - 1, index + num);
                for (int i = index; i <= range; i++) {
                    min = Math.min(min, Integer.parseInt(split[i]));
                }
                resultSb.append(min);
                int tempIndex = originStr.indexOf(String.valueOf(min), index);
                // 剩余num数量
                num -= tempIndex - index;
                // 下一轮开始index
                index = tempIndex + 1;
            }
            // num次数已用完，加上剩余字符串
            if (num == 0 && index < split.length) {
                resultSb.append(originStr.substring(index));
            }
            System.out.println(resultSb);
        }
    }
}

