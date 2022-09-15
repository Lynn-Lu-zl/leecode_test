package huawei.real.score200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**https://f.daixianiu.cn/csdn/7051261331369851.html
 * 斗地主起源于湖北十堰房县，据传是一位叫吴修全的年轻人根据当地流行的扑克玩法“跑得快”改编的，如今已风靡整个中国，并流行于互联网上。
 *
 * 牌型:
 *
 * 单顺, 又称顺子，最少5张牌，最多12张牌（3⋯A），不能有2，也不能有大小王，不计花色
 *
 * 例如：3-4-5-6-7-8，7-8-9-10-J-Q，3-4-5-6-7-8-9-10-J-Q-K-A
 *
 * 可用的牌 3<4<5<6<7<8<9<10<J<Q<K<A<2 < B(小王)< C(大王)，每种牌除大小王外有4种花色(共有 13X4 + 2 张牌)
 *
 * 输入1. 手上已有的牌 2. 已经出过的牌（包括对手出的和自己出的牌）
 *
 * 输出: 对手可能构成的最长的顺子(如果有相同长度的顺子, 输出牌面最大的那一个)，如果无法构成顺子, 则输出 NO-CHAIN
 *
 * 输入描述:
 *
 * 输入的第一行为当前手中的牌
 *
 * 输入的第二行为已经出过的牌
 *
 * 输出描述:
 *
 * 最长的顺子
 *
 * 示例1
 * 输入
 *
 * 3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A
 *
 * 4-5-6-7-8-8-8
 *
 * 输出
 *
 * 9-10-J-Q-K-A
 *
 * 示例2
 * 输入
 *
 * 3-3-3-3-8-8-8-8
 *
 * K-K-K-K
 *
 * 输出
 *
 * NO-CHAIN
 *
 * 说明
 *
 * 剩余的牌无法构成顺子
 *
 * 解题思路：
 * 1、根据手上的牌和出过的牌，找出已经出完的牌（已出现四次的牌）
 *
 * 2、初始化一个完整牌序的集合3-A（2不进行顺子），再剔除步骤1已出完的牌，得到对手手上存在的牌
 *
 * 3、根据顺子的规则找出步骤2中最长的顺子
 */
public class 最长的顺子 {
    public static void main(String[] args) {
        //最长的顺子、跑得快
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split("-");
        String[] str2 = sc.nextLine().split("-");
        int len1 = str1.length;
        int len2 = str2.length;
        HashMap<String,Integer> map = new HashMap<>();  //当前手中的牌和出过的牌的键值对
        for(int i=0;i<len1;i++){
            map.put(str1[i],map.getOrDefault(str1[i],0)+1);
        }
        for(int i=0;i<len2;i++){
            map.put(str2[i],map.getOrDefault(str2[i],0)+1);
        }
        List<Integer> list = new ArrayList<>(); //对手的牌（除去2）
        List<Integer> listFour = new ArrayList<>(); //已经出了4张的牌
        for(int i=3;i<=14;i++){
            list.add(i);
        }
        map.forEach((k,v)->{
            if(v==4){
                int n;
                switch (k){
                    case "J":
                        n=11;
                        break;
                    case "Q":
                        n=12;
                        break;
                    case "K":
                        n=13;
                        break;
                    case "A":
                        n=14;
                        break;
                    default:
                        n=Integer.valueOf(k);
                }
                listFour.add(n);
            }
        });

        for(int i=0;i<listFour.size();i++){ //剔除已经出过四张的牌
            for(int j=0;j<list.size();j++){
                if(listFour.get(i) == list.get(j)){
                    list.remove(j);
                }
            }
        }
        List<Integer> res = new ArrayList<>();  //最长顺子
        List<Integer> temp = new ArrayList<>(); //顺子容器，用来判断是否是顺子，是否是最长的顺子
        int count = 1;  //连续牌的个数
        int max = 0;    //最长顺子长度
        temp.add(list.get(0));
        for (int i=1;i<list.size();i++){
            if(list.get(i)-list.get(i-1)==1){
                temp.add(list.get(i));
                count++;
                if(i==list.size()-1 && count>=5 && count==Math.max(max,count)){ //最后一张牌也需要进行判断
                    res = temp;
                }
            }else {
                if(count>=5 && count==Math.max(max,count)){
                    res = temp;
                }
                temp.clear();   //容器置空
                temp.add(list.get(i));
                count=1;
            }
        }
        if(res.size()==0){
            System.out.println("NO-CHAIN");
        }else {
            String s = "";
            for(int i=0;i<res.size();i++){
                int n = res.get(i);
                switch (n){
                    case 11:
                        s += "J";
                        break;
                    case 12:
                        s += "Q";
                        break;
                    case 13:
                        s += "K";
                        break;
                    case 14:
                        s += "A";
                        break;
                    default:
                        s += String.valueOf(n);
                }
                if(i!=res.size()-1){
                    s+="-";
                }
            }
            System.out.println(s);
        }
    }
}
