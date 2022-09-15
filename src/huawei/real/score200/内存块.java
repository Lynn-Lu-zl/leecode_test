package huawei.real.score200;

import java.util.Scanner;

/**
 *
 * 模拟一个连续的内存块，其大小固定为100字节：
 *  - 1.用户输入"REQUEST=10"表示从内存中分配一个连续的大小为10字节的空间，当分配成功时，输出内存区块的首地址，分配失败(内存空间不足)时输出"error"
 * - 2.用户输入“RELEASE=0”,表示释放首地址为0所对应的区块，如果不存在相应区块，则输出“error”,反之不输出
 */
public class 内存块 {

    public static void main(String[] args) {
        //模拟一个连续的内存块，其大小固定为100字节：
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(100);
        //a 空 b为头 c为体
        for(int i=0;i<100;i++) {
            str.append('a');
        }
        do {
            String input = sc.next();
            if(input.equals("000")) {
                break;
            }
            int num = Integer.parseInt(input.substring(8));
            int boo = input.substring(0, 7).equals("REQUEST")?1:0;//1代表存 0代表释放
            System.out.println(Solution(num, boo, str));
            for(int i=0;i<100;i++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }while(true);
    }
    public static String Solution(int num,int boo,StringBuilder str) {
        if(boo==1) {//分配空间
            if(num==1) {
                int a = str.indexOf("a");
                str.setCharAt(a, 'b');
                return ""+a;
            }else {
                StringBuilder a = new StringBuilder("b");
                StringBuilder b = new StringBuilder("a");
                for(int i=0;i<num-1;i++) {
                    a.append('c');
                    b.append('a');
                }
                int c=str.indexOf(b.toString());
                if(c!=-1) {
                    str.replace(c, c+num, a.toString());
                    return ""+c;
                }else {
                    return "error";
                }
            }
        }else {//释放空间
            if(str.charAt(num)=='b') {
                int count = 1;
                for(int i=num+1;i<=99 && str.charAt(i)=='c';i++) {
                    count++;
                }
                for(int i=num;i<(num+count);i++) {
                    str.setCharAt(i, 'a');
                }
                return "";
            }else {
                return "error";
            }
        }
    }
}
