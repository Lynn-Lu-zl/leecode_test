package DataStructure.Array;

import java.util.Arrays;

/**
 * 1、数组的声明方式
 *      数据类型 [] 数组名;   []声明是数组类型  int[] arrs;
 *      数据类型 数组名 [];   不推荐，int arrays[];  因为会引起歧义，误以为数组名后面[]的是数组名而不是数组类型声明
 *
 * 2、数组的初始化：声明数组+给数组在堆内存分配空间+给数组赋初始化值，仅仅声明是不够的，声明了一个数组变量只会存储在栈中，堆内存是不会发生变化的，当给数组分配空间后才会在堆内存中给数组真的分配空间并且数组变量会指向数组在堆内存中的地址
 * 声明数组：int[] arrs
 * 给数组在堆内存分配空间：数组名=new 数据类型 [数组长度]  ,arrs=new int[2];
 * 给数组赋初始化值：数组名 [索引]  arrs[0]=55;
 * 二合一：int[] arrs;  arrs=new int[]{55,10,2}
 *
 * 结果：[I@1b6d3586  class对象名称（[为一维数组+I为数据类型为int类型）+@+hashcode值
 *
 *
 *      静态初始化：给出系统初始化值，由系统决定长度
 *          数据类型 [] 变量名=new 数据类型 [] {数组赋值1，赋值2...},int [] arrs= new int[]{55,10,2};
 *          数据类型 [] 变量名={数组赋值1，赋值2}，int [] arrs= {55,10,2};
 *
 *
 *
 *      动态初始化:只给出长度，由系统给初始化值
 *
 *          数据类型 [] 变量名=new 数据类型 [必写数组长度]; int[] arrs=new int[5]，声明一个能够存储5个元素的int类型的数组，
 *          如果要给数组重新赋值不能直接写 数组名={}编译出错,要按照arrs=new int[]{55,10,2}
 *
 *
 *
 *
 */
public class ArrayTest01 {
     public static void main(String[] args) {
          //法一
         int[] arrs;
         arrs=new int[2];
         arrs[0]=55;
         arrs[1]=10;



         //法二，不推荐，因为会引起歧义，误以为数据类型后面的arrays[]、strs[]是变量名而不是数组的定义
         // int arrays[];
         // String strs[];
         //int strs;

         //int[] arrs=new int[5];
         //给数组重新赋值
         //arrs=new int[] {55,10,2};

         System.out.println(arrs);
         System.out.println(Arrays.toString(arrs));
         }
}
