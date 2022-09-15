package huawei.real.score200;

import java.util.Scanner;

/**
 * https://f.daixianiu.cn/csdn/037418659046849045.html
 * Solo和koko是两兄弟，妈妈给了他们一大堆积木，每块积木上都有自己的重量。现在他们想要将这些积木分成两堆。哥哥Solo负责分配，弟弟koko要求两个人获得的积木总重量“相等”（根据Koko的逻辑），个数可以不同，不然就会哭，但koko只会先将两个数转成二进制再进行加法，而且总会忘记进位（每个进位都忘记）。如当25（11101）加11（1011）时，koko得到的计算结果是18（10010）：
 *
 *  11001
 *
 * +01011
 *
 * --------
 *
 *  10010
 *
 * Solo想要尽可能使自己得到的积木总重量最大，且不让koko哭。
 *
 * 输入描述:
 *
 * 3
 *
 * 3 5 6
 *
 * 第一行是一个整数N(2≤N≤100)，表示有多少块积木；第二行为空格分开的N个整数Ci(1≤Ci≤106)，表示第i块积木的重量。
 *
 * 输出描述:
 *
 * 11
 *
 * 让koko不哭，输出Solo所能获得积木的最大总重量；否则输出“NO”。
 *
 * 示例1
 * 输入
 *
 * 3
 *
 * 3 5 6
 *
 * 输出
 *
 * 11
 *
 * 备注:
 *
 * 如果能让koko不哭，输出Solo所能获得的积木的总重量，否则输出-1。
 *
 * 该样例输出为11。
 *
 * 解释：Solo能获得重量为5和6的两块积木，5转成二级制为101，6转成二进制位110，按照koko的计算方法（忘记进位），结果为11(二进制)。Koko获得重量为3的积木，转成二进制位11(二进制)。Solo和koko得到的积木的重量都是11(二进制)。因此Solo可以获得的积木的总重量是5+6=11（十进制）。
 *
 * 解题思路：
 * 在不进位的情况下进行二进制运算，其实就是异或运算。
 *
 * 根据题意，就是需要所有值的异或运算最终结果为0
 *
 * 当所有值的异或运算为0，就可以进行平分，只要减去最小的积木重量，solo就能获取最多的积木重量；否则返回No。
 */
public class 平分积木重量 {
    /**
     * 在不进位的情况下进行二进制运算，其实就是异或运算。
     * 根据题意，就是需要所有值的异或运算最终结果为0
     * 当所有值的异或运算为0，就可以进行平分，只要减去最小的积木重量，solo就能获取最多的积木重量；否则返回No。
     */
    public static void main(String args[]){
        //平分积木重量，Solo和koko是两兄弟
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = Integer.valueOf(sc.nextLine());
            int[] arr = new int[n];
            String [] ss = sc.nextLine().split(" ");
            for(int i =0; i<n; i++){
                arr[i] = Integer.parseInt(ss[i]);
            }
            String result = getResult(arr);
            System.out.println(result);
        }
    }
    public static String getResult(int [] arr){
        if(arr.length == 2 && arr[0] != arr[1]) return "NO";
        int min = arr[0];
        int sum = min;
        int temp = min;
        for(int i = 1; i<arr.length; i++){
            sum += arr[i];
            min = min< arr[i] ? min : arr[i];
            temp ^= arr[i];
        }
        if(temp != 0) {
            return "NO";
        }else{
            return String.valueOf(sum-min);
        }
    }
}
