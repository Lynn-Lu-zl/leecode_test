package huawei.real.score100.数组;

import java.util.*;

/**
 * 【查找众数及中位数】
 *
 * 众数是指一组数据中出现次数量多的那个数，众数可以是多个。
 * 中位数是指把一组数据从小到大排列，最中间的那个数，
 * 如果这组数据的个数是奇数，那最中间那个就是中位数，
 * 如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数。
 *
 * 1、查找整型数组中元素的众数并组成一个新的数组，
 * 2、求新数组的中位数。
 * 输入描述
 *
 * 输入一个一维整型数组，数组大小取值范围 0<N<1000，数组中每个元素取值范围 0<E<1000
 * 输出描述
 *
 * 输出众数组成的新数组的中位数
 * 示例1   输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 10 11 21 19 21 17 21 16 21 18 15
 *
 * 输出
 *
 * 21
 *
 * 示例2   输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
 *
 * 输出
 *
 * 3
 *
 * 示例3   输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39
 *
 * 输出
 *
 * 7
 */
public class 查找众数及中位数 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String line = scanner.nextLine();
         String[] split = line.split(" ");


         Map<Integer, Integer> hashMap = new HashMap<>();
         //遍历数组，将相同的值作为key，value存出现的次数
         for (int i = 0; i < split.length; i++) {
             Integer key = Integer.valueOf(split[i]);
             //map中没有key值--》出现第一次的值--》存入key
             if ( ! hashMap.containsKey(key)){
                 hashMap.put(key,1);
             }else{
                 //key重复出现的话则将次数增加1--》value+1
                 hashMap.replace(key,hashMap.get(key)+1);
             }
         }

         //众数累加值
         int zhongCount=0;
         //遍历map的key对应的次数，取最多的次数赋给众数累加值
         for (int value : hashMap.values()) {
             zhongCount = Math.max(value,zhongCount);
         }
         //新建一个list动态数组集合，因为不确定众数的个数
         ArrayList<Integer> list = new ArrayList<>();
         for (int key : hashMap.keySet()) {
             //上面已经给拿到众数值了--》找两个值相同的--》hashMap.get(key)根据key获取次数value--》因为众数可以有多个所以不用考虑值重复问题
             if (hashMap.get(key) == zhongCount){
                 //将和众数相同的次数都找出来放到动态数组中
                 list.add(key);
             }
         }
         System.out.println(list);
         //对动态数组进行排序
         list.sort(null);
         //拿到数组的长度--》计算中位数的位置--》因为奇数中位数的位置是数组长度/2
         int n=list.size();

         //定义新数组的中位数，
         int midNum = 0;
         //  n &1（&：将整数转成二进制逐个对比，同1为1，不同为0，得到结果为0则是偶数）--》判断奇数偶数，如果n为偶数返回0，奇数返回1
         //直接用取模(n % 2) == 0说明是偶数
         if ((n % 2) == 0){
             // 数组长度为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数。
             //5,7,8,9-->7+8/2
             Integer left = list.get(n / 2);
             Integer right = list.get(n / 2 - 1);
             midNum=(left+right)/2;
             System.out.println(midNum);
         }else {
             // 数组长度为奇数，那最中间那个就是中位数
             midNum=list.get(n/2);
             System.out.println(midNum);
         }

     }
}
