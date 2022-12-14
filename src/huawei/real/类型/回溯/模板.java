package huawei.real.类型.回溯;


/**
 * 回溯和递归是相辅相成的
 * 回溯法其实就是暴力查找，并不是什么高效的算法。
 *
 * 组合问题：N个数里面按一定规则找出k个数的集合
 * 排列问题：N个数按一定规则全排列，有几种排列方式
 * 切割问题：一个字符串按一定规则有几种切割方式
 * 子集问题：一个N个数的集合里有多少符合条件的子集
 * 棋盘问题：N皇后，解数独等等
 */
public class 模板 {

    /**backtracking这里自己调用自己，实现递归。
     * for循环就是遍历集合区间，可以理解一个节点有多少个孩子，这个for循环就执行多少次
     * for循环可以理解是横向遍历，backtracking（递归）就是纵向遍历，这样就把这棵树全遍历完了，一般来说，搜索叶子节点就是找的其中一个结果了。
     *
     *void backtracking(参数){
     *         if(终止条件){
     *             存放结果;
     *             return;
     *         }
     *         for(选择：本层集合中元素（树中节点孩子的数量就是集合的大小）){
     *             处理节点;
     *             backtracking(路径，选择列表);
     *             回溯，撤销处理结果;
     *         }
     *     }
     */


}
