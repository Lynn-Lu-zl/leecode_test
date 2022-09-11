package huawei.real.score100.数组;

import java.util.Scanner;

/**
 * 【滑动窗口最大和】
 *
 * 有一个N个整数的数组，和一个长度为M的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止，
 *
 * 每次窗口滑动产生一个窗口和（窗口内所有数的和），求窗口滑动产生的所有窗口和的最大值。
 *
 * 输入描述：
 *
 * 第一行输入一个正整数N，表示整数个数。（0<N<100000）
 * 第二行输入N个整数，整数的取值范围为[-100,100]。
 * 第三行输入一个正整数M，M代表窗口的大小，M<=100000，且M<=N。
 * 输出描述：
 *
 * 窗口滑动产生所有窗口和的最大值。
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 6
 *
 * 10 20 30 15 23 12
 *
 * 3
 *
 * 输出
 *
 * 68
 *
 * 说明
 *
 * 窗口长度为3，窗口滑动产生的窗口和分别为10+20+30=60，20+30+15=65，30+15+23=68，15+23+12=50，
 *
 * 所以窗口滑动产生的所有窗口和的最大值为68。
 */
public class 滑动窗口最大和 {
//      public static void main(String[] args) {
//          Scanner sc = new Scanner(System.in);
//          while (sc.hasNextInt()) {
//              int n = sc.nextInt();
//              int[] array = new int[n];
//              for (int i = 0; i < n; i++) {
//                  array[i] = sc.nextInt();
//              }
//              // 生成一个新数组，记录窗口大小m。
//              int m = sc.nextInt();
//              int[] arrM = new int[n - m + 1];
//              for (int i = 0; i < n - m + 1; i++) {
//                  arrM[i] = 0;
//                  for (int j = 0; j < m; j++) {
//                      arrM[i] += array[i + j];
//                  }
// //				System.out.println(arrM[i]);
//              }
//              // 排序，取出最后一个最大的值
//              Arrays.sort(arrM);
//              System.out.println(arrM[n - m]);
//
//          }
//
//      }


    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int n = Integer.parseInt(scanner.nextLine());
    //     List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
    //     int m = Integer.parseInt(scanner.nextLine());
    //     scanner.close();
    //
    //     int maxSum = 0;
    //     for (int i = 0; i < m; i++) {
    //         maxSum += nums.get(i);
    //     }
    //
    //     int curSum = maxSum;
    //     for (int i = m; i < n; i++) {
    //         int diff = nums.get(i) - nums.get(i - m);
    //         curSum += diff;
    //         if (curSum > maxSum) {
    //             maxSum = curSum;
    //         }
    //     }
    //
    //     System.out.println(maxSum);
    // }


    /**6
     * 10 20 30 15 23 12
     * 3
     * 计算滑动的前后差
     * 先算出滑动前的值--》暂且为最大值
     * 10+20+30
     *
     * 然后滑第一次--》和滑前的区别在于10和15--》如果后来者的值比之前的值大diff=15-10=5>0--》最大值要易主了--》此时最大值为滑动前的值60+5=65
     * 0+20+30+15
     *
     * 第二次--》和第一次的差别在于20和23--》23-20=3>0-->最大值变成65+3=68
     * 0+0+30+15+23
     *
     * 第三次--》和第2次的差别在于30和12--》12-30<0-->最大值还是上次的68
     * 0+0+0+15+23+12
     * @param args
     */
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         //一共输入正整数数量
         String line = scanner.nextLine();
         int num = Integer.parseInt(line);


         //数据，字符串数组，可为负数
         String nextLine = scanner.nextLine();
         String[] split = nextLine.split(" ");
         //System.out.println(Arrays.toString(split));
         //变成整形数组
         int[] ints = new int[num];
         for (int i = 0; i < num; i++) {
             ints[i] = Integer.parseInt(split[i]);
         }
         //System.out.println(Arrays.toString(ints));

         //窗口长度
         String s = scanner.nextLine();
         int win = Integer.parseInt(s);
         //如果长度为0--》不滑了--》最大值为0--》直接返回0
         if (win == 0){
             System.out.println(0);
         }

         //初始化窗口和最大值
         int maxSum=0;

         for (int i = 0; i < win; i++) {
             //先算原始没滑动前的值
             maxSum += ints[i];
         }

         for (int i = win; i < num; i++) {
             //15-10>0-->说明最大值要改变了
             int diff = ints[i] - ints[i-win];
             //两次滑动之前的差别在于第一个数和最后一个数，中间的值是不变的--》如果滑动后一次的数-滑动前一次的值大于0--》说明整体最大值是增加的--》最大值=上一次的最大值+两次滑动的差值
             if (diff > 0){
                 //maxsum = maxsum + diff
                 //60+5
                 //65+3
                 maxSum += diff;
             }
         }
         System.out.println(maxSum);
     }





}
