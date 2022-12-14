package huawei.real.score100;

import java.util.Scanner;

/**
 * 最长连续子串/最长连续子序列的和等于输入值  数组
 有N个正整数组成的一个序列。给定整数sum，求长度最长的连续子序列，使他们的和等于sum，返回此子序列的长度，如果没有满足要求的序列，返回-1。
 示例

 输入：

 1,2,3,4,2
 6
 输出：

 3
 解析：

 1,2,3和4,2两个序列均能满足要求，所以最长的连续序列为1,2,3 因此结果为3
 输入：

 1,2,3,4,2
 20
 输出：

 -1
 解释：

 没有满足要求的子序列，返回-1
 备注:
 输入序列仅由数字和英文逗号构成，数字之间采用英文逗号分隔；
 序列长度：1 <= N <= score200；
 输入序列不考虑异常情况，由题目保证输入序列满足要求。
 */
public class 最长连续子序列的和等于输入值 {

    /**
     * 只要遍历计算连续的子序列和=sum就可以了，记录最终最长子序列
     * 如 1,2,3,4,2  sum=6，
     * 第一层循环从1开始遍历，第二层前三个序列1+2+3=6满足，子序列长度=3，1+2+3+4>6不满足跳出第二层回到第一层循环
     * 然后到2开始遍历，第二层叠加2+3+4>6不满足，跳出回到第一层循环
     * 从3开始遍历，第二层叠加3+4>6不满足，跳出回到第一层循环
     * 从4开始遍历，第二层叠加4+2=6满足，序列长度2，跳出回到第一层循环
     *最后是2开始遍历，2不等于6，不满足，退出第一层循环
     * 因此，最长子序列长度3
     *
     * 双层循环，
     * 第一层遍历每一个数字，第一次是索引为0的值开始累加，第二次是索引为1的值开始累加
     * 第二层往后累加，记录符合条件的长度，保留最大长度
     *
     * @param args
     */
     public static void main(String[] args) {


         // //传入输入值
         // Scanner sc = new Scanner(System.in);
         // //第一行，N个正整数组成的一个序列
         // String line = sc.nextLine();
         // //第二行，正整数计算值，把字符串转成基本类型：用包装类Integer的api将字符串转成int类型
         // int num = Integer.parseInt(sc.nextLine());
         // //去除符号，返回剩余的正整数数组
         // String[] split = line.split(",");
         // //初始化最长子序列长度，不符合要求的
         // int count = -1;
         // //第一层循环，是计算1+2+3=6跳出第二层然后又从2开始,2+3+4>6
         // for (int i = 0; i < split.length; i++) {
         //     //初始化连续子串累加值
         //     int sum = 0;
         //     // 记录起始位置，如1,2,3,4,2起始为1，跳出第二层循环时1+2+3=6起始
         //     int j = i;
         //     //第二层循环,寻找符合条件的子串，专门是计算1+2+3=6，当1+2+3+4>6时跳出子循环，回到第一层循环从下一个索引值开始遍历
         //     while (j < split.length) {
         //         //对遍历的当前子串值进行累加
         //         //sum=sum+第x个正整数
         //         sum += Integer.parseInt(split[j]);
         //         if (sum < num) {
         //             // 子串值累加值小于目标值，则向后走一位，下次继续累加
         //             j++;
         //         } else if (sum == num) {
         //             // 子串值累加值等于目标值，记录长度，只保留最大值
         //             //j - i + 1--》索引从0开始--》长度比索引多1--》两层循环之间的索引之差+1
         //             int tempCount = (j - i) + 1;
         //             //拿当前的子串值累加值和之前赋值的比较大小，保留最大值
         //             count = Math.max(count,tempCount);
         //         } else {
         //             // 子串值累加值超出目标值，退出子循环，从下个数开始
         //             //这步不能省，万一是1,2,3,0，仍然要再走一次循环
         //             break; } } }
         // System.out.println(count);


         //最长连续子序列，使他们的和等于sum，返回此子序列的长度
         Scanner sc = new Scanner(System.in);
         String line = sc.nextLine();
         int num = Integer.parseInt(sc.nextLine());
         String[] split = line.split(",");
         //初始化最长子序列长度，不符合要求的
         int count = -1;
         //第一层循环，是计算1+2+3=6跳出第二层然后又从2开始,2+3+4>6
         for (int i = 0; i < split.length; i++) {
             //初始化连续子串累加值
             int sum = 0;
             // 记录起始位置，如1,2,3,4,2起始为1，跳出第二层循环时1+2+3=6起始
             int j = i;
             //第二层循环,寻找符合条件的子串，专门是计算1+2+3=6，
             // 当1+2+3+4>6时跳出子循环，回到第一层循环从下一个索引值开始遍历
             while (j < split.length) {
                 //对遍历的当前子串值进行累加
                 //sum=sum+第x个正整数
                 sum += Integer.parseInt(split[j]);
                 if (sum < num) {
                     // 子串值累加值小于目标值，则向后走一位，下次继续累加
                     j++;
                 } else if (sum == num) {
                     // 子串值累加值等于目标值，记录长度，只保留最大值
          //j -i+1--》索引从0开始--》长度比索引多1-》两层循环之间的索引之差+1
                     int tempCount = (j - i) + 1;
                     //拿当前的子串值累加值和之前赋值的比较大小，保留最大值
                     count = Math.max(count,tempCount);
                 } else {
                     // 子串值累加值超出目标值，退出子循环，从下个数开始
                     //这步不能省，万一是1,2,3,0，仍然要再走一次循环
                     break; } } }
         System.out.println(count);

     }


    // public static void main(String[] args) {
    //
    //     //最长连续子序列，使他们的和等于sum，返回此子序列的长度
    //     Scanner sc = new Scanner(System.in);
    //     String[] split = sc.nextLine().split(",");
    //     int[] arr = new int[split.length];
    //     int sum = Integer.parseInt(sc.nextLine());
    //     int total = 0;
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = Integer.parseInt(split[i]);
    //         total += arr[i]; }
    //     if (total< sum){
    //         System.out.println(-1);
    //     }else if (total == sum){
    //         System.out.println(split.length);
    //     }else {
    //         //双指针
    //         int left = 0;
    //         int right = 0;
    //         int temp = 0;
    //         while (left < arr.length && right< arr.length){
    //             if (temp < sum){
    //                 temp += arr[right];
    //                 right++;
    //             }else if (temp != sum){
    //                 temp -= arr[left];
    //                 left++; }
    //             if (temp == sum){
    //                 System.out.println(right - left);
    //                 left++;
    //                 right = left;
    //                 temp = 0; } } }
    //
    //
    // }
}
