package Solutions.剑指offer.easy.青蛙跳台阶问题10;//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 328 👎 0


import DataStructure.二叉树.Solution01;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 递归，斐波那契数列类似
     * 但是这次是叠加增量
     * f(7) = f(5)+f(6)
     * 递归公式 f(n) = f(n - 1) + f(n - 2);
     *
     * 如n=3时
     * 1 2 3、 1 3，两种跳法
     *
     * n=4时
     * 1 2 4
     * 1 3 4
     * 1 2 3 4
     * @param n
     * @return
     */
    public int numWays(int n) {

        //题目例子，n = 0时输出1
        if (n <= 1 ){
            return 1;
        }

        //因为F(N) = F(N - 1) + F(N - 2)
        //从1开始
        int a = 1;
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
         System.out.println(solution.numWays(7));
     }
}
//leetcode submit region end(Prohibit modification and deletion)
