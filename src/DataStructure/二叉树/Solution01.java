package DataStructure.二叉树;

/**
 * 剑指offer27：二叉树的镜像
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 输入
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 解题思路：递归左右子树的镜像，借助个临时节点暂时存储左（右）节点。
 */
public class Solution01 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

     public static void main(String[] args) {
         Solution01 solution01 = new Solution01();
         TreeNode treeNode = new TreeNode(10);
         TreeNode mirrorTree = solution01.mirrorTree(treeNode);
         System.out.println(mirrorTree);
     }

}
