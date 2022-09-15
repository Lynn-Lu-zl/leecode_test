package huawei.real.score200;

import java.util.*;

/**
 * 在一颗二叉树中找出完全相同的两颗子树（子树层数必须大于或者等于2）。如果存在多对子树完全相同，返回层数最大的子树，如果不存在输出“-1”
 * 与leetcode652的改编：自己处理输入+最大的子树
 */
public class 寻找完全相同的子树 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] strArr=input.substring(1,input.length()-1).split(",");
        TreeNode treeNode = Deserialize(strArr,0);
        List<TreeNode> list=findDuplicateSubtrees(treeNode);
        String result=null;
        int max=0;
        for(int i=0;i<list.size();i++){
            String str=Serialize(list.get(i));
            if(str.length()>max){
                result=str; }
            max=Math.max(max,str.length()); }
        if(result==null || result.length()<=2){
            System.out.println("-1"); }
        else{
            System.out.println("["+result.substring(0,result.length()-1)+"]"); }
    }
    static Map<String, Integer> count;
    static List<TreeNode> ans;
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans; }
    public static String collect(TreeNode node) {
        if (node == null) return "null";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)
            ans.add(node);
        return serial; }

    //层次序列化
    public static String Serialize(TreeNode root) {
        if(root == null){
            return null; }
        StringBuffer sb = new StringBuffer();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        int count = (1 << treeDepth(root)) - 1;//计数，拿到此树的深度后计算对应完全二叉树节点数
        list.add(root);
        count--;
        TreeNode tmpNode = null;
        //层次遍历二叉树，开始序列化
        while(list.size() > 0 && count >= 0){
            tmpNode = list.remove(0);
            if(tmpNode != null){
                sb.append(tmpNode.val+",");
                list.add(tmpNode.left);
                list.add(tmpNode.right);
            }else{
                sb.append("null,");//#作为空节点占位符
                list.add(null);
                list.add(null); }
            count --; }
        return sb.toString(); }
    public static int treeDepth(TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }else{
            int lDepth = treeDepth(root.left) + 1;
            int rDepth = treeDepth(root.right) + 1;
            return lDepth > rDepth ? lDepth : rDepth; } }
    //层次序列化还原
    public static TreeNode Deserialize(String[] strings, int index){
        TreeNode newNode = null;
        if(index < strings.length){
            if(!strings[index].equals("null")){
                newNode = new TreeNode(Integer.parseInt(strings[index]));
                newNode.left = Deserialize(strings, 2 * index + 1);
                newNode.right = Deserialize(strings, 2 * index + 2); } }
        return newNode; }
}
