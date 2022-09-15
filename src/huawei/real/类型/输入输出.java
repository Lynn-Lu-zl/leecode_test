package huawei.real.类型;

import java.util.Arrays;
import java.util.Scanner;

public class 输入输出 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         while(sc.hasNext()) {
             String[] strs = sc.nextLine().split(" ");
             //操作
             System.out.println(Arrays.toString(strs));
         }

         }
    
}
