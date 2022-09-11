package huawei.real.score200;

import java.util.Scanner;

/**
 * 连续出牌数量【2022 Q1,Q2考试题】
 *
 * 题目描述
 * 手里给一副手牌，数字从0-9，有r(红色),，g(绿色），b(蓝色)，y(黄色)四种颜色，出牌规则为每次打出的牌必须跟上一张的数字或者颜色相同，否则不能抽选。
 * 选手应该怎么选才能使得抽选的次数最大，并且输出这个最大次数。
 * 输入描述
 * 第一行 牌的数值n (1<=n<=9)
 * 第二行 牌的颜色（r,g,b,y四种颜色表示)
 * 输出描述
 * 输出最大出牌数量
 * 示例
 * 输入
 * 1 4 3 4 5
 * r y b b r
 * 1
 * 2
 * 输出
 * 3
 * 1
 * 说明
 * 如果打（1, r）-> (5, r)，那么能打两张。
 *
 * 如果打（4，y) -> (4, b) -> (3, b)，那么能打三张。
 *
 * 思路分析
 * 这道题可以考虑DFS
 * ————————————————
 * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/125824964
 */
public class 连续出牌数量 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str1 = in.nextLine().split(" ");
        String[] str2 = in.nextLine().split(" ");
        int n = str1.length;
        int[] used = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(str1, str2, i, used, 1));
        }
        System.out.println(ans);
    }
    public static int dfs(String[] str1, String[] str2, int i, int[] used, int ans){
        if(used[i] == 1 || i >= str1.length){
            return ans - 1;
        }
        int res = ans;
        used[i] = 1;
        for (int j = 0; j < str1.length; j++) {
            if(i != j && used[j] == 0){
                if(str1[i].equals(str1[j]) || str2[i].equals(str2[j])){
                    int t = dfs(str1, str2, j, used, ans + 1);
                    res = Math.max(res, t);
                }
            }
        }
        used[i] = 0;
        return res;
    }

}
