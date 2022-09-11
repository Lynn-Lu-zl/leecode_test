package huawei.real.score100;

import java.util.Scanner;

/**
 * 有一个数列a[N] (N=60)，从a[0]开始，每一项都是一个数字。数列中a[n+1]都是a[n]的描述。其中a[0]=1。
 * 规则如下：
 * a[0]:1
 * a[1]:11(含义：其前一项a[0]=1是1个1，即“11”。表示a[0]从左到右，连续出现了1次“1”）
 * a[2]:21(含义：其前一项a[1]=11，从左到右：是由两个1组成，即“21”。表示a[1]从左到右，连续出现了两次“1”)
 * a[3]:1211(含义：其前一项a[2]=21，从左到右：是由一个2和一个1组成，即“1211”。表示a[2]从左到右，连续出现了1次“2”，然后又连续出现了1次“1”)
 * a[4]:111221(含义：其前一项a[3]=1211，从左到右：是由一个1、一个2、两个1组成，即“111221”。表示a[3]从左到右，连续出现了1次“1”，连续出现了1次“2”，连续出现了两次“1”)
 * 请输出这个数列的第n项结果（a[n]，0≤n≤59）。
 * 输入描述:
 * 数列的第n项(0≤n≤59)：
 * 4
 * 输出描述:
 * 数列的内容：
 * 111221
 * 示例1
 * 输入
 * 4
 * 输出
 * 111221
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124528902
 */
public class 数列描述 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String temp = "1";
        for (int i = 1; i <= input; i++) {
            int idx = 0;
            char pre = ' ';
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < temp.length(); j++) {
                if (j == 0){
                    pre = temp.charAt(j);
                }
                char tem = temp.charAt(j);
                if (tem == pre){
                    idx++;
                }else {
                    sb.append(idx).append(pre);
                    idx = 1;
                    pre = tem;
                }
            }
            sb.append(idx).append(pre);
            temp = sb.toString();
        }
        System.out.println(temp);
    }

}
