package DataStructure.二叉树;

/**
 *二叉树在算法中也是比较常用的数据结构，根据二叉树的遍历算法，在算法题中遇到二叉树经常优先考虑递归算法。
 * 同时二叉树中的二叉搜索树也是常用的，主要结合中序遍历有序的特性
 * 二叉树的定义 和链表是差不多的，相对于链表 ，二叉树的节点里多了一个指针， 有两个指针，指向左右孩子
 *
 * 二叉树遍历主要分为前序、中序、后序和层次遍历
 * 前序遍历：中（根）左右
 * 中序遍历：左中右
 * 后序遍历：左右中
 *
 * 二叉树的深度优先搜索（DFS）和广度优先搜索（BFS）
 * DFS:先往深走，遇到叶子节点再往回走，从上到下，前中后序遍历都是DFS
 *
 * BFS:一层一层的去遍历,层次遍历是bfs
 *
 */
public class TreeNode {

    int val;
    //左子树
    TreeNode left;
    //右子树
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

