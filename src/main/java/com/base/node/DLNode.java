package com.base.node;

public class DLNode implements Node {
    private Object element;
    private DLNode pre;
    private DLNode next;

    public DLNode(){
        this(null,null,null);
    }

    public DLNode(Object ele,DLNode pre,DLNode next){
        this.element = ele;
        this.pre = pre;
        this.next = next;
    }

    public DLNode getNext(){
        return next;
    }

    public DLNode getPre(){
        return pre;
    }

    @Override
    public Object getData() {
        return element;
    }

    @Override
    public void setData(Object obj) {
        element = obj;
    }
}
