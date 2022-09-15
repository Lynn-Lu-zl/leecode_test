package huawei.real.score100;

import java.util.*;

/**满足最低能力值的数量
 * 数组+二分
 用数组代表每个人的能力
 一个比赛活动要求 参赛团队的最低能力值为N
 每个团队可以由一人或者两人组成
 且一个人只能参加一个团队
 计算出最多可以派出多少只符合要求的队伍

 输入描述
 5
 3 1 5 7 9
 8
 第一行代表总人数，范围  1~500000
 第二行数组代表每个人的能力
 数组大小范围 1~500000
 元素取值范围 1~500000
 第三行数值为团队要求的最低能力值
 1~500000

 输出描述
 3
 最多可以派出的团队数量

 示例一
 输入
 5
 3 1 5 7 9
 8

 输出
 3

 说明 3、5组成一队   1、7一队  9自己一队  输出3

 7
 3 1 5 7 9 2 6
 8
 输出
 4

 3
 1 1 9
 8
 输出
 1
 ————————————————
 版权声明：本文为CSDN博主「chenzm666666」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/m0_46084322/article/details/125616670
 */
public class 最多团队 {
     public static void main(String[] args) {
         // Scanner in = new Scanner(System.in);
         // int n = in.nextInt();
         // int[] nums = new int[n];
         // for (int i = 0; i < n; i++) {
         //     nums[i] = in.nextInt();
         // }
         // // 对数组进行排序
         // Arrays.sort(nums);
         // int value = in.nextInt();
         // int count = 0;
         // // 先统计大于等于value的数值个数
         // for (int num : nums) {
         //     if (num >= value) {
         //         count++;
         //     }
         // }
         // // 再统计剩余部分和大于等于value的数量
         // int left = 0, right = n - count - 1;
         // while (left < right) {
         //     if (nums[left] + nums[right] >= value) {
         //         count++;
         //         left++;
         //         right--;
         //     } else {
         //         left++;
         //     }
         // }
         // System.out.println(count);



         // 解题思路：遍历输入的数组，记录大于N的值的数量，将小于N的放进集合里，对集合进行排序，采用双指针，筛选大于N的组合

         //最多团队，一个比赛活动要求 参赛团队的最低能力值为N
         Scanner sc = new Scanner(System.in);
         int len = Integer.parseInt(sc.nextLine());
         String[] split = sc.nextLine().split(" ");
         int requireValue = Integer.parseInt(sc.nextLine());
         List<Integer> list = new ArrayList<>();
         // 大于N的值的数量
         int count = 0;
         for (int i = 0; i < len; i++) {
             int num = Integer.parseInt(split[i]);
             if (num >= requireValue) {
                 count++;
             } else {
                 list.add(num); } }
         Collections.sort(list);
         // 双指针
         // 头指针：集合头
         int start = 0;
         // 尾指针：数组尾
         int end = list.size() - 1;
         while (start < end) {
         // 当头尾指针之和满足要求，count++，头指针向前移动一步，尾指针向后移动一步
             if (list.get(start) + list.get(end) >= requireValue) {
                 count++;
                 start++;
                 end--;
             } else { // 当头尾指针之和不满足要求，头指针向前移动一步，尾指针不变
                 start++; } }
         System.out.println(count);


     }
}
