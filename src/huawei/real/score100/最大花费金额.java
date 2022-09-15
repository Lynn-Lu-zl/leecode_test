package huawei.real.score100;

import java.util.Scanner;

/**
 * 双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，所以他决定从众多心仪商品中购买三件，而且想尽可能的花完资金，现在请你设计一个程序帮助小明计算尽可能花费的最大资金数额。
 * 输入描述:
 * 输入第一行为一维整型数组M，数组长度小于100，数组元素记录单个商品的价格，单个商品价格小于1000。
 * 输入第二行为购买资金的额度R，R小于100000。
 * 输出描述:
 * 输出为满足上述条件的最大花费额度。
 * 注意：如果不存在满足上述条件的商品，请返回-1。
 * 示例1
 * 输入
 * 23,26,36,27
 * 78
 * 输出
 * 76
 * 说明
 * 金额23、26和27相加得到76，而且最接近且小于输入金额78
 * 示例2
 * 输入
 * 23,30,40
 * 26
 * 输出
 * -1
 * 说明
 * 因为输入的商品，无法组合出来满足三件之和小于26.故返回-1
 * 备注:
 * 输入格式是正确的，无需考虑格式错误的情况。
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124579505
 */
public class 最大花费金额 {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String[] split = sc.nextLine().split(",");
    //     int max = Integer.parseInt(sc.nextLine());
    //     int[] arr = new int[split.length];
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = Integer.parseInt(split[i]);
    //     }
    //     int total = -1;
    //     for (int i = 0; i < split.length; i++) {
    //         for (int j = i+1; j < split.length; j++) {
    //             for (int k = j+1; k < split.length; k++) {
    //                 int tem = arr[i] + arr[j] + arr[k];
    //                 if (tem <= max){
    //                     total = Math.max(tem,total);
    //                 }
    //             }
    //         }
    //     }
    //     System.out.println(total);
    // }


     public static void main(String[] args) {

         //最大花费金额，双十一众多商品进行打折销售
         Scanner sc = new Scanner(System.in);
         String line1 = sc.nextLine();
         String line2 = sc.nextLine();
         String[] split = line1.split(",");
         int len = split.length;
         int sum = 0;
         // 依次遍历，列出所有的三数之和
         for (int i = 0; i < len - 2; i++) {
             for (int j = i + 1; j < len - 1; j++) {
                 for (int k = j + 1; k < len; k++) {
                     int res = Integer.parseInt(split[i])
                         + Integer.parseInt(split[j])
                         + Integer.parseInt(split[k]);
                     if (res < Integer.parseInt(line2)) {
                         // 与原来的值比较，留下大的值
                         sum = Math.max(sum, res); } } } }
         if (sum == 0) {
             System.out.println(-1);
         } else {
             System.out.println(sum); }


         }

}
