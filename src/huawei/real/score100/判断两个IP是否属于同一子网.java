package huawei.real.score100;

import java.util.Scanner;

/**
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 * 转化为二进制进行运算：
 * I P 地址　 11000000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 * AND运算 11000000.10101000.00000000.00000000
 * 转化为十进制后为：
 * 192.168.0.0
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 * 转化为二进制进行运算：
 * I P 地址　11000000.10101000.00000000.11111110
 * 子网掩码 11111111.11111111.11111111.00000000
 * AND运算 11000000.10101000.00000000.00000000
 * 转化为十进制后为：
 * 192.168.0.0
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络
 * 注:
 * 有效掩码与IP的性质为：
 * 1 掩码与IP每一段在 0 - 255 之间
 * 2 掩码的二进制字符串前缀为网络号，都由‘1’组成；后缀为主机号，都由’0’组成
 * 本题有多组输入
 *
 * 输入描述
 * 多组输入，一组3行，第1行是输入子网掩码、第2，3行是输入两个ip地址
 * 输出描述：
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2
 *
 * 实例：
 *
 * 输入
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 255.255.255.0
 * 192.168.0.254
 * 192.168.0.1
 * 1
 * 2
 * 0
 * 说明：
 * 对于第一个例子:
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 其中IP:192.168.224.256不合法，输出1
 * 对于第二个例子:
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 2个与运算之后，不在同一个子网，输出2
 * 对于第三个例子，2个与运算之后，如题目描述所示，在同一个子网，输出0
 * ————————————————
 * 版权声明：本文为CSDN博主「chenzm666666」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/m0_46084322/article/details/122155205
 */
public class 判断两个IP是否属于同一子网 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ipLine = sc.nextLine();
            String mask1Line = sc.nextLine();
            String mask2Line = sc.nextLine();
            // 将输入行转换为int数组
            int[] ipArr = intArray(ipLine);
            int[] mask1Arr = intArray(mask1Line);
            int[] mask2Arr = intArray(mask2Line);
            // 检查输入
            boolean result1 = checkIp(ipArr);
            boolean result2 = checkMask(mask1Arr);
            boolean result3 = checkMask(mask2Arr);
            // 输入正确
            if (result1 && result2 && result3) {
                // 将ip 掩码1 掩码2 转换为32为二进制数（倒叙，与顺序无关，主要用于比较）
                StringBuilder builder1 = convertToBinary1(ipArr);
                StringBuilder builder2 = convertToBinary1(mask1Arr);
                StringBuilder builder3 = convertToBinary1(mask2Arr);

                // 比较ip与掩码1 掩码2
                compareIpAndMask1(builder1, builder2, builder3);
            } else { // 输入的不符合要求
                System.out.println("1");
            }
        }
    }

    // 分割字符串，并转换为int数组
    public static int[] intArray(String str){
        String[] strArr = str.split("\\.");
        int[] intArr = new int[strArr.length];
        for(int i = 0;i<strArr.length;i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    //检查ip地址：IP每一段在 0 - 255 之间，前一段要大于后一段
    public static boolean checkIp(int[] arr){
        for(int i = 0;i<arr.length;i++){
            if(i == arr.length - 1){
                if(arr[i] < 0 || arr[i] > 255){
                    return false;
                }
            }else {
                if(arr[i] < 0 || arr[i] > 255 || arr[i] < arr[i+1]){
                    return false;
                }
            }
        }
        return true;
    }

    //检查掩码地址：掩码每一段在 0 - 255 之间
    public static boolean checkMask(int[] arr){
        for(int i = 0;i<arr.length;i++) {
            if (arr[i] < 0 || arr[i] > 255) {
                return false;
            }
        }
        return true;
    }

    // 转换为二进制数  (正序，调用Integer的toBinaryString方法，将十进制数转为二进制数)
    public static StringBuilder convertToBinary1(int[] arr){
        StringBuilder builder = new StringBuilder();
        int[] binaryArr = new int[arr.length * 8];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            String s = Integer.toBinaryString(arr[i]);
            for(int j = 8;j>s.length();j--){
                builder.append("0");
            }
            builder.append(s);
        }
        return builder;
    }

    // 比较ip与掩码1 掩码2
    public static void compareIpAndMask1(StringBuilder builder1, StringBuilder builder2, StringBuilder builder3){
        // 1 1=1  1 0=0  0 0=0
        String ipAndMask1 = "";
        String ipAndMask2 = "";
        for (int i = 0; i < builder1.length(); i++) {
            if ("1".equals(builder1.substring(i,i+1)) && "1".equals(builder2.substring(i,i+1))) {
                ipAndMask1 += "1";
            } else {
                ipAndMask1 += "0";
            }
            if ("1".equals(builder1.substring(i,i+1)) && "1".equals(builder3.substring(i,i+1))) {
                ipAndMask2 += "1";
            } else {
                ipAndMask2 += "0";
            }
        }
        if (ipAndMask1.equals(ipAndMask2)) {
            System.out.println("0");
        } else {
            System.out.println("2");
        }
    }

}
