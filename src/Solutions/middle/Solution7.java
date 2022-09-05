package Solutions.middle;

/**7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution7 {
    public int reverse(int x) {
        int res = 0;
                while(x!=0) {
                    //每次取末尾数字
                    int tmp = x%10;
                    //判断是否 大于 最大32位整数
                    if (res>214748364 || (res==214748364 && tmp>7)) {
                        return 0;
                    }
                    //判断是否 小于 最小32位整数
                    if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                        return 0;
                    }
                    res = res*10 + tmp;
                    x /= 10;
                }
                /**不能这样写，res一旦大于这个数就存不进了更别说比较，我们只能对他取模拿到上一位214748364作比较
                 * 正数：res为214748365X，绝对存不进，所以res>214748364就返回0；res为2147483646可以，res为2147483648不行，所以res==214748364 &&tmp>7就返回0
                 * 负数：res为-214748365X，绝对存不进，所以res<-214748364 ；res为-2147483646可以，res为-2147483649不行，res==-214748364 && tmp<-8返回0
                if (res>2147483647){
                    return 0;
                }*/

                return res;


/**无考虑返回0的情况，溢出问题
 * 要求是反转后的整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，即[-2147483648,2147483647]就返回 0
        int res=0;
        while (x!=0){
            int tmp=x%10;
            res=res*10+tmp;
            x/=10;
        }
     return res;
*/

    }
     public static void main(String[] args) {
         Solution7 solution7 = new Solution7();
         //2147483647
         int i= solution7.reverse(1147483649);
         System.out.println(i);
     }


}
