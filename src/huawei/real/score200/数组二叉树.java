package huawei.real.score200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述：
 * 二叉树也可以用数组来存储，给定一个数组，树的根节点的值存储在下标1，对于存储在下标N的节点，它的左子节点和右子节点分别存储在下标2N和2N+1，并且我们用值-1代表一个节点为空。
 *
 * 给定一个数组存储的二叉树，试求从根节点到最小的叶子节点的路径，路径由节点的值组成。
 *
 * 输入描述
 * 输入一行为数组的内容，数组的每个元素都是正整数，元素间用空格分隔。
 * 注意第一个元素即为根节点的值，即数组的第N个元素对应下标N，下标0在树的表示中没有使用，所以我们省略了。
 * 输入的树最多为7层。
 * 输出描述
 * 输出从根节点到最小叶子节点的路径上，各个节点的值，由空格分隔，用例保证最小叶子节点只有一个。
 *
 * 示例 1：
 * 输入
 * 3 5 7 -1 -1 2 4

 * 输出
 * 3 7 2

 * 说明
 * 最小叶子节点的路径为3 7 2
 *
 * 示例 2：
 * 输入
 * 5 9 8 -1 -1 7 -1 -1 -1 -1 -1 6
 * 1
 * 输出
 * 5 8 7 6
 * 1
 * 说明
 * 最小叶子节点的路径为5 8 7 6，注意数组仅存储至最后一个非空节点，故不包含节点“7”右子节点的-1
 *
 * 思路分析：
 * 这道题要计算从根节点到最小的叶子节点的路径，首先二叉树找满足条件的子树，会优先想到dfs，递归找左右子树。然后就是叶子节点的判断，叶子节点所有父节点的查找。
 *
 * 同时，二叉树是用数组表示的，就可以只按照2N和2N+1来判断左右子树。

 */
public class 数组二叉树 {
    /**
     * 叶子节点的判断
     * return (2 * idx + 1 >= res.size() || res.get(2 * idx + 1) == -1)
     *     && (2 * idx + 2 >= res.size() || res.get(2 * idx + 2) == -1);
     *
     * 叶子节点所有父节点的查找
     * while (idx > 0) {  // 找到最小叶子节点的所有父节点的索引
     *     arr.add(res.get(idx));
     *     idx = (idx - 1) / 2;
     * }
     * @param args
     */
    public static void main(String[] args) {
        //数组二叉树,二叉树也可以用数组来存储
        Scanner in = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        String[] str = in.nextLine().split(" ");
        for (String s : str) {
            res.add(Integer.parseInt(s)); }
        int idx = dfs(res, 0);  // 找到叶子节点的索引
        List<Integer> arr = new ArrayList<>();  //存储根节点到最小叶子节点路径上的所有节点
        while (idx > 0) {  // 找到最小叶子节点的所有父节点的索引
            arr.add(res.get(idx));
            idx = (idx - 1) / 2; }
        arr.add(res.get(0));  // 加入根节点
        Collections.reverse(arr);  // 反转list
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) {
                System.out.print(arr.get(i));
            } else {
                System.out.print(arr.get(i) + " "); } } }
    private static int dfs(List<Integer> res, int idx) {  // 返回最小叶子节点对应索引
        if (isLeaf(res, idx)) {
            return idx;
        } else {
            int idx_left = dfs(res, 2 * idx + 1);  // 递归左叶子节点
            int idx_right = dfs(res, 2 * idx + 2); // 递归右叶子节点
            if (idx_left >= res.size() || res.get(idx_left) == -1) {  // 只有右叶子节点
                return idx_right;
            } else if (idx_right >= res.size() || res.get(idx_right) == -1) {  // 只有左叶子节点
                return idx_left;
            } else {  // 左右叶子节点都有，找最小的
                return res.get(idx_left) < res.get(idx_right) ? idx_left : idx_right; } } }
    private static boolean isLeaf(List<Integer> res, int idx) {  // 判断是否是叶子节点
        return (2 * idx + 1 >= res.size() || res.get(2 * idx + 1) == -1)
            && (2 * idx + 2 >= res.size() || res.get(2 * idx + 2) == -1); }

}
