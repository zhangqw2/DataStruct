package com.base.stack;

import com.base.exception.StackEmptyException;
import com.base.node.SLNode;

public class StackSLinked implements Stack {
    /**
     * 链表首结点引用
     */
    private SLNode top;
    /**
     * 栈的大小
     */
    private int size;

    public StackSLinked(){
        top = null;
        size = 0;
    }


    /**
     *  返回堆栈的大小
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断堆栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 数据元素e入栈
     * @param e
     */
    @Override
    public void push(Object e) {
        SLNode q = new SLNode(e,top);
        top = q;
        size++;
    }

    /**
     * 栈顶元素出栈
     * @return
     * @throws StackEmptyException
     */
    @Override
    public Object pop() throws StackEmptyException {
        if(size < 1){
            throw new StackEmptyException("堆栈为空");
        }
        Object obj = top.getData();
        top = top.getNext();
        size--;
        return obj;
    }

    /**
     * 取栈顶元素
     * @return
     * @throws StackEmptyException
     */
    @Override
    public Object peek() throws StackEmptyException {
        if(size<1){
            throw new StackEmptyException("堆栈为空");
        }
        return top.getData();
    }
}
