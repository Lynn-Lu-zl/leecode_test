package Method.背包;

/**
 * 01背包问题
 * 物品只有一件放进背包
 *
 * 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 */
public class bag {

    public static void testweightbagproblem(int[] weight, int[] value, int bagsize){
        //背包容量，所获价值
        int wlen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagsize + 1];

        //初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= wlen; i++){
            dp[i][0] = value0;
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wlen; i++){
            for (int j = 1; j <= bagsize; j++){
                //如果当前的物品i重量大于背包容量时--》说明物品i放不进背包--》拿不放物品i前所获得的最大价值
                if (weight[i - 1] > j  ){
                    //dp[i - 1][j]表示不放物品i所获得的最大价值，即从[0,i-1]之间物品随便取放进容量为j的背包的最大价值，如重量为3的背包，物品2重量是4背包放不下，那我就任取重量为1的物品0或者重量为3的物品1中最大价值的物品2放进背包
                    dp[i][j] = dp[i - 1][j];
                }else{
                    //如果当前的物品重量小于等于背包容量--》说明物品i可以放得下背包--》比较当前物品重量的价值和之前的物品能获得的最大价值谁更大--》如果说这个物品虽然放的下背包但是价值还没有我之前安排好的物品最大价值高，哪怕背包能塞下这个物品也不要它--》重量为4的物品2价值30，虽然可以拿，但是比不过我拿一个物品0+物品1加起来价值为35.所以还是选择物品0+物品1放进背包
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= wlen; i++){
            for (int j = 0; j <= bagsize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    /**
     * 滚动数组，将二维化成一维
     * @param
     */

    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }

    public static void main(String[] args) {

        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 5;
        //二维数组
        //testweightbagproblem(weight, value, bagsize);

        //滚动数组
        testWeightBagProblem(weight,value ,bagsize);
    }
}
