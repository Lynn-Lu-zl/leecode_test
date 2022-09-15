package huawei.real.score100;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/66ca0e28f90c42a196afd78cc9c496ea
 * 来源：牛客网
 *
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 数据范围：保证输入的是合法的 IP 序列
 *
 *
 * 输入描述:
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 *
 *
 * 输出描述:
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 * 示例1
 * 输入
 * 10.0.3.193
 * 167969729
 * 输出
 * 167773121
 * 10.3.3.193
 */
public class 整数与IP地址间的转换 {
    public static void main(String[] args) {
        //整数与IP地址间的转换
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String ip = sc.nextLine();//IP地址字符串  10.0.3.193
            String ip10 = sc.nextLine();//十进制IP地址字符串  167969729
            System.out.println(convertIp10(ip));
            System.out.println(convertIp(ip10));
        }
    }

    //IP地址转10进制字符串
    //IP地址拆分，每段转二进制，二进制字符串转Long
    public static long convertIp10(String ip) {
        String[] ips = ip.split("\\.");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < ips.length; i++) {
            //十进制数转二进制字符串
            sb.append(binaryString(ips[i]));
        }
        return Long.parseLong(sb.toString(), 2);
    }

    //十进制转二进制
    public static String binaryString(String s) {
        StringBuffer sb = new StringBuffer();
        int num = Integer.parseInt(s);
        int k = 1 << 7;
        for(int i = 0; i < 8; i++) {
            int flag = (num&k)==0 ? 0 : 1;
            sb.append(flag);
            num = num << 1;
        }
        return sb.toString();
    }

    //10进制字符串转IP地址
    //按照每段8位进行拆分，每段转10进制，不足32位补位，拼接4段组成IP地址
    public static String convertIp(String ip10) {
        StringBuffer sb = new StringBuffer();
        //长整型转二进制字符串，Long的静态方法
        String ip2 = Long.toBinaryString(Long.parseLong(ip10));
        String as = "";
        if(ip2.length() < 32) {
            //不足32位前面补0
            for(int i = 0; i < 32 - ip2.length(); i++) {
                as += "0";
            }
        }
        ip2 = as + ip2;
        //IP地址每一段进行拼接
        String[] ips = new String[4];
        ips[0] = ip2.substring(0, 8);
        ips[1] = ip2.substring(8, 16);
        ips[2] = ip2.substring(16, 24);
        ips[3] = ip2.substring(24);
        for(int i = 0; i < 4; i++) {
            sb.append(Integer.parseInt(ips[i], 2));
            if(i != 3) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

}
