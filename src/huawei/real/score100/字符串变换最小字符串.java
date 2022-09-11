package huawei.real.score100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。
 * 变换规则：交换字符串中任意两个不同位置的字符。
 * 输入描述:
 * 一串小写字母组成的字符串s
 * 输出描述:
 * 按照要求进行变换得到的最小字符串
 * 示例1
 * 输入
 * abcdef
 * 输出
 * abcdef
 * 说明
 * abcdef已经是最小字符串，不需要交换
 * 示例2
 * 输入
 * bcdefa
 * bacdefa
 * 输出
 * acdefb
 * aacdefb[abcdefa排序更大]
 * 说明
 * a和b进行位置交换，可以等到最小字符串
 * 备注:
 * s是都是小写字符组成
 * 1<=s.length<=1000
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124558394
 */
public class 字符串变换最小字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);//最优解
        String str = input;
        for (int i = 0; i < input.length(); i++) {
            if (chars[i] == input.charAt(i)) {
                continue;
            }else {
                char aChar = chars[i];
                int i1 = input.lastIndexOf(String.valueOf(aChar));
                //i1 和i对调顺序即可
                str = input.substring(0,i) + aChar + input.substring(i+1,i1) + input.charAt(i) + input.substring(i1+1);
                break;
            }
        }
        System.out.println(str);
    }

}
