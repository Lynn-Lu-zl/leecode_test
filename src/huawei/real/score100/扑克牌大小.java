package huawei.real.score100;

import java.util.Scanner;

/** 牛客原题 有人考过
 * 题目描述
 * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A，2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）:)
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如：4 4 4 4-joker JOKER
 * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR
 *
 * 基本规则：
 * （1）输入每手牌可能是个子，对子，顺子（连续5张），三个，炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）
 * （3）大小规则跟大家平时了解的常见规则相同，个子，对子，三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 * （4）输入的两手牌不会出现相等的情况。
 *
 * 答案提示：
 * （1）除了炸弹和对王之外，其他必须同类型比较。
 * （2）输入已经保证合法性，不用检查输入是否是合法的牌。
 * （3）输入的顺子已经经过从小到大排序，因此不用再排序了.
 *
 * 输入描述:
 * 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如4 4 4 4-joker JOKER。
 *
 *
 * 输出描述:
 * 输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，仍以空格隔开；如果不存在比较关系则输出ERROR。
 *
 * 输入例子:
 * 4 4 4 4-joker JOKER
 *
 * 输出例子:
 * joker JOKER
 *
 * 输入：
 * 3 4 5 6 7-8 9 10 J Q
 * 输出：
 * 8 9 10 J Q
 *
 * 输入：
 * A-JOKER
 * 输出：
 * JOKER
 *
 * 输入：
 * 4 4 4 4-2 2 2
 * 输出：
 * 4 4 4 4
 *
 * 分析：把输入分成两个字符串，由于扑克牌里的字符比较比较混乱，我直接把数据处理了一下存到了vector里，然后再分情况比较，如果有一方为大小王，那肯定是大小王大，如果有一方有炸弹，那就要分另一方是不是也是炸弹，是炸弹就要比较大小，不是的话肯定是炸弹大。剩余的情况只要比较vector中第一个数哪个比较大就可以了，当然前提是两者是可以比较的也就是vector的size相同。

 */
public class 扑克牌大小 {
    /**
     * 输入两手牌，请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR
     * @param args
     */
     public static void main(String[] args) {

         //扑克牌大小,4 4 4 4-joker JOKER
         Scanner sc = new Scanner(System.in);
         while (sc.hasNext()) {
             // 1. 排除掉王炸的情况
             String oriStr = sc.nextLine();// 读入原始字符串，找joker JOKER
             if ( oriStr.indexOf("joker JOKER") != -1 ){
                 System.out.println("joker JOKER");
                 continue; }
             // 2. 排除掉两手牌长度不等的情况：
             // 要么一手4炸一手普通牌，要么两手普通牌但是牌型不符要ERROR
             String[] card1 = oriStr.split("-")[0].split(" ");
             String[] card2 = oriStr.split("-")[1].split(" ");
             if ( card1.length != card2.length ) {// 检查有没有一手牌的长度为4
                 String[] pointer = card1.length==4 ? card1: null ;
                 pointer = card2.length==4 ? card2 : pointer ;
                 if ( pointer==null ){  // 长度不等，且没有4炸，必然ERROR
                     System.out.println("ERROR");}
                 else                    // 有4炸则输出4炸
                     System.out.println(String.join(" ",pointer));
                 continue; }
             // 3. 只剩下两手普通牌和两手4炸的情况，只需要比较第一张牌
             String order = "345678910JQKA2jokerJOKER";
             if ( order.indexOf(card1[0]) < order.indexOf(card2[0]))
                 System.out.println(String.join(" ",card2));
             else
                 System.out.println(String.join(" ",card1));}



         }
}
