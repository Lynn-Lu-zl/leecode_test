package huawei.real.score100;

import java.util.Arrays;
import java.util.Scanner;

public class 分苹果 {

 public static void main(String[] args) {

     //分苹果
     Scanner scanner = new Scanner(System.in);
     int n = scanner.nextInt();
     int[] nums = new int[n];
     for (int i = 0; i <n ; i++) {
         nums[i] = scanner.nextInt();
     }
     // 按照A的想法，如果能后平分，那么所有重量异或后就==0
     int xor = 0;
     for (int i = 0; i <n ; i++) {
         xor ^= nums[i];
     }

     if (xor==0){
         // 能平分
         Arrays.sort(nums);
         // B能拿的最大重量：就是n-1个最大重量的苹果
         int bSum = 0;
         for (int i = 1; i < n; i++) {
             bSum += nums[i];
         }
         System.out.println(bSum);
     }else {
         // 不能平分
         System.out.println(-1);
     }
     }

}
