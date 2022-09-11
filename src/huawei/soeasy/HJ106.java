package huawei.soeasy;

import java.util.Scanner;

/**
 * 字符逆序
 *
 * 描述
 * 将一个字符串str的内容颠倒过来，并输出。
 *
 * 数据范围：1 \le len(str) \le 10000\1≤len(str)≤10000
 * 输入描述：
 * 输入一个字符串，可以有空格
 *
 * 输出描述：
 * 输出逆序的字符串
 *
 * 示例1
 * 输入：
 * I am a student
 * 复制
 * 输出：
 * tneduts a ma I
 * 复制
 * 示例2
 * 输入：
 * nowcoder
 * 复制
 * 输出：
 * redocwon
 *
 */
public class HJ106 {

    /**
     * 双指针
     * 将头和尾相互调换位置
     * 循环次数是长度一半
     *
     * 把头元素放到temp--》尾和头调换--》再把temp存储的头元素放到尾
     * @param array
     */
    private void reverseSort(char[] array) {

        //索引从0开始，数组长度-1
        int len = array.length-1;
        //头尾调换，只需循环数组长度的一半
        for (int i = 0; i < array.length / 2; i++) {
            // 把头元素放到temp
            char temp = array[i];
            //尾和头调换
            array[i] = array[len - i];
            // 再把temp存储的头元素放到尾
            array[len - i] = temp;
        }
        //遍历循环后的字符串数组并打印
        for (char c : array) {
            System.out.print(c);
        }

    }

     public static void main(String[] args) {

         // 1、输入一个或多行参数值
         Scanner scanner = new Scanner(System.in);
         // 取出每一行值，赋值给s
         String s = scanner.nextLine();
         // 将变量s的值转换为char类型的数组，用于排序
         char[] array = s.toCharArray();
         // 5、对char类型的数组使用反转法，达到反转效果
         HJ106 hj106 = new HJ106();
         hj106.reverseSort(array);

     }


}
