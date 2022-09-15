package huawei.real.score100;

import java.util.Scanner;

/**https://f.daixianiu.cn/csdn/8683172138435706.html
 * 给出一个数组nums，你需要通过交换位置，将数组中 任何位置 上的 小于 k 的整数 组合到一起，并返回所有可能中所需最少的交换次数。
 * 输出将数组A中小于k的整数组合到一起的最小交换次数。
 * 组合在一起是指满足条件的数字相邻，不要求在数组中的位置相邻
 *

 *
 * 整数数组nums，整数k。输出将数组A中小于k的整数组合到一起的最小交换次数。组合在一起是指满足条件的数字相邻，不要求相邻后在数组中的位置。(100分)
 * 样例1:
 * nums=[1,3,1,4,0], k=2
 * 输出：1 ，解析：交换第一个1和4
 * 样例2:
 * nums=[0，0，0，1，0], k=2
 * 输出：0，解析：已经满足条件
 * 样例3:
 * nums=[2,3,2], k=1
 * 输出：0,解析：不存在小于k的数，无需交换，小于2的表达式是1 1 0, 共三种可能将所有符合要求数字组合一起，最少交换1次
 *
 *
 1、计算出数组中满足条件的数字个数

 2、以步骤1求出的数字长度作为区间长度，遍历数组在这些区间内不满足条件的个数，此值为此区间内的交换次数，其中最小值则为最少交换次数。

 注意边界值。

 如例一

 输入

 1 3 1 4 0

 2

 131中不满足条件的只有一个3，3 1 4 不满足条件的有两个3、4，140中不满足的只有一个4，其中最小值为1，则输出1。

 */
public class 最少交换次数 {
    public static void main(String[] args) {

        //最少交换次数，将数组中 任何位置 上的 小于 k 的整数 组合到一起
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = sc.nextInt();
        int len = str.length;
        int[] ints = new int[len];  //数字数组
        int cnt = 0;    //满足条件的数字个数
        for(int i=0;i<len;i++){
            ints[i] = Integer.valueOf(str[i]);
            if (ints[i] < n) {
                cnt++;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<len-cnt+1; i++){
            int count = 0;
            for(int j=0; j<cnt; j++){
                if(ints[i+j]>=n){
                    count++;
                }
            }
            res = Math.min(res, count);
        }
        System.out.println(res);
    }

}
