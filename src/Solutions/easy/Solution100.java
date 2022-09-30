package Solutions.easy;

/**
 * 100. 相同的树，判断两个二叉树是否相同
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */

public class Solution100 {
    //二叉树结构
    public static class TreeNode {
        //数据
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
    /**
     * 节点为空的情况有：
     *
     * 1、一个为空二叉树，一个非空二叉树--》直接返回false
     * tree1为空，tree2不为空，不对称，return false
     * tree1不为空，tree2为空，不对称 return false
     * 2、两个都是空二叉树，直接返回true
     * tree1，tree2都为空，对称，返回true
     *
     * 3、两个都是非空二叉树，判断数的数据、左右子树是否相同
     * 此时已经排除掉了节点为空的情况，那么剩下的就是tree1和tree2不为空的时候：
     * tree1、tree2都不为空，比较节点数值，不相同就return false
     *
     * 用递归解法，不断的从左中右遍历判断数据是否相同，一旦有不相同则返回false
     *
     * 确定单层递归的逻辑
     * 比较二叉树是否相同 ：传入的是tree1的左孩子，tree2的右孩子。
     * 如果左右都相同就返回true ，有一侧不相同就返回false 。
     *
     * @param p
     * @param q
     * @return
     */
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //
    //     //1、节点为空
    //     if (p == null && q == null){
    //         return true;
    //     }
    //
    //     //2、两个都是非空二叉树，判断数的数据、左右子树是否相同
    //
    //
    //     //3、一个为空二叉树，一个非空二叉树--》直接返回false
    //     return false;
    // }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //1、节点为空
        if (p == null && q == null) {
            return true;
        }
        //3、一个为空二叉树，一个非空二叉树--》直接返回false
        else if (q == null || p == null) {
            return false;
        }
        //2、两个都是非空二叉树，判断数的数据、左右子树是否相同
        else if (q.val != p.val) {
            return false;
        }

        //开始递归
        //判断左子树
        boolean leftEq = isSameTree(q.left, p.left);
        //判断右子树
        boolean rightEq = isSameTree(q.right, p.right);

        return leftEq && rightEq;
    }



     public static void main(String[] args) {

         Solution100 solution100 = new Solution100();

         //构造二叉树1
         TreeNode tree1 = new TreeNode(1);
         //第一层左右子树
         tree1.left = new TreeNode(2);
         tree1.right = new TreeNode(3);
         //第二层左子树的左子树
         tree1.left.left= new TreeNode(4);
         //第二层左子树的右子树
         tree1.left.right = new TreeNode(5);
         //第二层右子树的左子树
         tree1.right.left = new TreeNode(6);
         //第二层右子树的右子树
         tree1.right.right = new TreeNode(7);

         //构造二叉树2
         TreeNode tree2 = new TreeNode(1);
         //表示左子树空节点，q = [1,null,2]
         tree2.left = new TreeNode();
         tree2.right = new TreeNode(2);

         System.out.println(solution100.isSameTree(tree1, tree2));
     }
}
