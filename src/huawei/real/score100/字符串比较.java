package huawei.real.score100;

import java.util.Scanner;

/**
 * 标题：字符串比较 | 时间限制：1秒 | 内存限制：65536K | 语言限制：不限
 * 给定字符串A、B和正整数V，A的长度与B的长度相等， 请计算A中满足如下条件的最大连续子串的长度：
 * 1、该连续子串在A和B中的位置和长度均相同。
 * 2、该连续子串|A[i] – B[i]|之和小于等于V。其中|A[i] – B[i]|表示两个字母ASCII码之差的绝对值。
 * <p>
 * 第一行为字符串A，仅包含小写字符，1 <= A.length <=1000。
 * 第二行为字符串B，仅包含小写字符，1 <= B.length <=1000。
 * 第三行为正整数V，0<= V <= 10000。
 * 输出描述:
 * 字符串最大连续子串的长度，要求该子串|A[i] – B[i]|之和小于等于V。
 * <p>
 * 示例1
 * 输入
 * xxcdefg
 * cdefghi
 * 5
 * 输出
 * 2
 * 说明
 * 字符串A为xxcdefg，字符串B为cdefghi，V=5。
 * 它的最大连续子串可以是cd->ef,de->fg,ef->gh,fg->hi，所以最大连续子串是2。
 *
 * @since 2022年4月30日
 */
public class 字符串比较 {
    public static void main(String[] args) {

        //字符串比较,|A[i] – B[i]|之和小于等于V
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        String V = scanner.nextLine();
        char[] As = A.toCharArray();
        char[] Bs = B.toCharArray();
        int v = Integer.parseInt(V);
        int first = 0;
        int len = 0;
        int cha = 0;
        for (int i = 0;i < As.length-1; i++){
            int tempLast = 0;
            if (As[i + 1] == As[i] + 1){
                tempLast = i + 1;
            } else {
                first = i + 1;
                continue; }
            for (int j = first; j <= tempLast - 1; j++){
                if (Bs[j + 1] != Bs[j] + 1) {
                    cha = 0;
                    break; }
                if (j == first) {
                    cha += Math.abs(As[j] - Bs[j]); }
                cha += Math.abs(As[j + 1] - Bs[j + 1]);}
            int tempLen = tempLast - first + 1;
            if (cha <= v && tempLen > len){
                len = tempLen;
                cha = 0; } }
        System.out.println(len);
        


    }
}
