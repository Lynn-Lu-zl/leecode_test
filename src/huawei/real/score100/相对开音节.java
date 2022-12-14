package huawei.real.score100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 相对开音节构成的结构为辅音+元音（aeiou）+辅音(r除外)+e，常见的单词有bike、cake等。
 * 给定一个字符串，以空格为分隔符，反转每个单词中的字母，若单词中包含如数字等其他非字母时不进行反转。
 * 反转后计算其中含有相对开音节结构的子串个数（连续的子串中部分字符可以重复）。
 * 输入描述:
 * 字符串，以空格分割的多个单词，字符串长度<10000，字母只考虑小写
 * 输出描述:
 * 含有相对开音节结构的子串个数，注：个数<10000
 * 示例1
 * 输入
 * ekam a ekac
 * 输出
 * 2
 * 说明
 * 反转后为 make a cake 其中make、cake为相对开音节子串，返回2
 * 示例2
 * 输入
 * !ekam a ekekac
 * 输出
 * 2
 * 说明
 * 反转后为!ekam a cakeke 因!ekam含非英文字符所以未反转，其中 cake、keke为相对开音节子串，返回2
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124544351
 */
public class 相对开音节 {
    // public static void main(String[] args) {
    //     Scanner sc =new Scanner(System.in);
    //     String[] input = sc.nextLine().split(" ");
    //     int total = 0;
    //     for (int i = 0; i < input.length; i++) {
    //         String content = input[i];
    //         boolean flag = true;
    //         for (int j = 0; j < content.length(); j++) {
    //             if (content.charAt(j) < 'a' ||  content.charAt(j)> 'z'){
    //                 flag = false;
    //                 break;
    //             }
    //         }
    //         if (flag){
    //             total += checkKai(content);
    //         }
    //     }
    //     System.out.println(total);
    // }
    //
    // private static int checkKai(String str){
    //     String strTemp = "";
    //     for (int i = str.length()-1; i >=0 ; i--) {
    //         strTemp += str.charAt(i);
    //     }
    //
    //     int left = 0;
    //     int right = 0;
    //     int total = 0;
    //     String tem = "";
    //     while (right<=str.length()){
    //         tem = strTemp.substring(left,right);
    //         if (tem.length() < 4 ){
    //             right++;
    //             continue;
    //         }
    //         if (checkTrue(tem)) {
    //             total++;
    //         }
    //         left++;
    //         right++;
    //
    //     }
    //     return total;
    // }
    //
    // private static boolean checkTrue(String str){
    //     //辅音+元音（aeiou）+辅音(r除外)+e blame
    //     if (!yuanyin.contains(str.charAt(0)) && 'e' == str.charAt(str.length()-1)){//首位是辅音 末尾是元音
    //         int temYuan = 0;
    //         for (int i = 1; i < str.length()-1; i++) {//中间2位或3位
    //             if (yuanyin.contains(str.charAt(i))){
    //                 temYuan = i;
    //             }
    //             if (temYuan!= 0 && !yuanyin.contains(str.charAt(i)) && str.charAt(i) != 'r' && i> temYuan){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    //
    // private static List<Character> yuanyin = new ArrayList<>();
    // static {
    //     char[] f1 = {'a','e','i','o','u'};
    //     for (int i = 0; i < f1.length; i++) {
    //         yuanyin.add(f1[i]);
    //     }
    // }


    /**
     * 法2
     */

     public static void main(String[] args) {
         //相对开音节，辅音+元音（aeiou）+辅音(r除外)+e
         Scanner in = new Scanner(System.in);
         String line = in.nextLine();
         String[] words = line.split(" ");
         int count = 0;
         for (String word : words) {
             char[] chars = word.toCharArray();
             if (word.replaceAll("[a-z]+","").isEmpty()){
                 for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
                     char tmp = chars[i];
                     chars[i] = chars[j];
                     chars[j] = tmp; } }
             if (chars.length < 4) continue;
             for (int i = 0; i < chars.length - 3; i++) {
                 if (!isVowel(chars[i])
                     && isVowel(chars[i + 1])
                     && !isVowel(chars[i + 2]) && chars[i + 2] != 'r'
                     && chars[i + 3] == 'e') {
                     count++; } } }
         System.out.println(count); }
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i'
            || c == 'o' || c == 'u'; }


}
