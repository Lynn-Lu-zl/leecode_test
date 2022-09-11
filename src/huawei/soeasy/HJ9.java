package huawei.soeasy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * HJ9 提取不重复的整数
 *
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 *
 * 数据范围： 1≤n≤10的8次方
 *
 *
 *
 * 输入描述：
 * 输入一个int型整数
 *
 * 输出描述：
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入：
 * 9876673
 * 复制
 * 输出：
 * 37689
 */
public class HJ9 {
    /**
     * 不重复--》hashset
     * @param args
     */
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String line = scanner.nextLine();
         Set hashSet = new HashSet<>();

         
         System.out.println();

     }
}
