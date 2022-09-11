package huawei.real.score100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 寻找身高相近的小朋友
 * 
 * 题目描述
 *
 * 小明今年升学到了小学1年级来到新班级后，发现其他小朋友身高参差不齐，然后就想基于各小朋友和自己的身高差，对他们进行排序，请帮他实现排序。
 *
 * 输入描述
 *
 * 第一行为正整数 h和n，0<h<200 为小明的身高，0<n<50 为新班级其他小朋友个数。
 *
 * 第二行为n个正整数，h1 ~ hn分别是其他小朋友的身高，取值范围0<hi<200，且n个正整数各不相同。
 *
 * 输出描述
 *
 * 输出排序结果，各正整数以空格分割，
 *
 * 和小明身高差绝对值最小的小朋友排在前面，
 *
 * 和小明身高差绝对值最大的小朋友排在后面，
 *
 * 如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
 *
 * 示例1   输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 100 10
 * 95 96 97 98 99 101 102 103 104 105
 *
 * 输出
 *
 * 99 101 98 102 97 103 96 104 95 105
 */
public class 小朋友排队 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String[] input = sc.nextLine().split(" ");
         int myHigh = Integer.parseInt(input[0]);
         int count = Integer.parseInt(input[1]);
         String[] students = sc.nextLine().split(" ");
         List<Student> list = new ArrayList<>();
         for (int i = 0; i < count; i++) {
             int highTemp = Integer.parseInt(students[i]);
             list.add(new Student(highTemp, Math.abs(myHigh - highTemp)));
         }
         list.sort(null);
         for (int i = 0; i < list.size(); i++) {
             System.out.print(list.get(i).high + " ");
         }
         System.out.println();
     }
    private static class Student implements Comparable<Student>{
        private int high;
        private int gap;

        public Student(int high, int gap) {
            this.high = high;
            this.gap = gap;
        }

        @Override
        public int compareTo(Student stu) {
            if (stu.gap != this.gap) {
                return this.gap - stu.gap;
            } else {
                return this.high - stu.high;
            }
        }

     }
}
