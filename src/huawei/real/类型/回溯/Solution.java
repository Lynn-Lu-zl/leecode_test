package huawei.real.score100.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *你可以按 任何顺序 返回答案
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class Solution {


    /**
     * 法一
     */
    // List<List<Integer>> result = new ArrayList<>();
    // LinkedList<Integer> path = new LinkedList<>();
    //
    // public List<List<Integer>> combine(int n, int k) {
    //     combineHelper(n, k, 1);
    //     return result;
    // }
    //
    // /**
    //  * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
    //  * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
    //  */
    // private void combineHelper(int n, int k, int startIndex){
    //     //终止条件
    //     if (path.size() == k){
    //         result.add(new ArrayList<>(path));
    //         return;
    //     }
    //     for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
    //         path.add(i);
    //         combineHelper(n, k, i + 1);
    //         path.removeLast();
    //     }
    // }

    /**
     * 法二
     * @param n
     * @param k
     * @return
     */
    // public List<List<Integer>> combine(int n, int k) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if (k <= 0 || n < k) {
    //         return res;
    //     }
    //     Deque<Integer> path = new ArrayDeque<>();
    //     //
    //     dfs(n, k, 1, path, res);
    //
    //     return res;
    // }
    // private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
    //     if (path.size() == k) {
    //         //对于每次添加的单个排列，应该都是不同的引用对象
    //         res.add(new ArrayList<>(path));
    //         return;
    //     }
    //     for (int i = begin; i <= n; i++) {
    //         path.addLast(i);
    //         System.out.println("递归之前 => " + path);
    //         //调用自身，进入下一层（递归）
    //         dfs(n, k, i + 1, path, res);
    //         //从深层节点向浅层节点回溯
    //         path.removeLast();
    //         System.out.println("递归之后 => " + path);
    //     }
    // }
    // public static void main(String[] args) {
    //     Solution solution = new Solution();
    //     int n = 5;
    //     int k = 3;
    //     //
    //     List<List<Integer>> res = solution.combine(n, k);
    //     System.out.println(res);
    // }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();            //排列组合结果
        LinkedList<Integer> path = new LinkedList<>();                     //单个排列
        dfs(res,nums,path);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, LinkedList<Integer> path){
        if(path.size() == nums.length){
            res.add( new ArrayList<Integer>(path) );     //对于每次添加的单个排列，应该都是不同的引用对象
        }
        for(int i=0; i<nums.length; i++){
            if(path.contains(nums[i]))  {continue;}              //当前层中，已添加的数不再考虑
            path.add(nums[i]);                                   //未添加的数则存放
            dfs(res, nums, path);               //进入下一层（递归）
            path.removeLast();                                  //从深层节点向浅层节点回溯
        }
    }

     public static void main(String[] args) {
         Solution solution = new Solution();
         int[] ints = {1,2,5};
         List<List<Integer>> permute = solution.permute(ints);
         System.out.println(permute);
     }



}



