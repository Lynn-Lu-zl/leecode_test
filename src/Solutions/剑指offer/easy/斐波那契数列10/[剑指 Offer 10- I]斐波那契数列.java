package Solutions.剑指offer.easy.斐波那契数列10;//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 412 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**时间复杂度0(1)
     * 递归的同时把上一次递归的结果存起来--》减少重复的计算否则会超过时间限制
     * @param n
     * @return
     */
    public int fib(int n) {

        if (n <= 1 ){
            return n;
        }

        //因为F(N) = F(N - 1) + F(N - 2)
        //F(N - 2)  F(0)
        int a = 0;
        //F(N - 1)  F(1)
        int b = 1;
        //c指代F(N)
        int c = 0;

        for (int i = 2; i <= n; i++) {
            //准备下一次递归前，先把该层的数存起来--》整体右移一位-->让 a 保存 b，b 保存 c，之后重新计算 c，如此循环
            //c也右移，移完后重新计算a+b
            c = (a + b) % 1000000007;

            //指针右移+1，a的位置移到原来的b上
            a = b;
            //b的位置移到原来c上
            b = c;
        }

        return c;
    }



     public static void main(String[] args) {
         Solution solution = new Solution();
         int fib = solution.fib(2);
         System.out.println(fib);
     }
}
//leetcode submit region end(Prohibit modification and deletion)
