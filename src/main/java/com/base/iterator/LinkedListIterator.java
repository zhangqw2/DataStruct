package com.base.iterator;

import com.base.node.LinkedList;
import com.base.node.Node;

public class LinkedListIterator implements Iterator {
    /**
     * 链接表
     */
    private LinkedList list;
    /**
     * 当前结点
     */
    private Node current;
    public LinkedListIterator(LinkedList list){
        this.list = list;
        //若列表为空则当前元素为空，否则从第一个元素开始
        if(list.isEmpty()){
            current = null;
        }else {
            current = list.first();
        }
    }

    /**
     * 移动到第一个元素
     */
    @Override
    public void first() {
        if(list.isEmpty()){
            current = null;
        }else{
            current = list.first();
        }

    }

    /**
     * 移动到下一个元素
     */
    @Override
    public void next() {
        if(isDone()){
            throw new IndexOutOfBoundsException("已经没有元素了");
        }
        if(current==list.last()){
            current=null;
        }else {
            current=list.getNext(current);
        }

    }

    /**
     * 检查迭代器中是否还有剩余元素
     * @return
     */
    @Override
    public boolean isDone() {
        return current==null;
    }

    /**
     * 返回当前元素
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Object currentItem() throws IndexOutOfBoundsException{
        if(isDone()){
            throw new IndexOutOfBoundsException("已经没有元素了");
        }

        return current.getData();
    }
}
