package huawei.real.score100;


import java.util.Scanner;

/**
 * 【补种未成活胡杨】
 *
 * 近些年来，我国防沙治沙取得显著成果。某沙漠新种植N棵胡杨（编号1-N），排成一排。
 *
 * 一个月后，有M棵胡杨未能成活。
 *
 * 现可补种胡杨K棵，请问如何补种（只能补种，不能新种），可以得到最多的连续胡杨树？
 *
 * 输入描述
 *
 * N 总种植数量
 *
 * M 未成活胡杨数量
 *
 * M 个空格分隔的数，按编号从小到大排列
 *
 * K 最多可以补种的数量
 *
 * 其中：
 *
 * 1 <= N <= 100000
 *
 * 1 <= M <= N
 *
 * 0 <= K <= M
 *
 * 输出描述
 *
 * 最多的连续胡杨棵树
 *
 * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 5
 2
 2 4
 1
 *
 * 输出
 *
 * 3
 *
 * 说明
 *
 * 补种到2或4结果一样，最多的连续胡杨棵树都是3。
 */
public class 补种未成活胡杨 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());

        String[] Ms = scanner.nextLine().split(" ");
        int[] ints = new int[M];
        for (int i = 0; i < Ms.length; i++) {
            ints[i] = Integer.parseInt(Ms[i]);
        }

        int K = Integer.parseInt(scanner.nextLine());

        // 开始补种 滑动窗口，首先知道补种也必须是连续的才有可能获得最大连续棵树，然后设定左右指针，保证中间有K棵树补种
        int max = 0;
        for (int i = 0; i <= ints.length - K; i++) {
            int le = 0;
            int ri = N;
            if (i > 0) {
                le = ints[i - 1];
            }

            if (i + K < ints.length) {
                ri = ints[i + K] - 1;
            }

            int temp = ri - le;
            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);
    }
}
