package DataStructure;

/**
 * 质数判断
 *
 * 1，常见方法，直接通过遍历到n的开平法进行整除判断，效率不高。
 *
 * 2，通过标志方法，设置一个bool数组，先进行初始化，奇数设置为true，偶数设置为false，只需将前面为true表示为质数的倍数设置为flase即可，效率较上面高。
 *
 * 3，质数分布的规律：大于等于5的质数一定和6的倍数相邻。例如5和7，11和13,17和19等等；
 * ————————————————
 * 版权声明：本文为CSDN博主「阿联爱学习」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_41593124/article/details/124303169
 */
public class PrimeTest {
    // boolean isPrime( int num ) {
    //     //两个较小数另外处理
    //     if (num == 2 || num == 3)
    //         return true;
    //     //不在6的倍数两侧的一定不是质数
    //     if (num % 6 != 1 && num % 6 != 5)
    //         return false;
    //     //?
    //     int tmp = sqrt(num);
    //     //在6的倍数两侧的也可能不是质数
    //     for (int i = 5; i <= tmp; i += 6)
    //         if (num % i == 0 || num % (i + 2) == 0)
    //             return false;
    //     //排除所有，剩余的是质数
    //     return true;
    // }

     public static void main(String[] args) {

         }
}
