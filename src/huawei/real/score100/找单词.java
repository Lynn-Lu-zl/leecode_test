package huawei.real.score100;

import java.util.Scanner;

/**
 * 标题：找单词 | 时间限制：1秒 | 内存限制：32768K | 语言限制：不限
 * 给一个字符串和一个二维字符数组，如果该字符串存在于该数组中，则按字符串的字符顺序输出字符串每个字符所在单元格的位置下标字符串，如果找不到返回字符串"N"。
 * <p>
 * 1.需要按照字符串的字符组成顺序搜索，且搜索到的位置必须是相邻单元格，其中“相邻单元格”是指那些水平相邻或垂直相邻的单元格。
 * 2.同一个单元格内的字母不允许被重复使用。
 * 3.假定在数组中最多只存在一个可能的匹配。
 * <p>
 * 输入描述:
 * 1.第1行为一个数字（N）指示二维数组在后续输入所占的行数。
 * <p>
 * 2.第2行到第N+1行输入为一个二维大写字符数组，每行字符用半角,分割。
 * <p>
 * 3.第N+2行为待查找的字符串，由大写字符组成。
 * <p>
 * 4.二维数组的大小为N*N，0<N<=100。
 * <p>
 * 5.单词长度K，0<K<1000。
 * 输出描述:
 * 输出一个位置下标字符串，拼接格式为：第1个字符行下标+","+第1个字符列下标+","+第2个字符行下标+","+第2个字符列下标...+","+第N个字符行下标+","+第N个字符列下标
 * 示例1
 * 输入
 * 4
 * A,C,C,F
 * C,D,E,D
 * B,E,S,S
 * F,E,C,A
 * ACCESS
 * 输出
 * 0,0,0,1,0,2,1,2,2,2,2,3
 * 说明
 * ACCESS分别对应二维数组的[0,0]  [0,1] [0,2] [1,2] [2,2] [2,3]下标位置
 *
 * @since 2022年5月1日
 */
public class 找单词 {
    public static void main(String[] args) {
        //找单词，给一个字符串和一个二维字符数组
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); // 二维数组在后续输入所占的行数
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] strs = scanner.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                chars[i][j] = strs[j].charAt(0); } }
        char[] ks = scanner.nextLine().toCharArray();// 待查找的字符串
//        System.out.println(chars);
        StringBuilder sb = new StringBuilder();
        if (findWord(chars, ks, 0, 0, 0, sb)) {
            System.out.println(sb.reverse().substring(1));
        } else {
            System.out.println("N"); } }
    public static boolean findWord(char[][] chars, char[] k, int le, int ri, int index, StringBuilder sb){
        if (index >= k.length) return true; // 如果达到给定字符串的长度就结束
        if (le < 0 || le >= chars.length || ri < 0 || ri >= chars.length || chars[le][ri] != k[index]){
            return false; }
        chars[le][ri] += 300;
        // 上下左右寻找 递归
        index++;
        if (findWord(chars, k, le - 1, ri, index, sb) ||
            findWord(chars, k, le + 1, ri, index, sb) ||
            findWord(chars, k, le, ri - 1, index, sb) ||
            findWord(chars, k, le, ri + 1, index, sb)) {
            sb.append(ri).append(",").append(le).append(",");
            return true; }
        chars[le][ri] -= 300;
        return false;}


}
