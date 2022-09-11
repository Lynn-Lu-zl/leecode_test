package DataStructure.链表.双链表节点;

public class Node {
    public Object e;
    public Node next;
    public Node pre;
    public Node(){

    }
    public Node(Object e){
        this.e = e;
        next = null;
        pre = null;
    }
}

