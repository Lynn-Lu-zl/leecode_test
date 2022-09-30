package Solutions.easy.TreeNodeDemo;

import Solutions.easy.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Solution144 {

    /**
     * 法一
     * 递归
     * @param args
     */
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     ArrayList<Integer> result = new ArrayList<Integer>();
    //     //调用递归方法
    //     preOrder(root, result);
    //     return result;
    // }
    // void preOrder(TreeNode root, ArrayList<Integer> result) {
    //     if (root == null) {
    //         return;
    //     }
    //     //前序遍历，放在前面
    //     result.add(root.val);           // 注意这一句
    //     preOrder(root.left, result);
    //     preOrder(root.right, result);
    // }


    /**
     * 法二
     * 迭代
     * @param
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }




     public static void main(String[] args) {
        //构造二叉树2
         TreeNode tree2 = new TreeNode(5);
         //表示左子树空节点，q = [1,null,2]
         tree2.left = new TreeNode(4);
         tree2.right = new TreeNode(6);
         tree2.left.left= new TreeNode(2);
         tree2.left.right= new TreeNode(1);

         Solution144 solution144 = new Solution144();
         System.out.println(solution144.preorderTraversal(tree2));

     }
}
