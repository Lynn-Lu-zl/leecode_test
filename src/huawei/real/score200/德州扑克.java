package huawei.real.score200;

import java.util.*;

/**
 * https://f.daixianiu.cn/csdn/7902860880368086.html
 * 五张牌，每张牌由牌大小和花色组成，牌大小2~10、J、Q、K、A，牌花色为红桃、黑桃、梅花、方块四种花色之一。 判断牌型:
 * 牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6。
 * 牌型2，四条：四张相同数字 + 单张，如红桃A黑桃A梅花A方块A + 黑桃K。
 * 牌型3，葫芦：三张相同数字 + 一对，如红桃5黑桃5梅花5 + 方块9梅花9。
 * 牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q。
 * 牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6。
 * 牌型6，三条：三张相同 + 两张单。
 * 牌型7，其他。
 * 说明：
 * 1）五张牌里不会出现牌大小和花色完全相同的牌。
 *
 * 2）编号小的牌型较大，如同花顺比四条大，依次类推。
 *
 * 3）包含A的合法的顺子只有10 J Q K A和A 2 3 4 5，类似K A 2 3 4的序列不认为是顺子。
 *
 * 输入描述:
 *
 * 输入由5行组成，每行为一张牌大小和花色，牌大小为2~10、J、Q、K、A，花色分别用字符H、S、C、D表示红桃、黑桃、梅花、方块。
 *
 * 输出描述:
 *
 * 输出牌型序号，5张牌符合多种牌型时，取最大的牌型序号输出。
 *
 * 示例1
 * 输入
 *
 * 4 H
 *
 * 5 S
 *
 * 6 C
 *
 * 7 D
 *
 * 8 D
 *
 * 输出
 *
 * 5
 *
 * 说明
 *
 * 4 5 6 7 8构成顺子，输出5
 *
 * 示例2
 * 输入
 *
 * 9 S
 *
 * 5 S
 *
 * 6 S
 *
 * 7 S
 *
 * 8 S
 *
 * 输出
 *
 * 1
 *
 * 说明
 *
 * 既是顺子又是同花，输出1，同花顺
 *
 * 解题思路：
 * 将牌面数字和其数量作为键值对放入map函数中
 * New一个int数组，其索引0,1,2,3代表H,S,C,D，其值代表各花色个数
 * 如果int数组中，有其中一个数值为5，则代表同花
 * 判断map的长度：
 * 如果map的长度为5，则说明5张牌都不一样。可以判断是否为顺子，也需要判断其是否为同花。需要注意的是，A可以作为1，也可以做为14。
 * map如果有value值为4，则为四条；如果有value值为3，则判断map长度，如果长度为2，则为葫芦；如果长度为3，则为三条
 */
public class 德州扑克 {
    /**
     * 1、将牌面数字和其数量作为键值对放入map函数中
     * 2、New一个int数组，其索引0,1,2,3代表H,S,C,D，其值代表各花色个数
     * 3、如果int数组中，有其中一个数值为5，则代表同花
     * 4、判断map的长度：
     *      1、如果map的长度为5，则说明5张牌都不一样。可以判断是否为顺子，也需要判断其是否为同花。需要注意的是，A可以作为1，也可以做为14。
     *      2、map如果有value值为4，则为四条；如果有value值为3，则判断map长度，如果长度为2，则为葫芦；如果长度为3，则为三条
     */
     public static void main(String[] args) {
         //德州扑克
         Scanner sc = new Scanner(System.in);
         List<Integer> numList = new ArrayList<>();
         Map<Integer, Integer> map = new HashMap<>();    //数字，数字个数键值对
         int[] color = new int[4];   //H、S、C、D 红黑梅方

         for(int i=0; i<5; i++){
             String[] input = sc.nextLine().split(" ");
             int num;
             switch (input[0]){
                 case "A":
                     num = 1;
                     break;
                 case "J":
                     num = 11;
                     break;
                 case "Q":
                     num = 12;
                     break;
                 case "K":
                     num = 13;
                     break;
                 default:
                     num = Integer.valueOf(input[0]);
             }
             map.put( num, map.getOrDefault( num, 0) + 1);
             numList.add(num);
             String hs = input[1];
             if(hs.equals("H")){
                 color[0]++;
             }else if(hs.equals("S")){
                 color[1]++;
             }else if(hs.equals("C")){
                 color[2]++;
             }else {
                 color[3]++;
             }
         }
         boolean isTongHua = false;
         if(color[1]==5 || color[1]==5 || color[2]==5 || color[3]==5){   //只要其中一个花色有5张为同花
             isTongHua = true;
         }
         int res=7;
         if(map.size() == 5){
             Collections.sort(numList);  //排序方便判断顺子
             boolean isShunZi = isShunzi(numList);
             if(isShunZi){
                 res = isTongHua ? 1 : 5;
             }else {
                 res = isTongHua ? 4 : 7;
             }
         }else {
             for (Map.Entry<Integer,Integer> m:map.entrySet()
                 ) {
                 if(m.getValue() == 4){  //有四条一样的
                     res = 2;
                     break;
                 }else if(m.getValue() == 3){    //有三条一样的
                     res = map.size()==2 ? 3 : 6;    //如果只有牌面只有两个数字则是三带二，否则三带两单
                     break;
                 }
             }
         }
         System.out.println(res);
     }
    public static Boolean isShunzi(List<Integer> list){
        boolean b = true;
        int index=1;
        boolean isA = false;

        if(list.get(0)==1 && list.get(1)!=2){   //如果第一张为A，且第二张不为2
            index = 2;
            isA = true;
        }
        for(int i=index; i<5; i++){
            if(list.get(i)!=list.get(i-1)+1){
                b = false;
                break;
            }
            if(i==4 && isA && list.get(4)!=13){
                b = false;
            }
        }
        return b;
    }


}
