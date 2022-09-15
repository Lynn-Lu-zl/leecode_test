package huawei.real.score100;

import java.util.Scanner;

/**
 * 中秋节公司分月饼，m个员工，买了n个月饼，m<=n，每个员工至少分1个月饼，但可以分多个，单人份到最多月饼的个数为Max1，单人分到第二多月饼的个数是Max2，Max1-Max2<=3。单人分到第n-1多月饼的个数是Max(n-1)，单人分到第n多月饼的个数是Max(n)，Max(n-1)-Max(n)<=3。问有多少种分月饼的方法？
 * 输入描述：
 * 每一行输入m n,表示m个员工，n个月饼，m<=n
 * 输出描述：
 * 输出有多少种月饼分法
 * 示例：
 * 输入
 * 2 4
 * 输出
 * 2
 * ————————————————
 * 版权声明：本文为CSDN博主「国林哥」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_42886699/article/details/121324989
 *
 * 思路总结如下：
 * 1. m个人有n个月饼，先将m个人每个人分一个，剩余总月饼数为n-m=p；
 * 2. 假设第一个人最少分k个，第二个人范围就是[k, k+3]，Max(n-1)-Max(n)<=3。
 * 3. 当m为3个人时情况如下：
 * 4. 我们假设第一个人总是分到最少的，第二个人分到第二少的，依次类推；
 * 第一个人最少分0个（n-m后的p，就是给每位各分了一个后剩余的月饼数），剩下两个人有n-3（p）个月饼可分，此时，如果第二个人分k个，第三个人就是n-3-k（p-k）个，满足k<=p-k <= k+3(第三个人比第二个人的只多0-3个)；
 * 5. 依次循环类推，如果第一个人分1个，剩下两个人分n-3-1个，循环逻辑一致；
 * 6.同理，如果是四个人时，分为第一个人和后三个人，后三个人又分为第一个人和后两个人，第一个人总是分最少的，第二个比他多0-3个，依次类推，我们发现这是一个递归调用过程。代码需要有一个递归函数distribute，给他下一个数量，并让他完成递归判断。当然对于两个人的情况，我们单独判断即可。
 * ————————————————
 * 版权声明：本文为CSDN博主「国林哥」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_42886699/article/details/121324989
 */
public class 分月饼 {
    public static void main(String[] args) {
        //分月饼
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int p =n-m;
        int count=0;

        if (m > n) {System.out.println(0);return ;}

        int i=0;
        for(i=0;i<=p/m;i++)
        {
            count=count+distribute(m-1,p-i,i);
        }
        System.out.println(count);
    }
    public static int  distribute(int m ,int p, int k) {
        if (p <= 0) return 0;
        if (m <= 0) return 0;

        if (m == 1) {
            if (p >= k && p <= k + 3) {
                return 1;
            }
            return 0;
        }
        int ncount=0;
        for (int i = k; i <= k+3; i++) {
            ncount=ncount+distribute(m-1,p-i,i);
        }
        return ncount;
    }

}
