package Solutions.middle;

import java.util.ArrayList;

/**6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *  
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution06 {

    /**
     * 画图可看懂
     * 0  P   A   H   N
     * 1  A P L S I I G
     * 2  Y   I   R
     *
     * 当前行从0开始遍历--》将P追加到list索引值为0的集合中，P是顶部--》toDown为true，当前行+1遍历--》
     * 当前行=1此时元素为A-->将A追加到list索引值为1的集合中，A不是顶部--》toDown不用取反仍然为true，当前行+1遍历--》
     * 当前行=2此时元素为Y-->将Y追加到list索引值为2的集合中，Y是底部--》toDown用取反为false，当前行-1遍历--》
     * 当前行=1此时元素为P-->将P追加到list索引值为1的集合中(此时list索引为1的共有元素：AP)，Y是底部--》toDown用取反为false，当前行-1遍历--》.....
     *
     * 完成后再将list集合中的所有存储行按索引从0开始的顺序遍历追加到新的StringBuilder中，返回StringBuilder
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {

        ArrayList<StringBuilder> list = new ArrayList<>();
        //只有一行就直接返回，搞不来z字
        if ( numRows == 1){
            return s;
        }
        //定义list集合的存储行数-->遍历根据输入变换的行数numRows=3，存储list的索引,012
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        //当前行初始化，从第0行开始
        int curRow=0;
        //判断是否到顶部/底部，如果为true说明是z字的转折点，需要改变当前行
        boolean toDown = false;

        //开始遍历字符串，对字符串进行z字变换并存在索引值相同的行内
        for (int i = 0; i < s.length(); i++) {
            //从当前行的最后一个字符开始追加
            list.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows-1) {
                //到顶部/底部才取反，不是每遍历一次就取反一次
                toDown = !toDown;
            }
            //toDown为true说明到顶/底部，当前行+1
            //toDown为true说明到中间，当前行-1
            curRow += toDown ? 1:-1;

        }

        //以索引值为0的第一行字符串，将其他存储行的值都追加到索引值为0的这一行
        //追加的索引值i从1开始，因为是追加到索引值为0的后面
        for (int i = 1; i < numRows; i++) {
            list.get(0).append(list.get(i));
        }
        //直接返回全部字符串都追加到的这一行
        return list.get(0).toString();


        //也可以新建一个stringbuilder然后将所以存储行的字符串都存到里面，但是会增加空间复杂度
        // StringBuilder builder = new StringBuilder();
        // for (int i = 0; i < numRows; i++) {
        //     builder.append(list.get(i));
        // }
        // //直接返回全部字符串都追加到的这一行
        // return builder.toString();

    }

     public static void main(String[] args) {

         Solution06 solution06 = new Solution06();
         String s ="PAYPALISHIRING";
         int numRows = 3;
         System.out.println(solution06.convert(s,numRows));

     }
}
