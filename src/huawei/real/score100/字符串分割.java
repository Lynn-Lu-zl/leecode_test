package huawei.real.score100;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
 * 输入描述:
 * 输入为两行，第一行为参数K，第二行为字符串S。
 * 输出描述:
 * 输出转换后的字符串。
 * 示例1
 * 输入
 * 3
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abc-ABC-4aB-@
 * 说明
 * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每3个字符一组为abC、ABc、4aB、@，abC中小写字母较多，转换为abc，ABc中大写字母较多，转换为ABC，4aB中大小写字母都为1个，不做转换，@中没有字母，连起来即12abc-abc-ABC-4aB-@
 * 示例2
 * 输入
 * 12
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abCABc4aB@
 * 说明
 * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每12个字符一组为abCABc4aB@，这个子串中大小写字母都为4个，不做转换，连起来即12abc-abCABc4aB@
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124558394
 */
public class 字符串分割 {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int count = Integer.parseInt(sc.nextLine());
    //     String[] split = sc.nextLine().split("-");
    //     List<String> listStr = new ArrayList<>();
    //     StringBuilder temp = new StringBuilder();
    //     for (int i = 1; i < split.length; i++) {
    //         temp.append(split[i]);
    //     }
    //     String tem = temp.toString();
    //     while (tem.length()>0){
    //         if (tem.length() >= count){//截取
    //             listStr.add(tem.substring(0,count));
    //             tem = tem.substring(count);
    //         }else {
    //             listStr.add(tem);
    //             tem = "";
    //         }
    //     }
    //     StringBuilder sb= new StringBuilder();
    //     sb.append(split[0]).append("-");
    //     for (int i = 0; i < listStr.size(); i++) {
    //         String s1 = listStr.get(i);
    //         sb.append(reBalance(s1)).append("-");
    //     }
    //     sb.deleteCharAt(sb.length() -1 );
    //     System.out.println(sb);
    // }
    // private static String reBalance(String str){
    //     int xiao = 0;
    //     int da = 0;
    //     for (int i = 0; i < str.length(); i++) {
    //         char ch = str.charAt(i);
    //         if (ch>= 'a' && ch<= 'z'){
    //             xiao++;
    //         }else if (ch >= 'A' && ch <= 'Z'){
    //             da++;
    //         }
    //     }
    //     if (xiao > da ){
    //         return str.toLowerCase();
    //     }else if (da > xiao){
    //         return str.toUpperCase();
    //     }else {
    //         return str;
    //     }
    // }


    public static void main(String[] args) {
        //字符串分割 给定一个非空字符串S
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int k = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine();
            int index = line.indexOf("-");
            // 第一个子串
            String first = line.substring(0, index);
            String replace = line.substring(index + 1)
                .replaceAll("-", "");
            // 存储新生成的字符串
            List<String> list = new ArrayList<>();
            list.add(first);
            while (replace.length() >= k) {
                String sub = replace.substring(0, k);
                sub = convert(sub);
                list.add(sub);
                replace = replace.substring(k); }
            if (replace.length() > 0) {
                list.add(convert(replace)); }
            System.out.println(String.join("-",list));}
    }
    private static String convert(String sub) {
        // 统计小写字母个数
        int lowCount = 0;
        // 统计大写字母个数
        int upperCount = 0;
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            if (Character.isLowerCase(c)) {
                lowCount++;
            } else if (Character.isUpperCase(c)) {
                upperCount++; } }
        if (lowCount > upperCount) {
            sub = sub.toLowerCase(Locale.ROOT);
        } else if (lowCount < upperCount) {
            sub = sub.toUpperCase(Locale.ROOT); }
        return sub; }


}
