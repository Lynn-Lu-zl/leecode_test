package DataStructure.集合.Collection.List.LinkedList;


/**
 * 定义一个内部类，链表结点
 * 链表结点结构
 * 每个结点都有两个值
 * val结点值
 * next 结点指针
 */
public class ListNode {
    //定义一个结点值
    public int val;
    //定义一个结点指针
    public ListNode next;
    //空构造器
    public ListNode() {}
    //带参构造，ListNode赋值方法
    public ListNode(int val)
    {
        this.val = val;
    }
    //带参构造
    public ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }

    /**
     * 遍历链表
     */
    public void printList(){
        ListNode tmp=this;
        //遍历输出 next的val
        while(tmp!=null){
            System.out.print(tmp.val);
            if(tmp.next!=null) {
                System.out.print("->");
            }
            tmp=tmp.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}



