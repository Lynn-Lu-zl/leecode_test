package huawei.real.score100;

import java.util.Scanner;

/**
 * 有人考过 1
 *
 * 给定一个URL前缀和URL后缀，通过","分割，需要将其连接为一个完整的URL，如果前缀结尾和后缀开头都没有“/”，需自动补上“/”连接符，如果前缀结尾和后缀开头都为“/”，需自动去重。
 * 约束：不用考虑前后缀URL不合法情况。
 * 输入描述:
 * URL前缀（一个长度小于100的字符串),URL后缀（一个长度小于100的字符串）。
 * 输出描述:
 * 拼接后的URL。
 * 示例1
 * 输入
 * /acm,/bb
 * 输出
 * /acm/bb
 * 示例2
 * 输入
 * /abc/,/bcd
 * 输出
 * /abc/bcd
 * 示例3
 * 输入
 * /acd,bef
 * 输出
 * /acd/bef
 * 示例4
 * 输入
 * ,
 * 输出
 * /
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124516351
 */
public class 拼接URL {

     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         String[] strings = in.nextLine().split(",");
         StringBuilder sb = new StringBuilder();
         if (strings.length == 0) {
             System.out.println("/");
             return;
         }
         sb.append("/");
         sb.append(strings[0]);
         sb.append("/");
         sb.append(strings[1]);
         System.out.println((sb.toString()).replaceAll("/+", "/"));



         // Scanner in = new Scanner(System.in);
         // String[] URL = in.nextLine().split(",");
         // StringBuilder sb = new StringBuilder();
         // if (URL.length == 0) {
         //     System.out.println("/");
         //     return;
         // }
         //
         // if (URL[0].charAt(0) == '/') {  //前缀字符串是'/'开头
         //     if (URL[0].charAt(URL[0].length() - 1) != '/' && URL[1].charAt(0) != '/') {  // 前缀最后一个字符不是'/'，且后缀第一个也不是
         //         sb.append(URL[0]);
         //         sb.append('/');
         //         sb.append(URL[1]);
         //         // 这个判断有问题，不进
         //     } else if (URL[0].charAt(URL[0].length() - 1) == '/' && URL[1].charAt(0) == '/'){ //  前缀最后一个字符是'/'，且后缀第一个也是, 前缀去掉，后缀不变
         //         sb.append(URL[0].substring(0, URL[0].length() - 1));
         //         sb.append(URL[1]);
         //     } else {  // 前缀最后一个字符是'/'，或者后缀第一个是
         //         sb.append(URL[0]);
         //         sb.append(URL[1]);
         //     }
         // } else {
         //     sb.append('/');
         //     if (URL[0].charAt(URL[0].length() - 1) != '/' && URL[1].charAt(0) != '/') {  // 前缀最后一个字符不是'/'，且后缀第一个也不是
         //         sb.append(URL[0]);
         //         sb.append('/');
         //         sb.append(URL[1]);
         //         // 这个判断有问题，不进
         //     } else if (URL[0].charAt(URL[0].length() - 1) == '/' && URL[1].charAt(0) == '/'){ //  前缀最后一个字符是'/'，且后缀第一个也是, 前缀去掉，后缀不变
         //         sb.append(URL[0].substring(0, URL[0].length() - 1));
         //         sb.append(URL[1]);
         //     } else {  // 前缀最后一个字符是'/'，或者后缀第一个是
         //         sb.append(URL[0]);
         //         sb.append(URL[1]);
         //     }
         // }
         // System.out.println(sb.toString());

     }
}
