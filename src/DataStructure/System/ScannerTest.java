package DataStructure;

import java.util.Scanner;

/**Scanner
 * import  java.util.Scanner;
 * 获取用户控制台所输入的数据
 * 控制台输入输出的常用方法：
 * nextInt()、nextFloat()、nextDouble()：用于输入 int、float和double类型
 * next()、nextLine()：以空格作为分隔符 将分隔后的内容赋值给变量 以换行符作为结束符
 *
 * nextXxx():输入一个基本类型
 * 只读取输入直到空格
 * 其中Xxx表示所要输入的数据的类型，比如Int、Long、Double…等基本数据类型
 * nextlnt()：只读取int值，就是只能读取整数类型的数据，如果输入了非整型的数据（浮点型字符串等）就会报错
 *
 * next()：
 * 输入一个字符：scanner.next().charAt(0);
 * 回车为结束符，空格为分隔符，将分隔后的内容赋值给变量,对有效字符有空格，空格之后自动去掉
 * 会按空格分隔用户的输入 按顺序依次将字符串复制给变量 对于没有变量赋值的 则舍弃
 *
 *
 * nextLine():输入一行字符串
 * 以回车作为结束符，不以空格做分隔，可以空白,将用户输入的一行直接返回
 * 没有按空格将用户的输入进行分隔 而是直接输入全部赋值给了字符串

 1.next() 方法 在缓冲区中遇到 空格、回车符等空白字符时 会将空白字符前的数据读取走，但空白符不会被处理掉，依然留在缓冲区中。
 2.nextLine() 方法 在缓冲区中读取一行数据 这行数据以回车符为结束标志，nextLine会把包括回车符在内的数据全部提走 缓冲区不会有回车符残留。
 *
 * hasNextXxx()：是否还有下一个输入项
 * 通过使用Scanner类的next()与nextLine()方法获取输入的字符串，
 * 在读取之前一般需要使用hasNext()与hasNextLine()进行判断是否还有输入的数据
 *
 * close():
 * Scanner属于IO流的类如果不关闭会一直占用资源，要养成好习惯用完就关掉使用
 */
public class ScannerTest {
     public static void main(String[] args) {
         //1、创建一个对象来接收键盘的输入，in 输入
         Scanner scanner = new Scanner(System.in);
         //2、判断用户有没有输入，以及用next的方式进行接收
         //回车为结束符，空格为分隔符，将分隔后的内容赋值给变量,对有效字符有空格，空格之后自动去掉。
         //输入uuuuu iii aaa--》输出的内容为：uuuuu
         // scanner.next();
         // scanner.nextDouble();
         //以回车作为结束符，不以空格做分隔，可以空白,将用户输入的一行直接返回
         // scanner.nextLine();
         // scanner.hasNext();

         /**
          * 请输入数据：
          * uuuuu iii aaa
          * 输出的内容为：uuuuu
          * 输出的内容为：iii
          *
          * next方法会按空格分隔用户的输入 按顺序依次将字符串复制给变量 对于没有变量赋值的 aaa 则舍弃
          */
         // System.out.println("请输入数据：");
         // //输入的保存在str中
         // String str = scanner.next();
         // //String str =scanner.nextLine();
         // System.out.println("输出的内容为："+str);
         // str = scanner.next();
         // System.out.println("输出的内容为："+str);

         System.out.println("----------------");


         /**
          * 请输入数据：
          * uuuuu iii aaa
          * 输出的内容为：uuuuu iii aaa
          *
          * 没有按空格将用户的输入进行分隔 而是直接输入全部赋值给了字符串
          */
         System.out.println("请输入数据：");
         //输入的保存在str中
         String str =scanner.nextLine();
         System.out.println("输出的内容为："+str);

         //Scanner属于IO流的类如果不关闭会一直占用资源，要养成好习惯用完就关掉使用
         scanner.close();

     }
}
