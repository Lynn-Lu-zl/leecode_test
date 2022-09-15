package huawei.real.score100;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 标题：敏感字段加密 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 * 【敏感字段加密】给定一个由多个命令字组成的命令字符串：
 * 1、字符串长度小于等于127字节，只包含大小写字母，数字，下划线和偶数个双引号；
 * 2、命令字之间以一个或多个下划线_进行分割；
 * 3、可以通过两个双引号""来标识包含下划线_的命令字或空命令字（仅包含两个双引号的命令字），双引号不会在命令字内部出现；
 * 请对指定索引的敏感字段进行加密，替换为******（6个*），并删除命令字前后多余的下划线_。如果无法找到指定索引的命令字，输出字符串ERROR。
 * <p>
 * 输入描述:
 * 输入为两行，第一行为命令字索引K（从0开始），第二行为命令字符串S。
 * 输出描述:
 * 输出处理后的命令字符串，如果无法找到指定索引的命令字，输出字符串ERROR
 * 示例1
 * 输入
 * 1
 * password__a12345678_timeout_100
 * 输出
 * password_******_timeout_100
 * 示例2
 * 输入
 * 2
 * aaa_password_"a12_45678"_timeout__100_""_
 * 输出
 * aaa_password_******_timeout_100_""
 */
public class 敏感字段加密 {
    public static void main(String[] args) {

        //敏感字段加密,password__a12345678_timeout_100
        Scanner scanner = new Scanner(System.in);
        int K = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        ArrayList<Integer> int_shuang_ying_hao = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '"'){
                int_shuang_ying_hao.add(i); } }
        if (int_shuang_ying_hao.size() == 0) {
            int_shuang_ying_hao.add(chars.length);
            int_shuang_ying_hao.add(chars.length + 1); }
        ArrayList<String> strings = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < int_shuang_ying_hao.size() - 1; i++) {
            int le = int_shuang_ying_hao.get(i);
            int ri = int_shuang_ying_hao.get(i + 1);
            StringBuilder sb = new StringBuilder();
            if (le > left) {
                for (int j = left; j < le; j++) {
                    if (chars[j] != '_') {
                        sb.append(chars[j]);
                    } else {
                        if (sb.length() != 0) {
                            strings.add(sb.toString());
                            sb.setLength(0); } } } }
            for (int j = le + 1; j < ri; j++) {
                sb.append(chars[j]); }
            strings.add(sb.toString());
            sb.setLength(0);
            if (i == int_shuang_ying_hao.size()-2&&ri<chars.length-1){
                for (int j = ri + 1; j < chars.length; j++) {
                    if (chars[j] != '_'){
                        sb.append(chars[j]);
                    } else {
                        if (sb.length() != 0) {
                            strings.add(sb.toString());
                            sb.setLength(0); } } } }
            left = ri + 1;
            i++; }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < strings.size(); i++) {
            if (i == 0) {
                sb.append(strings.get(i));
                continue; }
            if (i == K) {
                sb.append("_").append("******");
                flag = true;
                continue; }
            sb.append("_")
              .append("".equals(strings.get(i)) ? "\"\"":strings.get(i));}
        System.out.println(flag ? sb : "ERROR");


    }
}
