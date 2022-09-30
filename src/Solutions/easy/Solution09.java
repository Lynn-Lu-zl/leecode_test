package Solutions.easy;

public class Solution09 {

    /**
     * 判断整数回文数
     * 同回文子串一样的原理
     * 字符串只要两边对称即为回文数
     * 但对于数字而言实际就是反转后的数和反转前的数一样即为回文数
     * 如1221反转后仍是1221，奇数也是12321，中心点3是不会变得
     *
     * x=1221 res=0
     * x=1221 1221%10=1     res=0 * 10 + 1=1--》x/10=122
     * x=122 122%10=2     res=1 * 10 + 2=12--》x/10=12
     * x=12 12%10=2     res=12 * 10 + 2=122--》x/10=1
     * x=1 1%10=1     res=122 * 10 + 1=1221--》x/10=0
     *
     * 得到反转后的数字还是1221，返回true
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        int res = x;
        //x为负数，肯定不对称；x的最后一个数字是0说明第一个数字也要是0不可能的，两个特殊情况都返回false
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while (x > 0) {
            //取余
            int temp = x % 10;
            revertedNumber = revertedNumber * 10 + temp;
            //去除末尾，进入下一次循环，直到x=0退出循环
            x /= 10;
        }
        //不能用x去比较了在循环中x已经变成0了，所以一开始就找个res把x存储起来，然后到最后比较res和反转后的数作比较看是不是一样
        return res == revertedNumber ;
    }


     public static void main(String[] args) {
         Solution09 solution09 = new Solution09();
         int x=121;
         System.out.println(solution09.isPalindrome(x));
     }
}
