package huawei.real.score100;

import java.util.*;

/**
 * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
 * 输入描述:
 * 两个序列，每个序列由n个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
 * 输出描述:
 * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始
 * 示例1：
 * 输入
 4
 100 100 120 130
 40 30 60 50

 * 输出
 * 2 1 3 4
 * 说明
 * 输出的第一个数字2表示此人原始编号为2，即身高为100，体重为30的这个人。由于他和编号为1的人身高一样，但体重更轻，因此要排在1前面。
 * 示例2：
 * 输入
 3
 90 110 90
 45 60 45

 * 输出
 * 1 3 2
 * 说明
 * 1和3的身高体重都相同，需要按照原有位置关系让1排在3前面，而不是3 1 2
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124362254
 */
public class 按身高和体重排队 {
    /**
     * 法一
     */
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         in.nextLine();
         String[] height = in.nextLine().split(" ");
         String[] weight = in.nextLine().split(" ");
         int[] h = new int[n];
         int[] w = new int[n];
         Map<Integer, int[]> map = new HashMap<>();
         for (int i = 0; i < n; i++) {
             h[i] = Integer.parseInt(height[i]);
             w[i] = Integer.parseInt(weight[i]);
             map.put(i, new int[]{0, 0});
             int[] info = map.get(i);
             info[0] = h[i];
             info[1] = w[i];
         }

         // Map按value排序，先将map转为list,再排序list(按value值进行排序)
         List<Map.Entry<Integer, int[]>> list = new ArrayList<>(map.entrySet());
         // 通过比较器来实现排序
         list.sort((o1, o2) -> {
             // 降序排序
             int re = o1.getValue()[0] - o2.getValue()[0];
             if (re != 0) {
                 return re;
             }
             re = o1.getValue()[1] - o2.getValue()[1];
             if (re != 0) {
                 return re;
             }
             return 0;
         });

         StringBuilder sb = new StringBuilder();
         for (Map.Entry<Integer, int[]> mapping : list) {
             sb.append(String.valueOf(mapping.getKey() + 1) + " ");
         }
         System.out.print(sb.toString().trim());
     }


    /**
     * 法二
     */
    // static class Stu{
    //     public int ind;
    //     public int h;
    //     public int m;
    //     Stu(int ind,int h,int m){
    //         this.ind=ind;
    //         this.h=h;
    //         this.m=m;
    //     }
    // }
    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     int n = Integer.parseInt(in.nextLine());
    //     String [] h = in.nextLine().split(" ");
    //     String [] m = in.nextLine().split(" ");
    //     List<Stu> list = new ArrayList<>(n);
    //     if (n==h.length&&n==m.length){
    //         for (int i = 1; i <=n ; i++) {
    //             list.add(new Stu(i,Integer.parseInt(h[i-1]),Integer.parseInt(m[i-1])));
    //         }
    //     }
    //     list.sort(Comparator.comparingInt((Stu a) -> a.h).thenComparingInt(a -> a.m));
    //     for (int i=0;i<list.size();i++) {
    //         System.out.print(list.get(i).ind);
    //         if (i!=list.size()-1){
    //             System.out.print(" ");
    //         }
    //     }
    // }
}
