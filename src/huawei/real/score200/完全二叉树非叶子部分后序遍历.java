package huawei.real.score200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述：
 * 给定一个以顺序储存结构存储整数值的完全二叉树序列（最多1000个整数），请找出此完全二叉树的所有非叶子节点部分，然后采用后序遍历方式将此部分树（不包含叶子）输出。
 *
 * 1、只有一个节点的树，此节点认定为根节点（非叶子）。
 *
 * 2、此完全二叉树并非满二叉树，可能存在倒数第二层出现叶子或者无右叶子的情况
 *
 * 其他说明：二叉树的后序遍历是基于根来说的，遍历顺序为：左-右-根
 *
 * 输入描述
 * 一个通过空格分割的整数序列字符串
 *
 * 输出描述
 * 非叶子部分树结构
 *
 * 示例 1：
 * 输入
 * 1 2 3 4 5 6 7
 * 1
 * 输出
 * 2 3 1
 * 1
 * 说明
 * 找到非叶子部分树结构，然后采用后序遍历输出
 *
 * 思路分析：
 * 这道题首先考察二叉树的结构，是选择用类去构造二叉树的结构，还是直接使用数组去表示二叉树的结构，这里两种方法都实现一下。
 *
 * Node类构造数据结构，在用leetcode刷题时，都是构造好的二叉树，只需要直接调用即可，这里可以通过这道题学习一下自己构造二叉树的结构。
 * 数组实现二叉树，因为这道题是一棵完全二叉树，所以不需要用-1去判断位置是不是空节点，左右子树的节点分别存储在下标2N和2N+1。
 * 然后就是删除叶子节点，后序遍历，这些都是二叉树的常规算法思路。可以直接使用递归方法去实现。
 * ————————————————
 * 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/124107075
 */
public class 完全二叉树非叶子部分后序遍历 {
    /**
     * 数组实现二叉树数据结构
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        List<Integer> res = new ArrayList<>();
        for (String s : str) {
            res.add(Integer.parseInt(s));
        }
        List<Integer> index = new ArrayList<>();
        dfs(res, 0, index);
        res.removeAll(index);  // 需要注意删除对应索引数据的问题
        List<String> ans = new ArrayList<>();
        postTravel(res, 0, ans);  // 递归后序遍历
        System.out.print(String.join(" ", ans));

    }
    private static void dfs(List<Integer> res, int idx, List<Integer> index) {  // 返回叶子节点对应索引
        if (idx >= res.size()) {
            return;
        }
        if (isLeaf(res, idx)) {
            index.add(res.get(idx));
        } else {
            dfs(res, 2 * idx + 1, index);  // 递归左叶子节点
            dfs(res, 2 * idx + 2, index);  // 递归右叶子节点
        }
    }
    private static boolean isLeaf(List<Integer> res, int idx) {  // 判断是否是叶子节点
        return ((2 * idx + 1 >= res.size() ) && (2 * idx + 2 >= res.size()));
    }
    private static void postTravel(List<Integer> res, int idx, List<String> p) { // 递归后序遍历
        if (idx >= res.size()) {
            return;
        }
        postTravel(res, 2 * idx + 1, p);
        postTravel(res, 2 * idx + 2, p);
        p.add(String.valueOf(res.get(idx)));
    }

}
