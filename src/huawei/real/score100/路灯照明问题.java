package huawei.real.score100;

import java.util.*;

/**
 * https://f.daixianiu.cn/csdn/6250544615507815.html
 * 一条笔直的公路上安装了N个路灯，从位置0开始安装，路灯之间的距离是100m。
 * 每个路灯都有自己的照明半径，请计算第一个路灯和最后一个路灯之间，未照明区间的长度和。
 * 输入描述：
 * 第一行为一个数N，表示灯的个数，[1, 100000]
 * 第二行为N个","分隔的数，表示路灯的照明半径，[1, 100*100000]
 * 输出描述：
 * 第一个路灯和最后一个路灯之间，未照明区间的长度和
 * 举例：
 * 输入:
 * 8
 * 10,10,10,10,10,10,10,10
 * 输出：
 * 560
 * 输入：
 * 6
 * 50,20,60,120,30,230
 * 输出：
 * 50
 *
 *
 *
 示例1

 输入

 2

 50 50

 输出

 0

 说明

 路灯1覆盖0-50，路灯2覆盖50-100，路灯1和路灯2之间(0米-100米)无未覆盖的区间

 示例2

 输入

 4
 50,70,20,70

 输出
 20

 说明

 [170,180],[220,230]，两个未覆盖的区间，总里程为20

 解题思路：
 1、根据每个灯照射范围确定其左边界star和右边界end；

 2、设置一个参数end，用来记录照射范围的最远右边界；

 3、将当前的左边界start跟最远右边界end进行比较；如果start>end，说明存在未照射区间，将其边界放入数组中，加入未照射区间list集合；如果存在未照明区间（list不为空）且当前左边界start大于最后一个未照射区间右边界，则进行步骤4

 4、将当前左边界start跟最后一个未照射区间的左边界unLightStart进行比较；如果当前照射左边界start小于等于未照射区间左边界unLightStart，则此区间被照射并移除此数组，重复步骤4；如果当前照射左边界start大于未照射区间左边界unLightStart但是小于未照射区间右边界unLightEnd，则将start作为unLightEnd更新数组；

 5、最后对list集合中的各数组差进行求和
 */
public class 路灯照明问题 {
    public static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {

        //路灯照明问题,一条笔直的公路上安装了N个路灯
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] line = sc.nextLine().split(",");
        int[] ints = new int[n];
        for (int i = 0; i < line.length; i++) {
            ints[i] = Integer.parseInt(line[i]); }
        System.out.println(Arrays.toString(ints));
        int res = 0;
        int end = ints[0]; //第一个路灯照射范围的右边界
        for(int i=1;i<ints.length;i++){
            int star = 100*i - ints[i]; //第i个路灯照射范围的左边界
            star = star<0 ? 0 : star;   //如果照射范围过大，start可能出现负数
            if(star>end){   //表示有没有照射的区域
                int[] unLight = new int[2];
                unLight[0] = end;
                unLight[1] = star;
                list.add(unLight);
                //如果存在未照明区间且当前照射范围左边界大于最后一个未照射区间右边界
            }else if(list.size()!=0 && star<list.get(list.size()-1)[1]){
                updateList(star); }
            int indexEnd = 100*i + ints[i];  //第i个路灯照射范围的右边界
            end = end >= indexEnd ? end : indexEnd;} //记录最远的照射右边界
        for(int i=0;i<list.size();i++){
            res+= list.get(i)[1]-list.get(i)[0]; }
        System.out.println(res); }
    public static void updateList(int start){
        boolean isEnd = false;
        while (list.size()>0 && !isEnd){
            int index = list.size()-1;  //只跟最后一个未照明区间比较
            int unLightStart = list.get(index)[0];  //未照射左边界
            int unLightEnd = list.get(index)[1];    //为照射右边界
            if(start<=unLightStart){
                list.remove(index); //当前照射左边界小于等于未照射区间左边界，则此区间被照射，移除
            }else if(start<unLightEnd){
                list.remove(index);
                int[] unLight = new int[2];
                unLight[0] = unLightStart;
                unLight[1] = start;
                list.add(unLight);
                isEnd = true;//如果照射左边界大于未照射区间左边界但小于右边界，则边界更新，且退出循环
            }else {
                isEnd = true;   } } }//上面两个都不符合则直接退出

}
