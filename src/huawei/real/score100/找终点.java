package huawei.real.score100;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 给定一个正整数数组，设为nums，最大为100个成员，求从第一个成员开始，正好走到数组最后一个成员，所使用的最少步骤数。
 * 要求：
 * 1、第一步必须从第一元素开始，且1<=第一步的步长<len/2;（len为数组的长度，需要自行解析）。
 * 2、从第二步开始，只能以所在成员的数字走相应的步数，不能多也不能少, 如果目标不可达返回-1，只输出最少的步骤数量。
 * 3、只能向数组的尾部走，不能往回走。
 * 输入描述:
 * 由正整数组成的数组，以空格分隔，数组长度小于100，请自行解析数据数量。
 * 输出描述:
 * 正整数，表示最少的步数，如果不存在输出-1
 * 示例1
 * 输入
 * 7 5 9 4 2 6 8 3 5 4 3 9
 * 输出
 * 2
 * 说明
 * 第一步： 第一个可选步长选择2，从第一个成员7开始走2步，到达9；第二步： 从9开始，经过自身数字9对应的9个成员到最后。
 * 示例2
 * 输入
 * 1 2 3 7 1 5 9 3 2 1
 * 输出
 * -1
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124551079
 */
public class 找终点 {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     String[] input = sc.nextLine().split(" ");
    //     int firstStepMin = 2;
    //     int firstStepMax = input.length/2;
    //     int minStep = Integer.MAX_VALUE;
    //     int cur = 0;
    //     int tempStep = 0;
    //     for (int step = firstStepMin; step < firstStepMax; step++) {
    //         int target = input.length - 1;
    //         cur = step;
    //         tempStep++;
    //         while (cur < target){
    //             cur += Integer.parseInt(input[cur]);
    //             tempStep++;
    //             if (cur == target){
    //                 minStep = Math.min(minStep,tempStep);
    //                 break;
    //             }
    //             if (cur> target){
    //                 tempStep = 0;
    //                 cur = 0;
    //                 break;
    //             }
    //         }
    //     }
    //     if (minStep > input.length){
    //         System.out.println(-1);
    //     }else {
    //         System.out.println(minStep);
    //     }
    // }



    public static void main(String[] args) {


        //找终点，最大为100个成员，所使用的最少步骤数
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strArr = line.split(" ");
        int stepSmallest = 0;
        for (int i = 1; i < strArr.length / 2; i++){
            // 第一步走到索引 i
            int index = i;
            int step = 0;
            while (true) {
                if (index >= strArr.length) {
                    stepSmallest = -1;
                    break; }
                step++;
                int current = Integer.parseInt(strArr[index]);
                if (strArr.length - 1 == index) {
                    if (stepSmallest <= 0) {
                        stepSmallest = step;
                    } else if (stepSmallest <= step) {
                    } else {
                        stepSmallest = step; }
                    break; }
                index += current; } }
        System.out.println(stepSmallest);
    }


    /**
     * 法二
     */
    // //index表示数组索引位置  level表示步数
    // public static int step(int index, int level, String[] arr) {
    //
    //     if(index == arr.length - 1) {
    //         return level;
    //     }
    //     if (index > arr.length - 1) {
    //         return -1;
    //     }
    //     //下一步的数组位置
    //     int nextIndex = Integer.parseInt(arr[index]) + index;
    //
    //     return step(nextIndex, level + 1, arr);
    // }
    // public static void main(String[] args) {
    //     Scanner input = new Scanner(System.in);
    //     while (input.hasNextLine()) {
    //         String str = input.nextLine();
    //         String[] arr = str.split(" ");
    //         if(arr.length/2 <= 1){
    //             System.out.println(-1);
    //         }
    //
    //         int min= Integer.MAX_VALUE;
    //         for (int first = 1; first <= arr.length / 2; first++) {
    //             int ret = step(Integer.parseInt(arr[first]),1,arr);
    //             if (ret < min) {
    //                 min = ret;
    //             } else {
    //                 continue;
    //             }
    //         }
    //         if (min > 0) {
    //             System.out.println(min);
    //         } else {
    //             System.out.println(-1);
    //         }
    //     }
    //     input.close();
    // }


    /**
     * 法3,100%
     */
//     private static int[] ints = null;
//     private static int step = 0;
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         String[] split = in.nextLine().split(" ");
//         ints = new int[split.length];
//         for (int i = 0; i < split.length; i++) {
//             ints[i] = Integer.parseInt(split[i]);
//         }
//         int len = ints.length;
//
//         TreeSet<Integer> set = new TreeSet<>();
//
//         for (int i = 1; i < len / 2; i++) {
// //            if (ints[i] >= len / 2) continue;
//             step = 1;
//             set.add(in(i, i));
//         }
//         System.out.println(set);
//
//         if (set.size() != 1) set.pollFirst();
//
//         System.out.println(set.first());
//     }
//
//     private static int in(int curPos, int lastPos) {
//         int numStep = ints[curPos];
//         if (lastPos == ints.length - 1) {
//             return step;
//         } else if (lastPos < ints.length - 1) {
//             step++;
//             return in(lastPos, lastPos + numStep);
//         } else {
//             return -1;
//         }
//     }

}
