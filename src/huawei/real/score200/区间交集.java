package huawei.real.score200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 【区间交集】
 *
 * 给定一组闭区间，其中部分区间存在交集。
 *
 * 任意两个给定区间的交集，称为公共区间(如:[1,2],[2,3]的公共区间为[2,2]，[3,5],[3,6]的公共区间为[3,5])。
 *
 * 公共区间之间若存在交集，则需要合并(如:[1,3],[3,5]区间存在交集[3,3]，需合并为[1,5])。
 *
 * 按升序排列输出合并后的区间列表。
 *
 * 输入描述
 * 一组区间列表，区间数为 N: 0<=N<=1000;区间元素为 X: -10000<=X<=10000。
 *
 * 输出描述
 * 升序排列的合并区间列表
 *
 * 备注
 * 1、区间元素均为数字，不考虑字母、符号等异常输入。
 *
 * 2、单个区间认定为无公共区间。
 *
 * 示例：
 * 输入
 * 1 3 2 4 4 8 5 9
 * 1
 * 输出
 * 2 3 4 4 5 8
 * 1
 * 说明
 * [1,3]、[2,4]、[4,8]、[5,9] 四个区间
 * [1,3]与[2,4]交集为[2,3]，[1,3]与[4,8]、[5,9]没有交集
 * [2,4]与[4,8]]交集为[4,4]。[2,4]与[5,9]没有交集
 * [4,8]与[5,9]的交集为[5,8]
 * 所以最终的输出为[2,3]、[4,4]、[5,8]
 * 1
 * 2
 * 3
 * 4
 * 5
 * 输入
 * 1 6 2 5 5 7
 * 1
 * 输出
 * 2 6
 * 1
 * 说明
 * [1,6]、[2,5]的交集为[2,5]，[1,6]、[5,7]的交集为[5,6]
 * [2,5]、[5,7]的交集为[5,5]
 * 最后的输出为：2 6
 * ————————————————
 * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/125833252
 */
public class 区间交集 {

    /**
     * 这道题目的要求简单的说就是当各个区间有交集的时候取交集，再求交集的并集。
     *
     * 求区间交集，双指针方法，可以参考leetcode：986. 区间列表的交集
     * 求区间并集，升序然后判断重叠，可以参考leetcode：56. 合并区间
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // 先计算交集
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            for (int j = i + 2; j < arr.length; j += 2) {
                int left = Math.max(arr[i], arr[j]);
                int right = Math.min(arr[i + 1], arr[j + 1]);
                if (left <= right) {
                    res.add(new int[]{left, right});
                }
            }
        }
        // 计算完交集，按从小到大排序，左边界升序，相同，有边界升序
        int[][] ans = res.toArray(new int[res.size()][]);
        Arrays.sort(ans, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        // 求交集的并集
        int[][] result = new int[ans.length][2];
        int index = -1;
        for (int[] an : ans) {
            if (index == -1 || an[0] > result[index][1]) {
                result[++index] = an;
            } else {
                result[index][1] = Math.max(result[index][1], an[1]);
            }
        }
        int[][] last = Arrays.copyOf(result, index + 1);
        for (int i = 0; i < last.length; i++) {
            System.out.print(last[i][0]);
            System.out.print(" ");
            System.out.print(last[i][1]);
            if (i != last.length - 1) {
                System.out.print(" ");
            }
        }
    }

}
