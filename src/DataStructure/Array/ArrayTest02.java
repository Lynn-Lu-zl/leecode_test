package DataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayTest02 {
     public static void main(String[] args) {
         /**
          * 创建数组
          * 前三种方法是普通int[]，第四种为集合ArrayList
          */
         //1、已知元素数组
         int[] a = {1,2,5};
         System.out.println("a:"+Arrays.toString(a));
         //2、已知元素数组
         int[] b = new int[]{1,2,5};
         System.out.println("b:"+Arrays.toString(b));
         //3、未知元素数组+已知长度
         int[] c = new int[3];
         for (int i = 0; i < c.length; i++) {
             c[i] = i+1;
         }
         System.out.println("c:"+Arrays.toString(c));
         //4、集合+包装类，未知元素数组+未知长度
         ArrayList<Integer> arrayList = new ArrayList<>();
         for (int i = 0; i < 3; i++) {
             arrayList.add(i+1);
         }
         System.out.println("arrayList:"+arrayList.toString());

         /**
          * 添加元素
          * int[]添加元素很麻烦，需要重新创建新数组再添加
          * ArrayList自动扩容，时间复杂度O(1)/O(N)
          */
         //指定位置添加元素，默认在当前数组尾部添加，时间复杂度O(1)
         arrayList.add(99);
         System.out.println("arrayList:"+arrayList.toString());
         //任意位置添加元素，两个参数，索引+元素，这种添加方式因为索引所在位置被其他元素占据了，不是连续的存储空间，会重新开辟一个新的连续空间创建新数组，将相同的元素复制，时间复杂度O(N)
         //说法2，索引所在位置占据该空间后，在其后的最后一个元素要挪后N个空间
         arrayList.add(3, 88);
         System.out.println("arrayList:"+arrayList.toString());

         /**
          * 访问元素
          * 通过索引访问
          * 时间复杂度O(1)
          */
         System.out.println("c索引为1的元素："+c[1]);
         System.out.println("arrayList索引为1的元素："+arrayList.get(1));

         /**
          * 更新元素
          * 时间复杂度O(1)，因为是访问到这个元素就更新，访问的时间复杂度为O(1)
          */
         //普通
         c[1] = 11;
         System.out.println("c更新的元素："+c[1]);
         System.out.println("c更新元素后的数组："+Arrays.toString(c));
         //集合
         arrayList.set(1, 11);
         System.out.println("arrayList更新的元素："+arrayList.get(1));
         System.out.println("arrayList更新元素后的数组："+arrayList.toString());

         /**
          * 删除元素
          *
          * int[]删除元素很麻烦，一般用arrayList，根据索引删除元素
          * arrayList时间复杂度O(N)，删除了缺了一块，不是连续的存储空间，最后一个元素往前挪N次填补
          */
         //arrayList.remove(3);
         System.out.println("arrayList删除索引为3的元素后的数组："+arrayList.toString());

         /**
          * 获取数组长度
          * 时间复杂度O(1)
          */
         System.out.println("c的数组长度："+c.length);
         System.out.println("arrayList的数组长度："+arrayList.size());

         /**
          * 遍历数组
          * 时间复杂度O(N),N为数组长度
          */
         //遍历普通数组
         for (int i = 0; i < c.length; i++) {
             System.out.println("c索引为"+i+"元素:"+c[i]);
         }

         for (int i : c) {
             System.out.println("c的元素："+i);
         }

         //遍历arrayList
         for (int i = 0; i < arrayList.size(); i++) {
             System.out.println("arrayList索引为"+i+"元素:"+arrayList.get(i));
         }

         /**
          * 查找元素
          * 时间复杂度O(N),N为数组长度，无论有没有查找到都要遍历
          */
         //遍历普通查找
         for (int i = 0; i < c.length; i++) {
             if (c[i] == 99){
                 System.out.println("99找到了");
             }
         }
         System.out.println("99找不到");

         //遍历arrayList查找，返回一个布尔值，方法源码也是通过遍历
         boolean b1 = arrayList.contains(99);
         System.out.println(b1);

         /**
          * 排序
          * 小到大时间复杂度：O(N logN)，排序方法中最小的复杂度
          * 大到小时间复杂度：O(N logN)
          */
         //小到大
         //普通排序，自带排序方法
         Arrays.sort(c);
         System.out.println("c从小到大排序后的数组："+Arrays.toString(c));

         //arrayList排序，自带排序方法
         Collections.sort(arrayList);
         System.out.println("arrayList从小到大排序后的数组："+arrayList.toString());

         //从大到小
         //普通排序
         //法一：将数组从小到大排序后从后往前读


         //法二，将数组设置为Integer类型+自带排序方法
         Integer[] d = {55,22,100};
         Arrays.sort(d,Collections.reverseOrder());
         System.out.println(Arrays.toString(d));

         //arrayList排序，自带排序方法，和上面类似
         Collections.sort(arrayList, Collections.reverseOrder());
         System.out.println("arrayList从大到小排序后的数组："+arrayList.toString());

     }
}
